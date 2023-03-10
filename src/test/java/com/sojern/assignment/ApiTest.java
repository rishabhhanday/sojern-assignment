package com.sojern.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test400BadRequest() throws Exception {
        this.mockMvc.perform(
                        get("/min")
                                .param("numbers", "1,2")
                                .param("quantifier", "3"))
                .andDo(print()).andExpect(status().is(400))
                .andExpect(jsonPath("$.errorMessage").value("Quantifier must be less than or equals to numbers size."));
    }

    @Test
    public void testMinApi() throws Exception {
        this.mockMvc.perform(
                        get("/min")
                                .param("numbers", "9,2,1")
                                .param("quantifier", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.numbers[0]").value("1"));
    }

    @Test
    public void testMaxApi() throws Exception {
        this.mockMvc.perform(
                        get("/max")
                                .param("numbers", "9,2,1")
                                .param("quantifier", "1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.numbers[0]").value("9"));
    }

    @Test
    public void testAvgApi() throws Exception {
        this.mockMvc.perform(
                        get("/avg")
                                .param("numbers", "1,2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.average").value("1.5"));
    }

    @Test
    public void testMedianApi() throws Exception {
        this.mockMvc.perform(
                        get("/median")
                                .param("numbers", "1,2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.median").value("1.5"));
    }

    @Test
    public void testPercentileApi() throws Exception {
        this.mockMvc.perform(
                        get("/percentile")
                                .param("numbers", "12,15,17,18,26,34,57,65,68,69")
                                .param("quantifier", "25"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.percentile").value("17"));
    }

    @Test
    public void testPingApi() throws Exception {
        this.mockMvc.perform(
                        get("/ping"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"));
    }

    @Test
    public void testImageApi() throws Exception {
        this.mockMvc.perform(
                        get("/img"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_GIF));
    }
}
