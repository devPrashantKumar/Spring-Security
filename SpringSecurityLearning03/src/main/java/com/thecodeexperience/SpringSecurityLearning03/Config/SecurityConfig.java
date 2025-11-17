package com.thecodeexperience.SpringSecurityLearning03.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("user01")
//                .password("{noop}"+"pass01")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.withUsername("user02")
//                .password("{noop}"+"pass02")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("user01")
//                .password("{bcrypt}"+new BCryptPasswordEncoder().encode("pass01"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User.withUsername("user02")
//                .password("{bcrypt}"+new BCryptPasswordEncoder().encode("pass02"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2);
//    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user1 = User.withUsername("user01")
                .password(new BCryptPasswordEncoder().encode("pass01"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("user02")
                .password(new BCryptPasswordEncoder().encode("pass02"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}
