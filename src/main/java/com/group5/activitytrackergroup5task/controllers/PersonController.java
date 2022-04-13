package com.group5.activitytrackergroup5task.controllers;
import com.group5.activitytrackergroup5task.dtos.LoginDto;
import com.group5.activitytrackergroup5task.dtos.PersonDto;
import com.group5.activitytrackergroup5task.models.Person;
import com.group5.activitytrackergroup5task.services.PersonService;
import com.group5.activitytrackergroup5task.models.Todo;
import com.group5.activitytrackergroup5task.services.PersonService;
import com.group5.activitytrackergroup5task.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class PersonController {
    private final TodoService todoService;
    private final PersonService personService;

    @Autowired
    public PersonController(TodoService todoService, PersonService personService) {
        this.todoService = todoService;
        this.personService = personService;
    }


    @PostMapping("/signup")
    public String postSignup(@ModelAttribute PersonDto personDto){
        personService.createPerson(personDto);
        return "signup";
    }
    @GetMapping("/signup")
    public String getSignup(Model model){
        PersonDto personDto = new PersonDto();
        model.addAttribute("personDto", personDto);
        return "signup";
    }

    @GetMapping("/")
    public String login (Model model){
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto", loginDto);
        return "index";
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

    @GetMapping("/home")
    public String displayTracker(Model model){
        Todo todo = new Todo();
        List<Todo> todos = todoService.getTodoList();
//        int completed = ;
//        int inprogress = ;
            model.addAttribute("todo", todo);
            model.addAttribute("todos", todos);

        return "tracker";
    }

}
