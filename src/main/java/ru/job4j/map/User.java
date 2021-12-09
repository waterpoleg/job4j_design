package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        var user1 = new User("Martin", 1, calendar);
        var user2 = new User("Martin", 1, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (var key : map.keySet()) {
            System.out.println(key + " : " + map.get(key) + " : " + key.hashCode());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
