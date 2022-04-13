package com.group5.activitytrackergroup5task.controllers;

import com.group5.activitytrackergroup5task.models.Todo;
import com.group5.activitytrackergroup5task.services.PersonService;
import com.group5.activitytrackergroup5task.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
