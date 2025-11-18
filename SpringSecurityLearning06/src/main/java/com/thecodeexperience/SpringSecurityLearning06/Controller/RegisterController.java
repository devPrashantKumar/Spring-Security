package com.thecodeexperience.SpringSecurityLearning06.Controller;

import com.thecodeexperience.SpringSecurityLearning06.Entity.UserAuthEntity;
import com.thecodeexperience.SpringSecurityLearning06.Service.UserAuthEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                .role("ROLE_USER")
                .build();
        UserAuthEntity user2 = UserAuthEntity.builder()
                .username("user02")
                .password(passwordEncoder.encode("pass02"))
                .role("ROLE_ADMIN")
                .build();
        userAuthEntityService.saveUser(user);
        userAuthEntityService.saveUser(user2);
        return ResponseEntity.ok("User Registered Successfully");
    }
}

