package com.project.mutualDivorce.Controller;

import com.project.mutualDivorce.Dto.DivorceFormDto;
import com.project.mutualDivorce.Entity.Divorce;
import com.project.mutualDivorce.Service.DivorceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/divorces")
public class DivorceController {
    @Autowired
    private DivorceService divorceService;


    @Autowired
    public DivorceController(DivorceService divorceService) {
        this.divorceService = divorceService;
    }

    @GetMapping
    public List<Divorce> findAll() {
        return divorceService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Divorce> findById(@PathVariable long id) {
        return divorceService.findById(id);
    }


    public Divorce save(@RequestBody Divorce divorce) {
        return divorceService.save(divorce);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        divorceService.deleteById(id);
    }

    @PostMapping(path = "/create-divorce-form")
    public ResponseEntity<Divorce> createDivorceForm(@RequestBody DivorceFormDto divorceFormDto) {
        Divorce divorce = divorceService.createDivorceForm(divorceFormDto);
        return new ResponseEntity<>(divorce, HttpStatus.CREATED);
    }
}