package com.ryan.managementlibrary.utils;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtil {
    private final Scanner scanner;

    public ScannerUtil() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public String readStringValidate(String prompt) {
        Pattern stringPattern = Pattern.compile("^[a-zA-Z0-9 ]{3,}$");
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.trim().isEmpty() || !stringPattern.matcher(input).matches()) {
            System.out.println("Input must consist of at least 3 characters and only allowed to contain letters and numbers, please try again.");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        Pattern integerPattern = Pattern.compile("^\\d+$");
        while (input.trim().isEmpty() || !integerPattern.matcher(input).matches()) {
            System.out.println("Input must be an integer, please try again.");
            System.out.print(prompt);
            input = scanner.nextLine();
        }
        return Integer.parseInt(input);
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String validatePhoneNumber(String prompt) {
        String phoneNumber;
        boolean isValid = false;

        while (!isValid) {
            System.out.println(prompt);
            phoneNumber = scanner.nextLine();

            phoneNumber = phoneNumber.replaceAll("[\\s\\-+]", "");

            if (!phoneNumber.matches("[0-9]+")) {
                System.out.println("Phone number can only consist of digits!");
                continue;
            }

            if (phoneNumber.length() == 11 || phoneNumber.length() == 12) {
                return phoneNumber;
            } else {
                System.out.println("Phone number must have 11 or 12 digits!");
            }
        }
        return null;
    }

    public Date validateDate(String prompt) {
        boolean isValid = false;
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        while (!isValid) {
            System.out.print(prompt);
            String inputDate = scanner.nextLine();

            try {
                formatter.setLenient(false);
                date = formatter.parse(inputDate);
                isValid = true;
            } catch (ParseException e) {
                System.out.println("Incorrect date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        return date;
    }

}
