package com.training.spring.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    public static final String  MY_KEY_STR = "asghjfdasghfdqwyuetuyqwteuqwyghasgfdasghdfashgfhasgfd";

    @Autowired
    private MyUserDetailService muds;

    private final Key           local;

    public JWTService() {
        this.local = Keys.hmacShaKeyFor(JWTService.MY_KEY_STR.getBytes());
    }


    public String generateToken(final User userParam) {
        return Jwts.builder()
                   .setSubject(userParam.getUsername())
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                   .signWith(this.local)
                   .compact();
    }

    public String generateToken(final String username) {
        User userParam = (User) this.muds.loadUserByUsername(username);
        if (userParam == null) {
            throw new IllegalStateException("User yok");
        }
        return Jwts.builder()
                   .setSubject(userParam.getUsername())
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000)))
                   .signWith(this.local)
                   .compact();
    }

    public UserDetails getUser(final String token) {
        try {
            JwtParser parser = Jwts.parserBuilder()
                                   .setSigningKey(this.local)
                                   .build();
            Jws<Claims> parseClaimsJwsLoc = parser.parseClaimsJws(token);
            Claims bodyLoc = parseClaimsJwsLoc.getBody();
            String subjectLoc = bodyLoc.getSubject();
            UserDetails loadUserByUsernameLoc = this.muds.loadUserByUsername(subjectLoc);
            return loadUserByUsernameLoc;
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return null;
    }

}
