package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.User;
import com.ryan.managementlibrary.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        try {
            List<User> users = userRepository.getAll();
            if (users.isEmpty()) {
                throw new Exception("User not found!");
            }
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User create(User user) {
        try {
            return userRepository.create(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User findById(Integer id) {
        try {
            Optional<User> result = userRepository.findById(id);
            if (result.isEmpty()) {
                throw new Exception("User not found...");
            }
            return result.get();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(User user, Integer id) {
        try {
            userRepository.update(user, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            userRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
