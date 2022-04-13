package com.group5.activitytrackergroup5task.controllers;

import com.group5.activitytrackergroup5task.dtos.LoginDto;
import com.group5.activitytrackergroup5task.models.Person;
import com.group5.activitytrackergroup5task.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/")
    public String login (Model model){
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto, HttpSession session){
        Person person = personService.login(loginDto);
        if (person != null){
            session.setAttribute("user", person);
            return "redirect:/home";
        }

        return "redirect:/";
    }



//    @GetMapping("/")
//    public String displaySignin(){
//        return "index";
//    }
//
//    @GetMapping("/signup")
//    public String displaySignup(){
//        return "signup";
//    }
//
//    @GetMapping("/login")
//    public String displayLogin(){
//        return "redirect:/";
//    }
}
