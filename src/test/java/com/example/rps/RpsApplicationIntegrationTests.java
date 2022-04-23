package com.example.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RpsApplicationIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void rpsController_rock_test() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" +port+ "/rps" +"?choise="+ "rock",
                String.class)).contains("You choose Rock");
    }

    @Test
    public void rpsController_paper_test() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" +port+ "/rps" +"?choise="+ "paper",
                String.class)).contains("You choose Paper");
    }

    @Test
    public void rpsController_scissors_test() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" +port+ "/rps" +"?choise="+ "scissors",
                String.class)).contains("You choose Scissors");
    }

    @Test
    public void rpsController_undefined_test() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" +port+ "/rps" +"?choise="+ "undefined",
                String.class)).contains("You insert a wrong choice!");
    }

}
