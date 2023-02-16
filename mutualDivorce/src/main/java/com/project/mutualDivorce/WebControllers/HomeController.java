package com.project.mutualDivorce.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/home")
    public  String home2(){
        return "home";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/submit-divorce-form")
    public String formSubmit(){
        return "submit-divorce-form";
    }
    @GetMapping("/userRegistration")
    public String register(){
        return "userRegistration";
    }
}
