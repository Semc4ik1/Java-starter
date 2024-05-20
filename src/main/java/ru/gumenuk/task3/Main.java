package ru.gumenuk.task3;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //исправил константу
    private static final Pattern PATTERN = Pattern.compile("^\\+?7 \\d{3} \\d{3} \\d{2} \\d{2}$");
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();


        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите одну из выбранных команд: 1: ADD - Добавить пару, " +
                        "2: LIST - показать все пары, " +
                        "3: Quit ");
                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("ADD")) {
                    System.out.println("Введите имя: ");
                    String name = scanner.nextLine();

                    // Проверяем, существует ли уже имя
                    if (phoneBook.containsKey(name)) {
                        System.out.println("Контакт с таким именем уже существует. Номер контакта: " + phoneBook.get(name));
                        return; // Прекращаем выполнение метода, если имя уже существует
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
                        } catch (IllegalAccessError error) {
                            System.out.println("Ошибка ввода. Неправильно набран номер.");
                            scanner.nextLine();
                        }
                    }

                    // Если имя не было найдено, добавляем новую пару
                    phoneBook.put(name, number);
                    System.out.println("Пара добавлена!!!");


                } else if (command.equalsIgnoreCase("LIST")) {
                    System.out.println("Вот все пары: ");
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        System.out.println("Имя: " + entry.getKey() + ", Ключ: " + entry.getValue());
                    }
                } else if (command.equalsIgnoreCase("QUIT")) {
                    System.out.println("Выход из программы: ");
                    break;
                } else {
                    System.out.println("Неизвестная команда. Попробуйте снова.");
                }
            }
        }
    }
}