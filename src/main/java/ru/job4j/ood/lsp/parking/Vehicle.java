package ru.job4j.ood.lsp.parking;

public class Vehicle implements Car {

    private final int size;

    public Vehicle(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
