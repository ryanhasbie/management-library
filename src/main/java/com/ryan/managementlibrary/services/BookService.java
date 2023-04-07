package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();
    Book create(Book book);
    Book findById(Integer id);
    void update(Book book, Integer id);
    void delete(Integer id);
    void updateStatusOnly(Book book, Integer id);
}
