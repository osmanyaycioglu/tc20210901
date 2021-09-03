package com.training.spring.person.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@WebFilter("/api/v1/person/query/*")
public class MyFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("My Filter çalıştı : " + currentPrincipalName);
        chainParam.doFilter(requestParam,
                            responseParam);
        //        HttpServletResponse resp = (HttpServletResponse) responseParam;
        //        resp.getWriter()
        //            .print("Almıyorum seni");

    }

}
