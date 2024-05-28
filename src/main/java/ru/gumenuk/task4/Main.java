package ru.gumenuk.task4;

import java.util.Scanner;

public class Main {
    private static final Printer CONSOLE = new ConsolePrinter();
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PhoneBook book = new PhoneBook(CONSOLE, scanner);

            while (!Thread.currentThread().isInterrupted()) {
                String input;
                try {
                    CONSOLE.println("Enter name or phone (LIST for all phones, QUIT to exit):");
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("QUIT")) {
                        break;
                    }
                    if (input.equalsIgnoreCase("LIST")) {
                        book.printAllContacts();
                        continue;
                    }
                    book.printContact(input);
                } catch (IllegalArgumentException e) {
                    CONSOLE.error(e.getMessage());
                }
            }
        }
        CONSOLE.error("Finished");
    }
}
