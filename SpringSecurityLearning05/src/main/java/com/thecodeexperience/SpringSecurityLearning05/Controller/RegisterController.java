package com.thecodeexperience.SpringSecurityLearning05.Controller;

import com.thecodeexperience.SpringSecurityLearning05.Entity.UserAuthEntity;
import com.thecodeexperience.SpringSecurityLearning05.Service.UserAuthEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private UserAuthEntityService userAuthEntityService;

    @GetMapping
    public ResponseEntity<String> register(){
        UserAuthEntity user = UserAuthEntity.builder()
                .username("user01")
                .password(passwordEncoder.encode("pass01"))
                .role("ROLE_ADMIN")
                .build();
        userAuthEntityService.saveUser(user);
        return ResponseEntity.ok("User Registered Successfully");
    }
}

