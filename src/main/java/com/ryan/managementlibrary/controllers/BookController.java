package com.ryan.managementlibrary.controllers;

import com.ryan.managementlibrary.models.Book;
import com.ryan.managementlibrary.services.BookService;
import com.ryan.managementlibrary.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookController {
    private final BookService bookService;
    @Autowired
    private ScannerUtil scannerUtil;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void bookMenu() {
        while (true) {
            System.out.println("\n=======================================");
            System.out.println("                 BOOK MENU               ");
            System.out.println("=======================================\n");
            System.out.println("1. View All Book");
            System.out.println("2. Create or Add Book");
            System.out.println("3. View Book By Id");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.println("=======================================\n");
            String menu = scannerUtil.readString("Enter your choice: ");

            switch (menu) {
                case "1" :
                    viewAllBook();
                    break;
                case "2" :
                    createBook();
                    break;
                case "3" :
                    viewBookById();
                    break;
                case "4" :
                    updateBook();
                    break;
                case "5" :
                    deleteBook();
                    break;
                case "6" :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu not found, please try again");
            }
        }
    }

    public void viewAllBook() {
        System.out.println("===== VIEW ALL BOOK =====\n");
        List<Book> books = bookService.getAll();
        books.stream().forEach(book -> System.out.println(book.toString()));
    }

    public  void createBook() {
        System.out.println("===== CREATE OR ADD BOOK =====\n");
        String title = scannerUtil.readStringValidate("Input Title: ");
        String author = scannerUtil.readStringValidate("Input Author: ");
        String publisher = scannerUtil.readStringValidate("Input Publisher: ");
        String status = scannerUtil.readStringValidate("Input Status: ");
        Book book = new Book(title, author, publisher, status);
        bookService.create(book);
    }

    public void viewBookById() {
        System.out.println("===== VIEW BOOK BY ID =====\n");
        int id = scannerUtil.readInt("Input Book Id: ");
        Book book = bookService.findById(id);
        System.out.println(book);
    }

    public void updateBook() {
        System.out.println("===== UPDATE BOOK =====\n");
        int id = scannerUtil.readInt("Input Book Id: ");
        Book book = bookService.findById(id);
        if (book != null) {
            String title = scannerUtil.readStringValidate("Input Title: ");
            String author = scannerUtil.readStringValidate("Input Author: ");
            String publisher = scannerUtil.readStringValidate("Input Publisher: ");
            String status = scannerUtil.readStringValidate("Input Status");
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setStatus(status);
            bookService.update(book, id);
            System.out.println("Update id " + id + " successfully");
        }
    }

    public void deleteBook() {
        System.out.println("===== DELETE BOOK =====\n");
        int id = scannerUtil.readInt("Input Book Id: ");
        bookService.delete(id);
    }
}
