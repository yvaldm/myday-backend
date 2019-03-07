package com.yvaldm.myday.mydaybackend.controller;

import com.yvaldm.myday.mydaybackend.config.TestEmbeddedConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class ActionsControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldRetrieveAction() throws Exception {

        // act
        mvc.perform(get("/actions")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());
    }
}