package com.ryan.managementlibrary.controllers;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.models.BorrowBook;
import com.ryan.managementlibrary.models.Member;
import com.ryan.managementlibrary.models.dto.BorrowBookDto;
import com.ryan.managementlibrary.services.BookService;
import com.ryan.managementlibrary.services.BorrowBookService;
import com.ryan.managementlibrary.services.MemberService;
import com.ryan.managementlibrary.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BorrowBookController {
    private final BorrowBookService borrowBookService;
    private final MemberService memberService;
    private final BookService bookService;

    @Autowired
    private ScannerUtil scannerUtil;

    public BorrowBookController(BorrowBookService borrowBookService, MemberService memberService, BookService bookService) {
        this.borrowBookService = borrowBookService;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    public void menuBorrowBook() {
        while (true) {
            System.out.println("\n=======================================");
            System.out.println("            BORROW A BOOK MENU           ");
            System.out.println("=======================================\n");
            System.out.println("1. View All Borrow a Book");
            System.out.println("2. Create or Add Borrow a Book");
            System.out.println("3. View Borrow a Book By Id");
            System.out.println("4. Update Borrow a Book");
            System.out.println("5. Delete Borrow a Book");
            System.out.println("6. Exit");
            System.out.println("=======================================\n");
            String menu = scannerUtil.readString("Choose menu: ");

            switch (menu) {
                case "1":
                    viewAllBorrowBook();
                    break;
                case "2":
                    addBorrowBook();
                    break;
                case "3":
                    viewBorrowBookById();
                    break;
                case "4" :
                    updateBorrowBook();
                    break;
                case "5" :
                    deleteBorrowBook();
                    break;
                case "6" :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu not found, please try again");
            }
        }
    }

    public void viewAllBorrowBook() {
        System.out.println("===== VIEW ALL BORROW a BOOK =====\n");
        List<BorrowBookDto> borrowBookDtos = borrowBookService.getAll();
        borrowBookDtos.stream().forEach(borrowBook -> System.out.println(borrowBook.toString()));
    }

    public void addBorrowBook() {
        System.out.println("===== CREATE OR ADD BORROW a BOOK =====\n");
        System.out.println("Choose Member: ");
        List<Member> members = memberService.getAll();
        members.stream().forEach(user -> System.out.println(user.toString()));
        System.out.println("------------------------------");
        System.out.println("Choose Book: ");
        List<Book> books = bookService.getAll();
        books.stream().forEach(book -> System.out.println(book.toString()));
        System.out.println("------------------------------");
        Date date = scannerUtil.validateDate("Input Date: ");
        int userId = scannerUtil.readInt("Input Id Member: ");
        int bookId = scannerUtil.readInt("Input Book Id: ");
        String statusBorrow = scannerUtil.readStringValidate("Input Status Borrow: ");
        String statusBook = scannerUtil.readStringValidate("Input Status Book: ");
        BorrowBook borrowBook = new BorrowBook(date, userId, bookId, statusBorrow);
        Book book = bookService.findById(bookId);
        book.setStatus(statusBook);
        bookService.updateStatusOnly(book, bookId);
        borrowBookService.create(borrowBook);
    }

    public void viewBorrowBookById() {
        System.out.println("===== VIEW BORROW a BOOK BY ID =====\n");
        int id = scannerUtil.readInt("Input Borrow a Book Id: ");
        BorrowBookDto borrowBookDto = borrowBookService.findById(id);
        System.out.println(borrowBookDto);
    }

    public void updateBorrowBook() {
        System.out.println("===== UPDATE BORROW a BOOK =====\n");

        System.out.println("Choose Member: ");
        List<Member> members = memberService.getAll();
        members.stream().forEach(user -> System.out.println(user.toString()));
        System.out.println("------------------------------");
        System.out.println("Choose Book: ");
        List<Book> books = bookService.getAll();
        books.stream().forEach(book -> System.out.println(book.toString()));
        System.out.println("------------------------------");

        int id = scannerUtil.readInt("Input Borrow book id: ");
        BorrowBook borrowBook =  borrowBookService.get(id);

        if (borrowBook != null) {
            Date date = scannerUtil.validateDate("Input Date: ");
            int userId = scannerUtil.readInt("Input Id Member: ");
            int bookId = scannerUtil.readInt("Input Book Id: ");
            String statusBorrow = scannerUtil.readStringValidate("Input Status Borrow: ");
            borrowBook.setDate(date);
            borrowBook.setUserId(userId);
            borrowBook.setBookId(bookId);
            borrowBook.setStatus(statusBorrow);

            String statusBook = scannerUtil.readStringValidate("Input Status Book: ");
            Book book = bookService.findById(bookId);
            book.setStatus(statusBook);
            bookService.updateStatusOnly(book, bookId);

            borrowBookService.update(borrowBook, id);
        }
    }

    public void deleteBorrowBook() {
        System.out.println("===== DELETE BORROW a BOOK =====\n");
        int id = scannerUtil.readInt("Input Borrow book id: ");
        borrowBookService.delete(id);
    }

}
