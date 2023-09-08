package com.project.mutualDivorce.Controller;
import com.project.mutualDivorce.Dto.UserDto;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/findAll")
    public List<UserDto> findAll(){
        return userService.findAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<Optional<User>> findById(@PathVariable long id){
        return Optional.ofNullable(userService.findById(id));
    }
    @GetMapping("/username")
    public Optional<User> findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }
    @PostMapping()
    public User save(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        return userService.saveUser(userDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        try {
            userService.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user.");
        }
    }
    @PostMapping(path= "/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
        User user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
//    @GetMapping("/registeredUsers")
//    public String registeredUsers(Model model) {
//        List<UserDto> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "registeredUsers";
//    }


}


