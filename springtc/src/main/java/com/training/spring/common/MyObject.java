package com.training.spring.common;

import org.springframework.stereotype.Component;

@Component
//@Controller
//@Repository
//@Service
//@Configuration
public class MyObject {

    public String greet(final String name) {
        return "Hello " + name;
    }

}
