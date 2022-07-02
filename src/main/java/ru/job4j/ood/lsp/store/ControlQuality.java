package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distributeFood(Food food) {
        var result = false;
        for (Store store : stores) {
            if (store.add(food)) {
                result = true;
            }
        }
        if (!result) {
            System.out.println("There is no store for such kind of food: " + food);
        }
    }

    public void resort() {
        List<Food> tempFoods = new ArrayList<>();
        for (Store store : stores) {
            tempFoods.addAll(store.getAll());
            store.clearStorage();
        }
        tempFoods.forEach(this::distributeFood);
    }
}
