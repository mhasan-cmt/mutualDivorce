package com.project.mutualDivorce.WebControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/userRegistration")
    public String register(){
        return "userRegistration";
    }
}
