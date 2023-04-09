package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        try {
            List<Book> books = bookRepository.getAll();
            if (books.isEmpty()) {
                System.out.println("Book is not found!");
            }
            return books;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Book create(Book book) {
        try {
            return bookRepository.create(book);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Book findById(Integer id) {
        try {
            Optional<Book> result = bookRepository.findById(id);
            if (result.isEmpty()) {
                System.out.println("Book not found!");
            }
            return result.get();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Book book, Integer id) {
        try {
            bookRepository.update(book, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            bookRepository.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStatusOnly(Book book, Integer id) {
        try {
            bookRepository.updateStatusOnly(book, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
