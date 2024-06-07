package ru.gumenuk.task5;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isValidate = false;

        if (args.length != 1) {
            throw new RuntimeException("Invalid number of arguments. Using Java <login>");
        }
        try {
            isValidate = LoginValidator.validate(args[0]);
        } catch (WrongLoginException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Login is correct: " + isValidate);
    }
}

