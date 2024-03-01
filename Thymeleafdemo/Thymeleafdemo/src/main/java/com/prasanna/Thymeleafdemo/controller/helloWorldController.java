package com.prasanna.Thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class helloWorldController {

    // show initial html form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @PostMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model){
        model.addAttribute("TheName", request.getParameter("studentName").toUpperCase());
        return "Vanakkamulagam";
    }


    // process the html form


}
