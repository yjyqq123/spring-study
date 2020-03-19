package com.soft1851.spring.ioc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class JDBCConfig {


    @Bean
    public static DruidDataSource dataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/db_class?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        source.setUsername("root");
        source.setPassword("root");
        source.setInitialSize(8);
        return source;
    }

    @Bean
    public static JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(JDBCConfig.dataSource());
        return jdbcTemplate;
    }

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = JDBCConfig.jdbcTemplate();
        String sql = "SELECT * FROM t_post";
        System.out.println(jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class)));
    }
}