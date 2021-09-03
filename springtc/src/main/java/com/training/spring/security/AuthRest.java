package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRest {

    @Autowired
    private JWTService            js;

    @Autowired
    private AuthenticationManager authMan;

    @GetMapping("/login")
    public String login(@RequestParam("u") final String username,
                        @RequestParam("p") final String password) {
        Authentication authenticateLoc = this.authMan.authenticate(new UsernamePasswordAuthenticationToken(username,
                                                                                                           password));
        User user = (User) authenticateLoc.getPrincipal();
        return this.js.generateToken(user);
    }

}
