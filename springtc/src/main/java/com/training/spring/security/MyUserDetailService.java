package com.training.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDao                    ud;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public MyUserDetailService() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(final String usernameParam) throws UsernameNotFoundException {
        Kullanici user = this.ud.findById(usernameParam)
                                .orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User yok");
        }

        return User.builder()
                   .password(this.bCryptPasswordEncoder.encode(user.getPassword()))
                   .username(usernameParam)
                   .roles(user.getRole())
                   .build();
    }

}
