package com.final_backend.backend.contoller;

import com.final_backend.backend.controller.FlightSearchController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FlightSearchController.class)
@ContextConfiguration(classes = FlightSearchController.class)
@ComponentScan(basePackages = "com.final_backend.backend")
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSearchFlights() throws Exception {
        mockMvc.perform(post("/api/flights/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"departure\":\"NYC\",\"arrival\":\"LAX\"}"))
                .andExpect(status().isOk());
    }
}