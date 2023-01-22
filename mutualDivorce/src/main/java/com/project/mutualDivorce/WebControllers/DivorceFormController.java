package com.project.mutualDivorce.WebControllers;

import com.project.mutualDivorce.Entity.Divorce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DivorceFormController {
    @GetMapping("/divorceForm")
    public String getDivorceForm(Model model) {
        model.addAttribute("divorceForm", new Divorce());
        return "divorceForm";
    }
}
