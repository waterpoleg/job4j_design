package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Проблема: если в Account есть геттер isActive(), то в выводе получим свойство как просто active,
 * объяснение:
 * В классе Account getter для isActive переименуйте в getIsActive(). (Is - с большой буквы).
 * Это тонкости работы библиотеки.
 * Она читает геттеры у объекта убирает префиксы get и is(оба с маленькой буквы) у названия
 * методов и называет свойство тем словом, которое получилось.
 *
 *  Интересное наблюдение: если назвать метод getisActive() , где is - c маленькой буквы.
 *  То парсер вообще пропускает такой геттер и на выходе это свойство не печатается.
 * */

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
        jsonObject.put("isActive", account.getIsActive());

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(account).toString());
    }
}
