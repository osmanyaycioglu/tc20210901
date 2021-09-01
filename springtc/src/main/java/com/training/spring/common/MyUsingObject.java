package com.training.spring.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.training.spring.di.IGreet;

@Component
public class MyUsingObject {

    @Autowired
    @Qualifier("greetEng")
    private IGreet myObject;

    public String sayHello(final String name) {
        return this.myObject.greet(name);
    }

}
