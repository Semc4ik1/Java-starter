package ru.gumenuk.task1;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void error(String message) {
        System.err.println(message);
    }
}
