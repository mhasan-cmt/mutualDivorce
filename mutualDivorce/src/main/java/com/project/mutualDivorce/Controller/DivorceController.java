package com.project.mutualDivorce.Controller;

import com.project.mutualDivorce.Dto.DivorceFormDto;
import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Service.DivorceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/divorces")
public class DivorceController {
    @Autowired
    private DivorceService divorceService;


    @Autowired
    public DivorceController(DivorceService divorceService) {
        this.divorceService = divorceService;
    }

    @GetMapping("/findAll")
    public List<Divorce> findAll() {
        return divorceService.findAll();
    }

    @GetMapping("/{id}")
    public Divorce findById(@PathVariable long id) {
        return divorceService.findById(id);
    }


    @PostMapping
    public Divorce save(@RequestBody Divorce divorce) {
        return divorceService.save(divorce);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        divorceService.deleteById(id);
    }

    @PostMapping(path = "/addForm")
    public ResponseEntity<Divorce> createDivorceForm(@RequestBody DivorceFormDto divorceFormDto,@AuthenticationPrincipal User user) {
        divorceFormDto.setUser(user);
        Divorce divorce = divorceService.createDivorceForm(divorceFormDto);
        return new ResponseEntity<>(divorce, HttpStatus.CREATED);
    }
    @GetMapping("/divorceForm")
    public String getDivorceForm(Model model) {
        model.addAttribute("divorceForm", new Divorce());
        return "divorceForm";
    }

    @GetMapping("/viewDivorceForm")
    public String viewDivorceForms(Model model, @AuthenticationPrincipal User user) {
        List<Divorce> divorceForms;
        if (user.getRoles().get(0).getName().equals("ROLE_ADMIN")) {
            divorceForms = divorceService.findAll();
        } else {
            divorceForms = divorceService.findAllByUser(user);
        }
        model.addAttribute("divorceForms", divorceForms);
        return "viewDivorceForm";
    }
    @GetMapping("/submit-divorce-form")
    public String submitDivorceForm(){
        return "/submit-divorce-form";
    }
    @GetMapping("/simvolaiografikiPraksi")
    public String simvolaiografikiPraksi(){
        return "simvolaiografikiPraksi";
    }
}