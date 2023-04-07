package com.ryan.managementlibrary.repositories;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.BorrowBook;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;

import java.util.List;
import java.util.Optional;

public interface BorrowBookRepository {
    List<BorrowBookDto> getAll() throws Exception;
    BorrowBook create (BorrowBook borrowBook) throws Exception;
    Optional<BorrowBookDto> findById (Integer id) throws Exception;
    Optional<BorrowBook> get(Integer id) throws Exception;
    void update(BorrowBook borrowBook, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
