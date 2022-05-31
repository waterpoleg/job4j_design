package ru.job4j.ood.lsp;

/*
* Нарушение LSP: в наследнике ослабляется постусловие, нет расчета скидки
* */

public class OldShop {

    private int sum;

    public OldShop(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public int applyDiscount() {
        if (sum >= 100) {
            sum -= 5;
        }
        return sum;
    }
}

class Boutique extends OldShop {

    public Boutique(int sum) {
        super(sum);
    }

    @Override
    public int applyDiscount() {
        return getSum();
    }
}
