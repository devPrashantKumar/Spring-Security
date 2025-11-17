package com.thecodeexperience.SpringSecurityLearning01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class Greeting {

    @GetMapping
    public String sayHello(){
        return "Hello Spring Boot!!";
    }
}
