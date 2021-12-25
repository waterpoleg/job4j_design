package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static ArgsName validate(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }
        ArgsName params = ArgsName.of(args);
        if (params.get("d") == null || params.get("e") == null || params.get("o") == null) {
            throw new IllegalArgumentException("Wrong arguments.");
        }
        if (!new File(params.get("d")).isDirectory()) {
            throw new IllegalArgumentException("No such folder: " + params.get("d"));
        }
        return params;
    }

    public static void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip =
                     new ZipOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(target.toFile())))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName params = validate(args);
        try {
            List<Path> files = Search.search(Paths.get(params.get("d")),
                    f -> !f.toFile().getName().endsWith(params.get("e")));
            packFiles(files, Paths.get(params.get("o")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
