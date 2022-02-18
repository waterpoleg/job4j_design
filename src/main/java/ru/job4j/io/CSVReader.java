package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {

    private static String[] getValidatedArgs(ArgsName argsName) {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        if (path == null || delimiter == null || out == null || filter == null) {
            throw new IllegalArgumentException("Wrong arguments");
        }
        if (new File(path).isDirectory()) {
            throw new IllegalArgumentException("Wrong file name");
        }
        return new String[] {path, delimiter, out, filter};
    }

    private static void saveToFile(String path, String data) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(Paths.get(path).toFile()))) {
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void handle(ArgsName argsName) {
        StringBuilder rsl = new StringBuilder();
        String[] args = getValidatedArgs(argsName);
        List<Integer> indexes = new ArrayList<>();
        try (Scanner in = new Scanner(new File(args[0]))) {
            while (in.hasNext()) {
                String line = in.nextLine();
                String[] fields = line.split(args[1]);
                for (int i = 0; i < fields.length; i++) {
                    if (args[3].contains(fields[i])) {
                        indexes.add(i);
                    }
                }
                for (int i = 0; i < fields.length; i++) {
                    if (indexes.contains(i)) {
                        rsl.append(fields[i]);
                        if (indexes.indexOf(i) != indexes.size() - 1) {
                            rsl.append(args[1]);
                        }
                    }
                }
                rsl.append(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("stdout".equals(args[2])) {
            System.out.println(rsl);
        } else {
            saveToFile(args[2], rsl.toString());
        }
    }
}
