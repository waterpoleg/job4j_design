package ru.job4j.ood.lsp.store;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ControlQualityTest {

    private List<AbstractStore> stores;
    private Trash trashStore;
    private Shop shopStore;
    private Warehouse warehouseStore;

    @Before
    public void initData() {
        shopStore = new Shop();
        warehouseStore = new Warehouse();
        trashStore = new Trash();
        stores = List.of(shopStore, warehouseStore, trashStore);
    }

    @Test
    public void whenDistributeToTrashThenTrue() {
        LocalDate createDate = LocalDate.of(2022, 6, 1);
        LocalDate expiryDate = LocalDate.of(2022, 6, 20);
        ControlQuality controlQuality = new ControlQuality(stores);
        Food food = new Food("milk", createDate, expiryDate, 100.0, 0);
        controlQuality.distributeFood(food);
        assertThat(trashStore.getAllFood(), is(List.of(food)));
    }

    @Test
    public void whenDistributeToShopThenTrue() {
        LocalDate createDate = LocalDate.of(2022, 6, 1);
        LocalDate expiryDate = LocalDate.of(2022, 8, 2);
        ControlQuality controlQuality = new ControlQuality(stores);
        Food food = new Food("milk", createDate, expiryDate, 100.0, 0);
        controlQuality.distributeFood(food);
        assertThat(shopStore.getAllFood(), is(List.of(food)));
    }

    @Test
    public void whenDistributeToWarehouseThenTrue() {
        LocalDate createDate = LocalDate.of(2022, 6, 1);
        LocalDate expiryDate = LocalDate.of(2022, 10, 30);
        ControlQuality controlQuality = new ControlQuality(stores);
        Food food = new Food("milk", createDate, expiryDate, 100.0, 0);
        controlQuality.distributeFood(food);
        assertThat(warehouseStore.getAllFood(), is(List.of(food)));
    }
}
