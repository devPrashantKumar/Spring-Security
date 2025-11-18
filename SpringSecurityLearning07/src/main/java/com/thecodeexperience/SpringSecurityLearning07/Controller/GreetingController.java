package com.thecodeexperience.SpringSecurityLearning07.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String sayHello(){
        return "Hello Spring Boot!!";
    }
}
