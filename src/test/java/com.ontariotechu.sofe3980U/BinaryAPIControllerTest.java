package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
public void testMultiplyAPI() throws Exception {
    mockMvc.perform(get("/multiply")
            .param("operand1", "101")
            .param("operand2", "11"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
}

@Test
public void testOrJsonAPI() throws Exception {
    mockMvc.perform(get("/or_json")
            .param("operand1", "1000")
            .param("operand2", "0011"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value("1011"))
            .andExpect(jsonPath("$.operation").value("|"));
}

@Test
public void testAndZeroAPI() throws Exception {
    mockMvc.perform(get("/and")
            .param("operand1", "101010")
            .param("operand2", "000000"))
            .andExpect(status().isOk())
            .andExpect(content().string("000000"));
}
}