package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.BorrowBook;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;
import com.ryan.managementlibrary.repositories.BookRepository;
import com.ryan.managementlibrary.repositories.BorrowBookRepository;

import java.util.List;
import java.util.Optional;

public class BorrowBookServiceImpl implements BorrowBookService{

    private final BorrowBookRepository borrowBookRepository;


    public BorrowBookServiceImpl(BorrowBookRepository borrowBookRepository) {
        this.borrowBookRepository = borrowBookRepository;
    }

    @Override
    public List<BorrowBookDto> getAll() {
        try {
            List<BorrowBookDto> borrowBookDtos = borrowBookRepository.getAll();
            if (borrowBookDtos.isEmpty()) {
                throw new Exception("Data not found...");
            }
            return borrowBookDtos;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BorrowBook create(BorrowBook borrowBook) {
        try {
            return borrowBookRepository.create(borrowBook);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BorrowBookDto findById(Integer id) {
        try {
            Optional<BorrowBookDto> borrowBookDto = borrowBookRepository.findById(id);
            if (borrowBookDto.isEmpty()) {
                throw new Exception("Data not found...");
            }
            return borrowBookDto.get();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BorrowBook get(Integer id) {
        try {
            Optional<BorrowBook> borrowBook = borrowBookRepository.get(id);
            if (borrowBook.isEmpty()) {
                throw new Exception ("Data borrow a book with id " + id + " not found!");
            }
            return borrowBook.get();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(BorrowBook borrowBook, Integer id) {
        try {
            borrowBookRepository.update(borrowBook, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            borrowBookRepository.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
