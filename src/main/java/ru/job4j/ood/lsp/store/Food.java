package ru.job4j.ood.lsp.store;

import java.time.LocalDate;

public class Food {

    private final String name;
    private final LocalDate createDate;
    private final LocalDate expireDate;
    private double price;
    private int discount;

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price, int discount) {
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Food{"
                + "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + ", price=" + price
                + ", discount=" + discount
                + '}';
    }
}
