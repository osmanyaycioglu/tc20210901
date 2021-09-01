package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
// @Lazy
@Qualifier("eng")
public class GreetEng implements IGreet {

    private long counter;

    @Override
    public String greet(final String nameParam) {
        return "Hello " + nameParam + " " + this.counter++;
    }

}
