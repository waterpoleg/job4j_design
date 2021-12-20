package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "src/main/java/ru/job4j/io/data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect"));
    }

    @Test
    public void whenEmptyLines() {
        String path = "src/main/java/ru/job4j/io/data/app_with_empties.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalConfig() {
        String path = "src/main/java/ru/job4j/io/data/app_illegal_conf.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.url"), is(nullValue()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalConfigWithLeadingSpaces() {
        String path = "src/main/java/ru/job4j/io/data/app_illegal_conf_2.properties";
        Config config = new Config(path);
        config.load();
    }
}
