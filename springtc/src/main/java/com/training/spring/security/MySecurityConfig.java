package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService     muds;

    @Autowired
    private MyJWTTokenRequestFilter mjwtFilter;

    @Override
    protected void configure(final AuthenticationManagerBuilder authParam) throws Exception {
        authParam.userDetailsService(this.muds)
                 .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(final HttpSecurity httpParam) throws Exception {
        httpParam.authorizeRequests()
                 .antMatchers("/actuator/**",
                              "/auth/**")
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
                 .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
                 .httpBasic()
                 .disable()
                 .formLogin()
                 .disable()
                 .cors()
                 .disable()
                 .csrf()
                 .disable()
                 .logout()
                 .disable();

        httpParam.addFilterBefore(this.mjwtFilter,
                                  UsernamePasswordAuthenticationFilter.class);
    }

}
