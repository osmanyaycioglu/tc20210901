package com.training.spring.rest.http.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@RequestMapping("/scope")
@SessionScope
public class ScopeRest {

    private long counter = 0;

    @Autowired
    MyCounter    mc;

    @Autowired
    MyCounter    mc2;


    @GetMapping("/show")
    public String show() {
        return "Local : " + this.counter++ + " external : " + this.mc.getCounter() + " , " + this.mc2.getCounter();
    }


}
