package com.example.library.service.impl;

import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        user.setId(users.size() + 1L);
        users.add(user);

        return user;
    }

    @Override
    public User update(Long userId, User user) {
        if (userId != null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(userId)) {
                    users.set(i, user);
                    return users.get(i);
                }
            }

        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        return users
                .stream()
                .filter(u -> u
                        .getUsername()
                        .equals(username))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteUser(Long userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                users.remove(i);
                return;
            }
        }
    }
}
