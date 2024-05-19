package ru.gumenuk.task3;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Map<String, String> userInput = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите одну из выбранных команд: 1: ADD - Добавить пару, " +
                    "2: LIST - показать все пары, " +
                    "3: Quit ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("ADD")) {
                System.out.println("Введите ключ: ");
                String key = null;
                boolean isCorrectPhoneNumber = false;

                while (!isCorrectPhoneNumber) {
                    try {
                        key = scanner.nextLine();
                        if (key.trim().isEmpty()) {
                            System.out.println("Ключ не может быть пустым. Пожалуйста, попробуйте снова.");
                            continue;
                        }

                        Pattern pattern = Pattern.compile("^\\+7 \\d{3} \\d{3} \\d{2} \\d{2}$");
                        Matcher matcher = pattern.matcher(key);

                        if (!matcher.find()) {
                            System.out.println("Некорректный номер телефона. Пожалуйста, попробуйте снова.");
                        } else {
                            System.out.println("Номер телефона добавлен.");
                            isCorrectPhoneNumber = true;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ошибка ввода. Пожалуйста, введите данные в соответствии с требованиями.");
                        scanner.nextLine(); // Сбросить буфер сканера после исключения
                    }
                }

                // Проверяем, существует ли уже такой ключ в HashMap
                if (userInput.containsKey(key)) {
                    System.out.println("Контакт с номером " + key + " уже существует. Имя контакта: " +
                            userInput.get(key));
                } else {
                    System.out.println("Введите значение: ");
                    String value = scanner.nextLine();
                    userInput.put(key, value);
                    System.out.println("Пара добавлена!!!");
                }

            } else if (command.equalsIgnoreCase("LIST")) {
                System.out.println("Вот все пары: ");
                for (Map.Entry<String, String> entry : userInput.entrySet()) {
                    System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
                }
            } else if (command.equalsIgnoreCase("QUIT")) {
                System.out.println("Выход из программы: ");
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }

        }
        scanner.close();
    }
}
