package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, List<Path>> doubles = new HashMap<>();

    public List<Path> getDoubles() {
        List<Path> duplicatesList = new ArrayList<>();
        doubles.values()
                .stream()
                .filter(paths -> paths.size() > 1)
                .forEach(duplicatesList::addAll);
        return duplicatesList;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        List<Path> entry = doubles.containsKey(fileProperty)
                ? new ArrayList<>(doubles.get(fileProperty))
                : new ArrayList<>();
        entry.add(file);
        doubles.put(fileProperty, entry);
        return super.visitFile(file, attrs);
    }
}
