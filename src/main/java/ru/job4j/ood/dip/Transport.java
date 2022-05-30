package ru.job4j.ood.dip;

/*
* наруешние DIP - интерфейс зависит от реализации
* */
public interface Transport {
    void drive(Bus bus);
}

class Bus {
}

class Car {
}
