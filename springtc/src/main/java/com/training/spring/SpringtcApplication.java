package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.training.spring.di.IGreet;

@SpringBootApplication
@EnableScheduling
public class SpringtcApplication {

    @Autowired
    @Qualifier("greetTr")
    private IGreet greet;

    @Scheduled(fixedDelay = 3_000)
    public void xyz() {
        System.out.println(this.greet.greet("ayşe"));
    }

    public static void main(final String[] args) {
        //        System.getProperties()
        //              .setProperty("",
        //                           lang);
        ConfigurableApplicationContext context = SpringApplication.run(SpringtcApplication.class,
                                                                       args);

        SpringtcApplication beanLoc = context.getBean(SpringtcApplication.class);
        System.out.println(beanLoc.greet.greet("test"));

        //        SpringtcApplication applicationLoc = new SpringtcApplication();
        //        applicationLoc.muo.sayHello("test");
        //
        //
        //        MyObject myObjectLoc = new MyObject();
        //        MyUsingObject muo = new MyUsingObject();
        //        muo.setMyObject(myObjectLoc);
        //        muo.sayHello("osman");

    }

}
