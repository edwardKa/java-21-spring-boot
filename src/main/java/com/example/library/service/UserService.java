package com.example.library.service;

import com.example.library.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    User update(Long userId, User user);
    List<User> getAllUsers();
    List<User> getUsersByUsername(String username);
    void deleteUser(Long userId);

}
