package ru.gumenuk.task4;

public class ConsolePrinter implements Printer {
    @Override
    public void println(String content) {
        System.out.println(content);
    }

    @Override
    public void error(String error) {
        System.err.println(error);
    }
}
