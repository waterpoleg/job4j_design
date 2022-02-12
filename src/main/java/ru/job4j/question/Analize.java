package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int addCount = 0;
        int modCount = 0;
        int delCount = 0;
        Map<Integer, User> prevMap = new HashMap<>();
        for (User user : previous) {
            prevMap.put(user.getId(), user);
        }
        for (User currUser : current) {
            if (prevMap.containsKey(currUser.getId())) {
                if (!Objects.equals(currUser.getName(), prevMap.get(currUser.getId()).getName())) {
                    modCount++;
                }
            } else {
                addCount++;
            }
        }
        delCount = previous.size() + addCount - current.size();
        return new Info(addCount, modCount, delCount);
    }
}
