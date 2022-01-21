package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pojo {
    public static void main(String[] args) {
        JSONObject jsonUser = new JSONObject("{\"name\":\"Martin\",\"age\":50}");
        List<String> list = new ArrayList<>();
        list.add("rus");
        list.add("eng");
        JSONArray jsonOptions = new JSONArray(list);

        final Account account = new Account(
                13,
                "test",
                new User("Martin", 50),
                new String[]{"rus", "eng"},
                true
        );
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", account.getId());
        jsonObject.put("description", account.getDescription());
        jsonObject.put("user", jsonUser);
        jsonObject.put("options", jsonOptions);
        jsonObject.put("isActive", account.isActive());

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(account).toString());
    }
}
