package com.training.spring.inject;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deneme.MyBean;

@Component
public class InjectToMe {

    @Autowired
    private MyBean       mb;

    private final MyBean mb2;

    private MyBean       mb3;

    @Autowired
    public InjectToMe(final MyBean mbParam) {
        this.mb2 = mbParam;
    }

    @Autowired
    public void method(final MyBean mbParam) {
        this.mb3 = mbParam;
    }

    @PostConstruct
    public void zxc() {
        System.out.println("After Injections");
    }

    @PreDestroy
    public void vbn() {
        System.out.println("Before Destroy");
    }

}
