package com.yvaldm.myday.mydaybackend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ActionsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnListOfActions() throws Exception {

        mvc.perform(get("/actions"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[*].name", containsInAnyOrder("Smoke", "Run", "Swim", "Read", "Drive car", "Walk", "Drink alcohol")));
    }
}