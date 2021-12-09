package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /*
    Если метод хэш-кода у объектов не переопределен, то он находится в базовой реализации JVM,
    которая (имеется ввиду реализация метода) специально заточена под выдачу максимально
    различных значений для различных объектов, в этой реализации могут быть использованы как
    адрес в памяти так и генератор псевдослучайных чисел. Так что если метод хэш-кода объекта
    не переопределен, то объекты даже с одинаковыми полями и одинаковыми значениями одинаковых
    полей гарантированно будут иметь различный хэш=код. Различный хэш-код - различное значение
    хэш-функции - различные бакеты. Если объекты попадают в различные бакеты - то не происходит
    факта коллизии (коллизия - это факт попадания объекта в бакет, в котором уже есть ранее
    помещенный туда объект). Нет факта коллизии  - то есть объекты находятся в разных
    бакетах - не включается механизм разрешения коллизий - то есть объекты не сравнивают
    между собой - потому что нет смысла сравнивать объекты, находящиеся в разных бакетах
     */

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        var user1 = new User("Martin", 1, calendar);
        var user2 = new User("Martin", 1, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (var key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
