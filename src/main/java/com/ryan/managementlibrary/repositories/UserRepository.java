package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAll() throws Exception;
    User create (User user) throws Exception;
    Optional<User> findById (Integer id) throws Exception;
    void update(User user, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
