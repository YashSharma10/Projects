package org.ncu.healthcare.service;

import org.ncu.healthcare.entity.User;

import java.util.List;

public interface UserService {
    User findById(int userId);
    User findByUsername(String username);
    void save(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
}
