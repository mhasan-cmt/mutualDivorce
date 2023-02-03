package com.project.mutualDivorce.Controller;

import com.project.mutualDivorce.Dto.UserDto;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id){
        return userService.findById(id);
    }

    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable long id,@RequestBody User user){
        user.setId(id);
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        userService.deleteById(id);
    }
    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody UserDto userDto){
        User user = userService.createNewUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
