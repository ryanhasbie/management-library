package com.ryan.managementlibrary.models.dto;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.Member;

import java.util.Date;

public class BorrowBookDto {
    private Integer borrowBookId;
    private Date date;
    private Member member;
    private Book book;
    private String statusBorrow;

    public Integer getBorrowBookId() {
        return borrowBookId;
    }

    public void setBorrowBookId(Integer borrowBookId) {
        this.borrowBookId = borrowBookId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Member getUser() {
        return member;
    }

    public void setUser(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getStatusBorrow() {
        return statusBorrow;
    }

    public void setStatusBorrow(String statusBorrow) {
        this.statusBorrow = statusBorrow;
    }

    @Override
    public String toString() {
        return "BorrowBookDto{" +
                "borrowBookId=" + borrowBookId +
                ", date=" + date +
                ", member=" + member +
                ", book=" + book +
                ", statusBorrow='" + statusBorrow + '\'' +
                '}';
    }
}
