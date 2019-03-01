package com.yvaldm.myday.mydaybackend.config;

import com.yvaldm.myday.mydaybackend.service.ActionService;
import com.yvaldm.myday.mydaybackend.service.impl.ActionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDayConfig {

    @Bean
    public ActionService actionService() {
        return new ActionServiceImpl();
    }

}
