package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deneme.MyBean;
import com.training.spring.di.IGreet;

@RestController
@RequestMapping("/first")
// @RequestScope
public class MyFirstRest {

    @Autowired
    @Qualifier("dyn")
    //@Qualifier("prof")
    private IGreet greet;

    @Autowired
    private MyBean mBean;

    @GetMapping("/hello")
    public String hello() {
        return this.greet.greet("osman");
    }

    @GetMapping("/hello2")
    public String hello2() {
        return this.mBean.hello();
    }

}
