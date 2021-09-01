package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
// @Lazy
// @Primary
@Qualifier("tr")
public class GreetTr implements IGreet {

    private long counter;

    @Override
    public String greet(final String nameParam) {
        return "Merhaba " + nameParam + " " + this.counter++;
    }

}
