package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorldController")
public class HelloWorldController {

    @GetMapping("/hello")
    public String welcome(Model model){
        model.addAttribute("msg", "this is hello message");
        return "Hello";
    }

}