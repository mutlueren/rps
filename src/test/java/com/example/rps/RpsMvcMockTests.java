package com.example.rps;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RpsMvcMockTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void rpsMvc_rock_test() throws Exception {
        this.mockMvc.perform(get("/rps?choise=rock")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("You choose Rock")));
    }

    @Test
    public void rpsMvc_paper_test() throws Exception {
        this.mockMvc.perform(get("/rps?choise=paper")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("You choose Paper")));
    }

    @Test
    public void rpsMvc_scissors_test() throws Exception {
        this.mockMvc.perform(get("/rps?choise=scissors")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("You choose Scissors")));
    }

    @Test
    public void rpsMvc_undefined_test() throws Exception {
        this.mockMvc.perform(get("/rps?choise=undefined")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("You insert a wrong choice!")));
    }
}