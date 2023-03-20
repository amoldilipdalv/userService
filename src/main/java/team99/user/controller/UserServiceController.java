package team99.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team99.user.dto.MultipleUserResponse;
import team99.user.dto.SingleUserResponse;
import team99.user.service.UserService;

@RestController
public class UserServiceController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public MultipleUserResponse getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public SingleUserResponse getUsersById(@PathVariable Integer id)
    {
        return userService.getUsersById(id);
    }

    @PostMapping("/users")
    public SingleUserResponse saveUsers(@RequestBody String name)
    {
        return userService.saveUser(name);
    }
}
