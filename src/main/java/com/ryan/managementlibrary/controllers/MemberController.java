package com.ryan.managementlibrary.controllers;

import com.ryan.managementlibrary.models.Member;
import com.ryan.managementlibrary.services.MemberService;
import com.ryan.managementlibrary.utils.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberController {
    private MemberService memberService;

    @Autowired
    private ScannerUtil scannerUtil;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public void userMenu() {
        while (true) {
            System.out.println("\n=======================================");
            System.out.println("               MEMBER MENU               ");
            System.out.println("=======================================\n");
            System.out.println("1. View All Member");
            System.out.println("2. Create or Add Member");
            System.out.println("3. View Member By Id");
            System.out.println("4. Update Member");
            System.out.println("5. Delete Member");
            System.out.println("6. Exit");
            System.out.println("=======================================\n");
            String menu = scannerUtil.readString("Enter your choice: ");

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
        System.out.println("===== VIEW ALL MEMBER =====\n");
        List<Member> members = memberService.getAll();
        members.stream().forEach(user -> System.out.println(user.toString()));
    }

    public void addUser() {
        System.out.println("===== CREATE OR ADD MEMBER =====\n");
        String name = scannerUtil.readStringValidate("Input name: ");
        String phoneNumber = scannerUtil.validatePhoneNumber("Input Phone Number: ");
        String address = scannerUtil.readStringValidate("Input Address: ");
        Member member = new Member(name, phoneNumber, address);
        memberService.create(member);
    }

    public void viewById() {
        System.out.println("===== VIEW MEMBER BY ID =====\n");
        int id = scannerUtil.readInt("Input Member id: ");
        Member member = memberService.findById(id);
        System.out.println(member);
    }

    public void updateUser() {
        System.out.println("===== UPDATE MEMBER=====\n");
        int id = scannerUtil.readInt("Input Member Id: ");
        Member member = memberService.findById(id);
        if (member != null) {
            String name = scannerUtil.readStringValidate("Input name: ");
            String phoneNumber = scannerUtil.validatePhoneNumber("Input Phone Number: ");
            String address = scannerUtil.readStringValidate("Input Address: ");
            member.setName(name);
            member.setPhoneNumber(phoneNumber);
            member.setAddress(address);
            memberService.update(member, id);
            System.out.println("Update successfully");
        }
    }

    public void deleteUser() {
        System.out.println("===== DELETE MEMBER =====\n");
        int id = scannerUtil.readInt("Input Id Member: ");
        memberService.delete(id);
    }
}
