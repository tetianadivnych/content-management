package com.divnych.contentmanagement.controller;

import com.divnych.contentmanagement.model.UserRequest;
import com.divnych.contentmanagement.model.UserResponse;
import com.divnych.contentmanagement.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserRequest userRequest) {
        userService.saveUser(userRequest);
    }

    @GetMapping("/age/over/{age}")
    public List<UserResponse> getUsersOverAge(@PathVariable int age) {
        return userService.getUsersOverAge(age);
    }

}
