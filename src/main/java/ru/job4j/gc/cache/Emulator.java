package ru.job4j.gc.cache;

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
        Emulator emulator = new Emulator("src/main/java/ru/job4j/gc/cache");
        emulator.load("Names.txt");
        String data = emulator.getCacheData("Names.txt");
        System.out.println(data);
    }
}
