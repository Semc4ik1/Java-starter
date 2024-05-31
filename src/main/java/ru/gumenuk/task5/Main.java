package ru.gumenuk.task5;


public class Main {
    public static void main(String[] args) {
        boolean isValidate = false;

        if (args.length != 1) {
            System.err.println("Invalid number of arguments. Using Java <login>");
            System.exit(1);
        }
        try {
            isValidate = LoginValidator.validate(args[0]);
        } catch (WrongLoginException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Login is correct: " + isValidate);
    }
}
