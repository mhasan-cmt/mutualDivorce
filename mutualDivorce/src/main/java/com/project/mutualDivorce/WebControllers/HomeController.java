/*
package com.project.mutualDivorce.WebControllers;

import com.project.mutualDivorce.Dto.UserDtoOld;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(){
        return "login";
    }
    @GetMapping("/home")
    public  String home2(){
        return "index";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
    @GetMapping("/submit-divorce-form")
    public String formSubmit(){
        return "submit-divorce-form";
    }

    @GetMapping("/userRegistration")
    public String register(Model model) {
        UserDtoOld userDto = new UserDtoOld(null, "", 0, 0, "0", null, "");
        model.addAttribute("user",userDto); // Create a new User object for registration
        return "userRegistration";
    }
}


 */
