package com.project.mutualDivorce.WebControllers;

import com.project.mutualDivorce.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/userRegistration")
    public String getUseRegistration(Model model){
        model.addAttribute("userRegistration",new User());
        return "userRegistration";
    }
}
