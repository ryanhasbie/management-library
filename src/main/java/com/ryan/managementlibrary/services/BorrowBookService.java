package com.ryan.managementlibrary.services;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.BorrowBook;
import com.ryan.managementlibrary.models.User;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;

import java.util.List;

public interface BorrowBookService {
    List<BorrowBookDto> getAll();
    BorrowBook create(BorrowBook borrowBook);
    BorrowBookDto findById(Integer id);
    BorrowBook get(Integer id);
    void update(BorrowBook borrowBook, Integer id);
    void delete(Integer id);
}
