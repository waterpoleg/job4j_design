package ru.job4j.gc.cache;

import java.util.Scanner;

public class Emulator {
    private final DirFileCache dirFileCache;

    public Emulator(String dirFileCache) {
        this.dirFileCache = new DirFileCache(dirFileCache);
    }

    public void load(String key) {
        dirFileCache.load(key);
    }

    public String getCacheData(String key) {
        return dirFileCache.get(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите кэшируемую директорию:");
        String dirFileCache = scanner.nextLine();
        Emulator emulator = new Emulator(dirFileCache);
        String fileName;
        var isRun = true;
        while (isRun) {
            System.out.println("Выберите действие");
            System.out.println("1 - Кешировать файл");
            System.out.println("2 - Получить содержимое файла из кэша");
            int userAction = Integer.parseInt(scanner.nextLine());
            if (userAction == 1 || userAction == 2) {
                System.out.println("Введите имя файла:");
                fileName = scanner.nextLine();
                switch (userAction) {
                    case 1:
                        emulator.load(fileName);
                        break;
                    case 2:
                        System.out.println(emulator.getCacheData(fileName));
                        break;
                    default:
                        isRun = false;
                        break;
                }
            } else {
                break;
            }
        }
    }
}
