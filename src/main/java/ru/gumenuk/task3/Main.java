package ru.gumenuk.task3;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    private static final Pattern PATTERN = Pattern.compile("^\\+?7 \\d{3} \\d{3} \\d{2} \\d{2}$");

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println("Введите одну из выбранных команд: 1: ADD - Добавить пару, " +
                    "2: LIST - показать все пары, " +
                    "3: Quit ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("ADD")) {
                String name = "";
                boolean uniqueName = false;

                while (!uniqueName) {
                    System.out.println("Введите имя: ");
                    name = scanner.nextLine();

                    // Проверяем, существует ли уже имя
                    if (phoneBook.containsKey(name)) {
                        System.out.println("Контакт с таким именем уже существует. Номер контакта: " + phoneBook.get(name));
                    } else {
                        uniqueName = true;
                    }
                }

                System.out.println("Введите ключ: ");
                String number = null;
                boolean isCorrectPhoneNumber = false;

                while (!isCorrectPhoneNumber) {
                    try {
                        number = scanner.nextLine();
                        if (number.trim().isEmpty()) {
                            System.out.println("Ключ не может быть пустым. Пожалуйста, попробуйте снова.");
                            continue;
                        }

                        Matcher matcher = PATTERN.matcher(number);

                        if (!matcher.find()) {
                            System.out.println("Некорректный номер телефона. Пожалуйста, попробуйте снова.");
                        } else {
                            System.out.println("Номер телефона добавлен.");
                            isCorrectPhoneNumber = true;
                        }
                    } catch (IllegalArgumentException exception) {
                        throw new IllegalArgumentException("Condition is false");

                    }
                }


                phoneBook.put(number, name);
                System.out.println("Пара добавлена!!!");
            } else if (command.equalsIgnoreCase("LIST")) {
                System.out.println("Вот все пары: ");
                phoneBook.forEach((name, phoneNumber) -> System.out.println("Имя: " + name + ", Номер: " + phoneNumber));
            } else if (command.equalsIgnoreCase("QUIT")) {
                System.out.println("Выход из программы: ");
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }
}