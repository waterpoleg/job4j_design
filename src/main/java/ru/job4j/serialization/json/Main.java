package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Account account = new Account(
                13,
                "test",
                new User("Martin", 50),
                new String[]{"rus", "eng"},
                true
        );

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(account));

        final String accountJson = "{"
                + "\"id\":3,"
                + "\"description\":\"test2\","
                + "\"user\":"
                + "{"
                + "\"name\":\"John\","
                + "\"age\":35},"
                + "\"options\":"
                + "[\"rus\",\"eng\"],"
                + "\"isActive\":false"
                + "}";

        final Account accountMod = gson.fromJson(accountJson, Account.class);
        System.out.println(accountMod);
    }
}
