package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        int matrixSize = 10;
        String rsl;
        try (FileOutputStream out = new FileOutputStream("src/main/java/ru/job4j/io/result.txt")) {
            for (int i = 1; i <= matrixSize; i++) {
                for (int j = 1; j <= matrixSize; j++) {
                    rsl = i * j + "\t";
                    out.write(rsl.getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
