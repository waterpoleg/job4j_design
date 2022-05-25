package ru.job4j.ood.srp;

public class Single {
    private static Single instance;

    public static Single getInstance() {
        if (instance == null) {
            instance = new Single();
        }
        return instance;
    }
}
