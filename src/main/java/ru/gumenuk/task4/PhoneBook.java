package ru.gumenuk.task4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+7 \\d{3} \\d{3} \\d{2} \\d{2}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-z]+$");
    private final Map<String, String> phoneBook = new HashMap<>();
    private final Scanner scanner;
    private final Printer printer;

    public PhoneBook(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void printAllContacts() {
        phoneBook.forEach(this::printInfo);
    }

    public void printContact(String contact) {
        if (isPhone(contact)) {
            printByPhone(contact);
        } else if (isName(contact)) {
            printByName(contact);
        } else {
            throw new IllegalArgumentException("Incorrect input!");
        }
    }

    private void printByPhone(String phone) {
        if (!phoneBook.containsKey(phone)) {
            printer.println("Book does not contains specified phone, enter name:");
            String name = scanner.nextLine();
            while (!isName(name)) {
                printer.error("Not name!");
                name = scanner.nextLine();
            }
            phoneBook.put(phone, name);
        }
        printInfo(phone, phoneBook.get(phone));
    }

    private void printByName(String name) {
        if (!phoneBook.containsValue(name)) {
            printer.println("Book does not contains phone for your name, enter phone:");
            String phone = scanner.nextLine();
            while (!isPhone(phone)) {
                printer.error("Not phone!");
                phone = scanner.nextLine();
            }
            if (phoneBook.containsKey(phone)) {
                throw new IllegalArgumentException("Specified phone already exists");
            }
            phoneBook.put(phone, name);
        }
        phoneBook.keySet().stream()
                .filter((phone) -> phoneBook.get(phone).equals(name))
                .forEach((phone) -> printInfo(phone, phoneBook.get(phone)));

    }

    private boolean isPhone(String text) {
        Matcher matcher = PHONE_PATTERN.matcher(text);
        return matcher.matches();
    }

    private boolean isName(String text) {
        Matcher matcher = NAME_PATTERN.matcher(text);
        return matcher.matches();
    }

    private void printInfo(String phone, String name) {
        printer.println(phone + ": " + name);
    }
}
