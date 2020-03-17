package com.soft1851.spring.ioc.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import java.awt.print.Book;

@Configurable
public class AppConfig {
    @Bean
    public Book book(){
        return new Book();
    }
}
