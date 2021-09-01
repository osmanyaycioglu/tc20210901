package com.deneme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public MyBean createMyBean() {
        return new MyBean();
    }

}
