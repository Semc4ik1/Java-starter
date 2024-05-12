import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк для таблицы умножения: ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов для таблицы умножения: ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Неверный размер таблицы. Попробуйте снова.");
            return;
        }
        int userEnter = 32;
        String str = String.valueOf(userEnter);
        int firstColMaxLength = str.length();
        int first = String.valueOf(rows).length();
        int other = String.valueOf(rows * cols).length();
        String test = String.format("%" + rows*cols + "d",rows * cols);
        //
        System.out.print(" ");
        for (int i = 1; i <= cols; i++) {
            System.out.printf("%3d", i);
            if (i < cols) {
                System.out.print("|");
            }
        }
        System.out.println();


        for (int i = 1; i <= cols; i++) {
            System.out.print("----");
        }
        System.out.println();


        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 1; j <= cols; j++) {
                System.out.printf("%3d", i  *  j);
                if (j < cols) {
                    System.out.print("|");
                } else {
                    System.out.println();
                }
            }


            for (int k = 1; k <= cols; k++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }
}