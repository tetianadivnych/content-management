package com.divnych.contentmanagement.controller;

import com.divnych.contentmanagement.payload.request.UserRequest;
import com.divnych.contentmanagement.payload.response.UserResponse;
import com.divnych.contentmanagement.service.UserService;
import java.util.List;
import java.util.Set;
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

    @GetMapping("/age-over/{age}")
    public List<UserResponse> getUsersByAgeOver(@PathVariable int age) {
        return userService.getUsersByAgeOver(age);
    }

    @GetMapping("/names/articles-over-3")
    public Set<String> getUserNamesByArticlesNumOver3() {
        return userService.getUserNamesByArticlesNumOver3();
    }

}
