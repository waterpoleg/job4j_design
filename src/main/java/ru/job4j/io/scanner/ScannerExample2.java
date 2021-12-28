package ru.job4j.io.scanner;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/*
 * Пусть надо из потока данных вычленить адреса почты, которые разделены между собой “, ”
 * */

public class ScannerExample2 {
    public static void main(String[] args) {
        var data = "empl1@mail.ru, empl2@mail.ru, empl3@mail.ru";
        var scanner = new Scanner(new ByteArrayInputStream(data.getBytes()))
                .useDelimiter(", ");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
