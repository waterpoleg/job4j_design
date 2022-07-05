package ru.job4j.ood.lsp.store;

import java.util.List;

public class ControlQuality {

    private final List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> stores) {
        this.stores = stores;
    }

    public void distributeFood(Food food) {
        var result = false;
        for (AbstractStore store : stores) {
            if (store.addFood(food)) {
                result = true;
            }
        }
        if (!result) {
            System.out.println("There is no store for such kind of food: " + food);
        }
    }
}
