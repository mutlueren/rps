package com.example.rps;

import com.example.rps.service.RpsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RpsApplicationTests {

    @InjectMocks
    RpsService rpsService;

    @Test
    void rpsBrain_rock_test() {
        String response = rpsService.rpsBrain("rock");
        assertNotNull(response);
    }

    @Test
    void rpsBrain_paper_test() {
        String response = rpsService.rpsBrain("paper");
        assertNotNull(response);
    }

    @Test
    void rpsBrain_scissors_test() {
        String response = rpsService.rpsBrain("scissors");
        assertNotNull(response);
    }

    @Test
    void rpsBrain_wrong_test() {
        String response = rpsService.rpsBrain("undefined");
        assertEquals("You insert a wrong choice!",response);
    }

}
