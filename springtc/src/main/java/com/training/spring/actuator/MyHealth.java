package com.training.spring.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.training.spring.prop.Language;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        Language languageLoc = new Language();
        languageLoc.setName("English");
        languageLoc.setShortName("eng");
        languageLoc.setDesc("İngilizce dili");
        return Health.up()
                     .withDetail("sonuç",
                                 new Language().setName("English")
                                               .setShortName("eng")
                                               .setDesc("İngilizce Dili"))
                     .build();
    }

}
