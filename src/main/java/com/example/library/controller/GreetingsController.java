package com.example.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingsController {

    @GetMapping(value = {"greetings/{name}", "/greetings"})
    public String greetings(
            @PathVariable(value = "name", required = false)
                    String name) {
        if (name == null || name.isEmpty()) {
            return "Hello Spring Boot Server";
        } else {
            return "Hello " + name;
        }
    }
}
