package com.example.firstSpringWeb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWordController {

    @GetMapping("/say")
    public String sayHello(){
        return "hello world!";
    }

    // URL'e yazılan herşey get'dir. Post url'de çağırılamaz. Postman ile çözülür.
    @PostMapping("/post")
    public String posHello(){
        return "hello world! post";
    }

}
