package com.training.spring.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyJWTTokenRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService js;

    @Override
    protected void doFilterInternal(final HttpServletRequest requestParam,
                                    final HttpServletResponse responseParam,
                                    final FilterChain filterChainParam) throws ServletException, IOException {
        String headerLoc = requestParam.getHeader("Authorization");
        if ((headerLoc == null) || headerLoc.isEmpty()) {
            filterChainParam.doFilter(requestParam,
                                      responseParam);
        } else {
            if (!headerLoc.startsWith("Bearer")) {
                filterChainParam.doFilter(requestParam,
                                          responseParam);
            } else {
                String token = headerLoc.substring(7);
                UserDetails userLoc = this.js.getUser(token);
                if (userLoc == null) {
                    filterChainParam.doFilter(requestParam,
                                              responseParam);
                } else {
                    UsernamePasswordAuthenticationToken ua = new UsernamePasswordAuthenticationToken(userLoc.getUsername(),
                                                                                                     null,
                                                                                                     userLoc.getAuthorities());
                    ua.setDetails(new WebAuthenticationDetailsSource().buildDetails(requestParam));
                    SecurityContextHolder.getContext()
                                         .setAuthentication(ua);
                    filterChainParam.doFilter(requestParam,
                                              responseParam);
                }
            }
        }


    }

}
