package com.yvaldm.myday.mydaybackend.config;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.service.ActionService;
import com.yvaldm.myday.mydaybackend.service.impl.ActionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDayConfig {

    @Bean
    public ActionService actionService(ActionDao actionDao) {
        return new ActionServiceImpl(actionDao);
    }

}
