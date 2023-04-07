package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.User;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getAll() throws Exception;
    Book create (Book book) throws Exception;
    Optional<Book> findById (Integer id) throws Exception;
    void update(Book book, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
    void updateStatusOnly(Book book, Integer id) throws Exception;
}
