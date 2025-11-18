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
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String sayHello(){
        return "Hello ADMIN!!";
    }

}

