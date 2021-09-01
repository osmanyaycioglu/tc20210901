package com.training.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.training.spring.prop.AppProperties;

@Configuration
public class GreetConfig {

    @Autowired
    private Environment   env;

    @Value("${app.prop.language}")
    private String        lang;

    @Value("#{appProperties.currentLanguage.shortName}")
    private String        lang2;

    @Autowired
    private AppProperties apc;

    @Bean
    @Qualifier("dyn")
    public IGreet createGreet() {
        System.out.println(this.apc);
        switch (this.apc.getCurrentLanguage()
                        .getShortName()) {
            case "eng":
                return new GreetEng();
            case "tr":
                return new GreetTr();
            case "esp":
                return new GreetFRomConstructor("ola");
            case "jp":
                return new GreetFRomConstructor("haa");
            default:
                return new GreetEng();
        }

    }

    @Bean
    @Profile("english")
    @Qualifier("prof")
    public IGreet createGreet1() {
        return new GreetEng();
    }

    @Bean
    @Profile("turkish")
    @Qualifier("prof")
    public IGreet createGreet2() {
        return new GreetTr();
    }

    @Bean
    @Profile("spanish")
    @Qualifier("prof")
    public IGreet createGreet3() {
        return new GreetFRomConstructor("ola");
    }

    @Bean
    @Profile("japan")
    @Qualifier("prof")
    public IGreet createGreet4() {
        return new GreetFRomConstructor("haa");
    }

    //    @Bean
    //    @Qualifier("dyn")
    //    public IGreet createGreet() {
    //        switch (this.lang) {
    //            case "eng":
    //                return new GreetEng();
    //            case "tr":
    //                return new GreetTr();
    //            case "esp":
    //                return new GreetFRomConstructor("ola");
    //            case "jp":
    //                return new GreetFRomConstructor("haa");
    //            default:
    //                return new GreetEng();
    //        }
    //
    //    }

    //    @Bean
    //    @Qualifier("dyn")
    //    public IGreet createGreet() {
    //        String propertyLoc = this.env.getProperty("app.prop.language");
    //        switch (propertyLoc) {
    //            case "eng":
    //                return new GreetEng();
    //            case "tr":
    //                return new GreetTr();
    //            case "esp":
    //                return new GreetFRomConstructor("ola");
    //            case "jp":
    //                return new GreetFRomConstructor("haa");
    //            default:
    //                return new GreetEng();
    //        }
    //
    //    }

}
