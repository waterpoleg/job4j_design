package ru.job4j.ood.lsp.store;

import java.time.LocalDate;

public class Food {

    private final String name;
    private final LocalDate createDate;
    private final LocalDate expireDate;
    private double price;
    private double discount;

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
