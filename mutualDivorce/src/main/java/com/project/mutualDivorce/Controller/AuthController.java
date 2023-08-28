package com.project.mutualDivorce.Controller;

import com.project.mutualDivorce.Dto.UserDto;
import com.project.mutualDivorce.Entity.User;
import com.project.mutualDivorce.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    /*
    @GetMapping("/registeredUsers")
    public String registeredUsers(){
        return "registeredUsers";

    }

     */
    // handler method to handle home page request
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserBySurname(userDto.getSurname());

        if(existingUser!= null && existingUser.getSurname() !=null){
            result.rejectValue("Surname", null,
                    "There is already an account registered with the same username");

        }
        if(result.hasErrors()){
            model.addAttribute("user",userDto);
            return "/register";

        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }
    // handler method to handle list of users
    /*
    @GetMapping("/registeredUsers")
    public String registeredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "registeredUsers";
    }

     */
    /*
    @GetMapping("/submit-divorce-form")
    public String formSubmit(){
        return "submit-divorce-form";
    }

   @GetMapping("/divorceForm")
    public String divorceForm(){
        return "divorceForm";
   }
    @GetMapping("/simvolaiografikiPraksi")
    public String simvolaiografikiPraksi(){
        return "simvolaiografikiPraksi";
    }
*/
    @GetMapping("/viewDivorceForm")
    public String viewDivorceForm(){
        return "viewDivorceForm";
    }
    @GetMapping("/submit-divorce-form")
    public String formSubmit(){
        return "submit-divorce-form";
    }

}