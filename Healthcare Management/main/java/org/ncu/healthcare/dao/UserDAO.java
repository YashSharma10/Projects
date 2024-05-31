package org.ncu.healthcare.dao;

import java.util.List;

import org.ncu.healthcare.entity.User;

public interface UserDAO{
    User findById(int userId);
    User findByUsername(String username);
    void save(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
}

