package ru.gumenuk.task1;

public class MultiplicationTable {
    private final Printer printer;

    public MultiplicationTable(Printer printer) {
        this.printer = printer;
    }

    public void showTable(int rows, int cols) throws IllegalTableSizeException {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalTableSizeException("Неверный размер таблицы. Попробуйте снова.");
        }

        int firstCol = String.valueOf(rows).length();
        int otherCol = String.valueOf(rows * cols).length();
        String firstColFormat = "%" + firstCol + "d";
        String otherColFormat = "|%" + otherCol + "d";
        String line = makeLine(firstCol, otherCol, cols);

        printer.print(" ".repeat(firstCol));
        for (int i = 1; i <= cols; i++) {
            printer.print(String.format(otherColFormat, i));
        }
        printer.print("\n" + line + "\n");

        for (int i = 1; i <= rows; i++) {
            printer.print(String.format(firstColFormat, i));
            for (int j = 1; j <= cols; j++) {
                printer.print(String.format(otherColFormat, i * j));
            }
            printer.print("\n" + line + "\n");
        }
    }

    private String makeLine(int firstColLen, int otherColLen, int cols) {
        StringBuilder builder = new StringBuilder();

        builder.append("-".repeat(Math.max(0, firstColLen)));
        for (int i = 0; i < cols; i++) {
            builder.append("+");
            builder.append("-".repeat(Math.max(0, otherColLen)));
        }

        return builder.toString();
    }
}
