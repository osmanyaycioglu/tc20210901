package com.training.spring.rest.http.scopes;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
//@RequestScope
// @Scope("prototype")
public class MyCounter implements Serializable {

    private long counter;

    public long getCounter() {
        return this.counter++;
    }

    public void setCounter(final long counterParam) {
        this.counter = counterParam;
    }


}
