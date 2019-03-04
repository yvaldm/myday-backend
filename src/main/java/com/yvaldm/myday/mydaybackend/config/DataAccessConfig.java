package com.yvaldm.myday.mydaybackend.config;

import com.yvaldm.myday.mydaybackend.dao.ActionDao;
import com.yvaldm.myday.mydaybackend.dao.ActionPerformedDao;
import com.yvaldm.myday.mydaybackend.dao.impl.ActionDaoImpl;
import com.yvaldm.myday.mydaybackend.dao.impl.ActionPerformedDaoImpl;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAccessConfig {

    @Bean
    public ActionDao actionDao(DSLContext dslContext) {
        return new ActionDaoImpl(dslContext);
    }

    @Bean
    public ActionPerformedDao actionPerformedDao(DSLContext dslContext) {
        return new ActionPerformedDaoImpl(dslContext);
    }
}
