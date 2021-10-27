package com.yoho.gimnasios.controllers;

import com.yoho.gimnasios.models.Assist;
import com.yoho.gimnasios.models.Payment;
import com.yoho.gimnasios.models.User;
import com.yoho.gimnasios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/allUsers")
    public List<User> getUsers(){
        return this.userService.findAllUser();
    }

    @PostMapping(path = "/addUser")
    public User addNewUser(@RequestBody User user){
        this.userService.addNewUser(user);
        return this.userService.findAllUser().get(userService.findAllUser().size() -1);
    }

    @GetMapping(path = "/{userId}")
    public User getUserById(@PathVariable("userId") Long id){
        return this.userService.getUserById(id);
    }

    @GetMapping(path = "/userByName")
    public User getUserByName(@RequestBody User user){
        return this.userService.getUserByName(user.getName());
    }

    @GetMapping(path = "/addUserAssistance/{userId}")
    public User addUserAssistance(@PathVariable("userId") Long id){
        return this.userService.addUserAssist(id);
    }

    @GetMapping(path = "/getUserAssistance/{userId}")
    public Collection<Assist> getUserAssistance(@PathVariable("userId") Long id){
        return this.userService.getAssistsByUser(id);
    }

    @PostMapping(path = "/addUserPayment/{userId}")
    public User addUserPayment(@RequestBody Payment payment, @PathVariable("userId") Long id){
        return this.userService.addUserPayment(payment, id);
    }
}
