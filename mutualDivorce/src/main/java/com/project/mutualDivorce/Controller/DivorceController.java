package com.project.mutualDivorce.Controller;

import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Service.DivorceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/divorces")
public class DivorceController {
    private final DivorceService divorceService;


    @Autowired
    public DivorceController(DivorceService divorceService) {
        this.divorceService = divorceService;
    }
    @GetMapping
    public List<Divorce> findAll(){
        return divorceService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Divorce> findById(@PathVariable long id){
        return divorceService.findById(id);
    }
    @PostMapping
    public Divorce save(@RequestBody Divorce divorce){
        return divorceService.save(divorce);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        divorceService.deleteById(id);
    }
}
