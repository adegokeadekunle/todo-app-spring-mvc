package com.group5.activitytrackergroup5task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @GetMapping("/")
    public String displaySignin(){
        return "index";
    }

    @GetMapping("/signup")
    public String displaySignup(){
        return "signup";
    }

    @GetMapping("/login")
    public String displayLogin(){
        return "redirect:/";
    }
}
