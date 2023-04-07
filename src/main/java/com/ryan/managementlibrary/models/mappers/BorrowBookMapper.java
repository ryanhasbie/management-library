package com.ryan.managementlibrary.models.mappers;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.BorrowBook;
import com.ryan.managementlibrary.models.User;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;
import com.ryan.managementlibrary.services.BookService;
import com.ryan.managementlibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class BorrowBookMapper implements RowMapper<BorrowBookDto> {

    @Override
    public BorrowBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setAddress(rs.getString("address"));
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setStatus(rs.getString("status"));
        book.setPublisher(rs.getString("publisher"));
        BorrowBookDto borrowBookDto = new BorrowBookDto();
        borrowBookDto.setBorrowBookId(rs.getInt("borrowbook_id"));
        borrowBookDto.setDate(rs.getDate("date"));
        borrowBookDto.setUser(user);
        borrowBookDto.setBook(book);
        borrowBookDto.setStatusBorrow(rs.getString("status_borrow"));
        return borrowBookDto;
    }
}
