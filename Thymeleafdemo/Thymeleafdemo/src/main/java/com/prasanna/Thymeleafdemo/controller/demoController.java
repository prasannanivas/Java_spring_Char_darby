package com.prasanna.Thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class demoController {

    @GetMapping("/hello")
    public String sayHello(Model model){

        model.addAttribute("TheDate", new java.util.Date());
        return "Vanakkamulagam";
    }
}
