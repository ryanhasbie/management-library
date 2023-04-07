package com.ryan.managementlibrary.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowBook {
    private Integer borrowBookid;
    private Date date;
    private int userId;
    private int bookId;
    private String statusBorrow;

    public BorrowBook() {
    }

    public BorrowBook(Date date, int userId, int bookId, String statusBorrow) {
        this.date = date;
        this.userId = userId;
        this.bookId = bookId;
        this.statusBorrow = statusBorrow;
    }

    public Integer getBorrowBookid() {
        return borrowBookid;
    }

    public void setBorrowBookid(Integer borrowBookid) {
        this.bookId = borrowBookid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return statusBorrow;
    }

    public void setStatus(String statusBorrow) {
        this.statusBorrow = statusBorrow;
    }
}
