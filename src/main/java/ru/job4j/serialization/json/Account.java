package ru.job4j.serialization.json;

import java.util.Arrays;

public class Account {
    private final int id;
    private String description;
    private User user;
    private String[] options;
    private boolean isActive;

    public Account(int id, String description, User user, String[] options, boolean isActive) {
        this.id = id;
        this.description = description;
        this.user = user;
        this.options = options;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Account{"
                + "id=" + id
                + ", description='" + description + '\''
                + ", user=" + user
                + ", options=" + Arrays.toString(options)
                + ", isActive=" + isActive
                + '}';
    }
}
