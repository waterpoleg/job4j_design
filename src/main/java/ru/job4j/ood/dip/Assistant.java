package ru.job4j.ood.dip;

/*
* наруешние DIP - класс Assistant звависит от класса Alisa, чтобы подключить Siri нужно именить сам класс
* */
public class Assistant {
    private Alisa alisa;

    public void answer() {
        this.alisa = new Alisa();
        alisa.play();
    }
}

class Alisa {
    public void play() {
        System.out.println("Привет");
    }
}

class Siri {
    public void play() {
        System.out.println("Hello");
    }
}
