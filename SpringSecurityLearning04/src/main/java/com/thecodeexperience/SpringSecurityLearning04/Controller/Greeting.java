package com.thecodeexperience.SpringSecurityLearning04.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class Greeting {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping
    public String sayHello(){
        return "Hello Spring Boot!!";
    }

    @GetMapping("/register")
    public void register(){
        UserDetails user = User.withUsername("user02")
                .password(new BCryptPasswordEncoder().encode("pass02"))
                .roles("ADMIN")
                .build();

        ((InMemoryUserDetailsManager)userDetailsService).createUser(user);
    }
}
