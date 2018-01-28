package com.example.library.controller;

import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public List<User> getAllUsers(
            @RequestParam(value = "username", required = false)
                    String username) {
        if (username != null) {
            return userService.getUsersByUsername(username);
        } else {
            return userService.getAllUsers();
        }

    }

    /**
     * Request body example
     * {"username":"user", "firstName": "Moshe", "lastName":"Petrov", "age": 35, "hasLicence": false}
     * @param user
     * @return
     */

    @PostMapping(value = "/")
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable("id") Long userId,
            @RequestBody User user){
        return userService.update(userId, user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
    }
}
