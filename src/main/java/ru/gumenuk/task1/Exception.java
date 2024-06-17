package ru.gumenuk.task1;
import java.io.IOException;
public class Exception {
    static class UncheckedIOException extends RuntimeException {
        UncheckedIOException(IOException cause) {
            super(cause);
        }
    }
}
