package com.training.spring.di;

public class GreetFRomConstructor implements IGreet {

    private final String prefix;

    public GreetFRomConstructor(final String prefixParam) {
        super();
        this.prefix = prefixParam;
    }

    @Override
    public String greet(final String nameParam) {
        return this.prefix + " " + nameParam;
    }

}
