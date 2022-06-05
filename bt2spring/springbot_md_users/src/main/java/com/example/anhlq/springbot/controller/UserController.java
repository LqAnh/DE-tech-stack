package com.example.anhlq.springbot.controller;

import com.example.anhlq.springbot.model.Users;
import com.example.anhlq.springbot.repository.UserRepository;
import com.example.anhlq.springbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public List<Users> getAllEm() {
        return userService.getAllUser();
    }

    @GetMapping("/get/{id}")
    public Users findEm(@PathVariable long id) {
        return userService.findUser(id);
    }

    @PostMapping("/cr")
    public Users crEm(@RequestBody Users employee) {
        return userService.createUser(employee);
    }

    @PutMapping("/up/{id}")
    public Users upEm(@PathVariable long id, @RequestBody Users newDetail) {
        return userService.updateUser(id, newDetail);
    }

    @DeleteMapping("/del/{id}")
    public void delEm(@PathVariable long id) {
        userService.delUser(id);
    }

}
