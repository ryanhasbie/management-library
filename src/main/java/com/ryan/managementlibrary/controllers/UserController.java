package com.ryan.managementlibrary.controllers;

import com.ryan.managementlibrary.models.User;
import com.ryan.managementlibrary.services.UserService;
import com.ryan.managementlibrary.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserController {
    private UserService userService;

    @Autowired
    private ScannerUtil scannerUtil;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void userMenu() {
        while (true) {
            System.out.println("=====USER MENU=====");
            System.out.println("1. View All User");
            System.out.println("2. Create or Add User");
            System.out.println("3. View User By Id");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
            String menu = scannerUtil.readString("Choose menu: ");

            switch (menu) {
                case "1" :
                    viewAllUser();
                    break;
                case "2" :
                    addUser();
                    break;
                case "3" :
                    viewById();
                    break;
                case "4" :
                    updateUser();
                    break;
                case "5" :
                    deleteUser();
                    break;
                case "6" :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Menu not found, please try again");
            }
        }
    }

    public void viewAllUser() {
        System.out.println("=====VIEW ALL USER=====");
        List<User> users = userService.getAll();
        users.stream().forEach(user -> System.out.println(user.toString()));
    }

    public void addUser() {
        System.out.println("=====CREATE OR ADD USER=====");
        String name = scannerUtil.readStringValidate("Input name: ");
        String phoneNumber = scannerUtil.validatePhoneNumber("Input Phone Number: ");
        String address = scannerUtil.readStringValidate("Input Address: ");
        User user = new User(name, phoneNumber, address);
        userService.create(user);
    }

    public void viewById() {
        System.out.println("=====VIEW USER BY ID=====");
        int id = scannerUtil.readInt("Input user id: ");
        User user = userService.findById(id);
        System.out.println(user);
    }

    public void updateUser() {
        System.out.println("=====UPDATE USER=====");
        int id = scannerUtil.readInt("Input User Id: ");
        User user = userService.findById(id);
        if (user != null) {
            String name = scannerUtil.readStringValidate("Input name: ");
            String phoneNumber = scannerUtil.validatePhoneNumber("Input Phone Number: ");
            String address = scannerUtil.readStringValidate("Input Address: ");
            user.setName(name);
            user.setPhoneNumber(phoneNumber);
            user.setAddress(address);
            userService.update(user, id);
            System.out.println("Update successfully");
        }
    }

    public void deleteUser() {
        System.out.println("=====DELETE USER=====");
        int id = scannerUtil.readInt("Input Id User: ");
        userService.delete(id);
    }
}
