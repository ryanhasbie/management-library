package com.ryan.managementlibrary.controllers;

import com.ryan.managementlibrary.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class MainController {
    @Autowired
    private ScannerUtil scannerUtil;
    private final BookController bookController;
    private final UserController userController;
    private final BorrowBookController borrowBookController;

    public MainController(BookController bookController, UserController userController, BorrowBookController borrowBookController) {
        this.bookController = bookController;
        this.userController = userController;
        this.borrowBookController = borrowBookController;
    }

    public void run() {
        System.out.println("=====APPLICATION MANAGEMENT LIBRARY=====");
        System.out.println("1. Manage Book");
        System.out.println("2. Manage User");
        System.out.println("3. Manage Borrow Book ");
        System.out.println("4. Exit");
        String menu = scannerUtil.readString("Choose menu: ");
        switch (menu) {
            case "1" :
                bookController.bookMenu();
                break;
            case "2" :
                userController.userMenu();
                break;
            case "3" :
                borrowBookController.menuBorrowBook();
                break;
            case "4" :
                System.exit(0);
                break;
            default:
                System.out.println("Menu not found, please try again");
        }
    }
}
