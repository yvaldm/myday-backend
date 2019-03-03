package com.yvaldm.myday.mydaybackend.config;


import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.postgresql.Driver;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@TestConfiguration
public class TestEmbeddedConfig {

    @Bean(destroyMethod = "close")
    public EmbeddedPostgres embeddedPostgres() throws IOException, SQLException {
        EmbeddedPostgres p = EmbeddedPostgres.builder().setPort(30666)
            .setLocaleConfig("locale", "ru_RU.UTF-8").start();
        p.getPostgresDatabase().getConnection().createStatement().execute("DROP DATABASE IF EXISTS public");
        p.getPostgresDatabase().getConnection().createStatement().execute("CREATE DATABASE public");
        return p;
    }

    @Bean
    public DataSource dataSource(EmbeddedPostgres postgres) {
        return new SimpleDriverDataSource(new Driver(), postgres.getJdbcUrl("postgres", "public"));
    }

    @Bean
    public JdbcTemplate jdbcTemplate(EmbeddedPostgres postgres) {
        return new JdbcTemplate(dataSource(postgres));
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(EmbeddedPostgres postgres) {
        return new NamedParameterJdbcTemplate(dataSource(postgres));
    }
}
