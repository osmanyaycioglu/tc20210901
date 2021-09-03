package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService muds;

    @Override
    protected void configure(final AuthenticationManagerBuilder authParam) throws Exception {
        authParam.userDetailsService(this.muds)
                 .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.authorizeRequests()
                 .antMatchers("/actuator/**")
                 .permitAll()
                 .antMatchers("/first/**")
                 .hasAnyRole("USER",
                             "VIEWER",
                             "ADMIN")
                 .antMatchers("/api/v1/person/query/**")
                 .hasAnyRole("VIEWER")
                 .antMatchers("/api/v1/person/provision/**")
                 .hasAnyRole("ADMIN")
                 .anyRequest()
                 .authenticated()
                 .and()
                 .httpBasic()
                 .and()
                 .formLogin()
                 .disable()
                 .cors()
                 .disable()
                 .csrf()
                 .disable();
    }

}
