package ru.gumenuk.task5;

public class LoginValidator {
    public static boolean validate(String login) throws WrongLoginException {
        if (!isValid(login)) {
            throw new WrongLoginException("1a");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("1b");
        }
        return true;
    }

    public static boolean isValid(String login) {
        String regex = "^[A-Za-z0-9_]*$";
        return login.matches(regex);
    }
}

