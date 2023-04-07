package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User create(User user);
    User findById(Integer id);
    void update(User user, Integer id);
    void delete(Integer id);
}
