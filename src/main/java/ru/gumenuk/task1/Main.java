package ru.gumenuk.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        MultiplicationTable multiplicationTable = new MultiplicationTable(printer);

        try (Scanner scanner = new Scanner(System.in)) {
            printer.print("Введите количество строк для таблицы умножения: ");
            int rows = scanner.nextInt();
            printer.print("Введите количество столбцов для таблицы умножения: ");
            int cols = scanner.nextInt();
            multiplicationTable.showTable(rows, cols);
        } catch (IllegalTableSizeException e) {
            printer.error(e.getMessage());
        }
    }
}