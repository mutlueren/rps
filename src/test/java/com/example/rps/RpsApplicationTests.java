package com.example.rps;

import com.example.rps.service.RpsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RpsApplicationTests {

    @InjectMocks
    RpsService rpsService;

    @Test
    void rpsBrain_rock_test() {
        String response = rpsService.rpsBrain("rock");
        assertNotNull(response);
        assertNotEquals("You insert a wrong choice!",response);
    }

    @Test
    void rpsBrain_paper_test() {
        String response = rpsService.rpsBrain("paper");
        assertNotNull(response);
        assertNotEquals("You insert a wrong choice!",response);
    }

    @Test
    void rpsBrain_scissors_test() {
        String response = rpsService.rpsBrain("scissors");
        assertNotNull(response);
        assertNotEquals("You insert a wrong choice!",response);
    }

    @Test
    void rpsBrain_undefined_test() {
        String response = rpsService.rpsBrain("undefined");
        assertEquals("You insert a wrong choice!",response);
    }

}
