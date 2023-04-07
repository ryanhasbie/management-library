package com.ryan.managementlibrary.models.dto;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.User;

import java.util.Date;

public class BorrowBookDto {
    private Integer borrowBookId;
    private Date date;
    private User user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                ", book=" + book +
                ", statusBorrow='" + statusBorrow + '\'' +
                '}';
    }
}
