package ru.job4j.ood.dip;

import java.util.HashMap;

/*
* нарушение DIP - класс звависит отрелаизации хранилища диалога
* */
public class Chat {
    private HashMap<String, String> dialog = new HashMap<>();

    public Chat(HashMap<String, String> dialog) {
        this.dialog = dialog;
    }
}
