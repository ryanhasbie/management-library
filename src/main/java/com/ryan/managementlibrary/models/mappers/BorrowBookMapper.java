package com.ryan.managementlibrary.models.mappers;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.Member;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BorrowBookMapper implements RowMapper<BorrowBookDto> {

    @Override
    public BorrowBookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Member member = new Member();
        member.setMemberId(rs.getInt("member_id"));
        member.setName(rs.getString("name"));
        member.setPhoneNumber(rs.getString("phone_number"));
        member.setAddress(rs.getString("address"));
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setStatus(rs.getString("status"));
        book.setPublisher(rs.getString("publisher"));
        BorrowBookDto borrowBookDto = new BorrowBookDto();
        borrowBookDto.setBorrowBookId(rs.getInt("borrowbook_id"));
        borrowBookDto.setDate(rs.getDate("date"));
        borrowBookDto.setUser(member);
        borrowBookDto.setBook(book);
        borrowBookDto.setStatusBorrow(rs.getString("status_borrow"));
        return borrowBookDto;
    }
}
