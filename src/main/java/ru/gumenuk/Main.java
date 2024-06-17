package ru.gumenuk;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.file.Files;
class Main {
    public static void main(String[] args) {
        final String fileName = "C:/Users/Семён/Work Egor/src/In.txt";
        final String outputFilename = "C:/Users/Семён/Work Egor/src/Out.txt";

        if (!Files.exists(Paths.get(fileName))) {
            throw new UncheckedIOException(new IOException("Файл '" + fileName + "' не найден"));
        }

        List<String> list = readList(fileName);
        for (String s : list) {
            System.out.println(s);
        }

        Collections.reverse(list);

        writeList(outputFilename, list);
    }

    private static List<String> readList(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bf.readLine())!= null) {
                result.add(line);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return result;
    }

    private static void writeList(String filename, List<String> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}






