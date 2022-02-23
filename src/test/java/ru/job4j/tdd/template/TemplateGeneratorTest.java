package ru.job4j.tdd.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TemplateGeneratorTest {

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenManyKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Martin", "subject", "you", "age", "50");
        TemplateGenerator generator = new TemplateGenerator();
        generator.produce(template, map);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughKeys() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Martin");
        TemplateGenerator generator = new TemplateGenerator();
        generator.produce(template, map);
    }

    @Ignore
    @Test
    public void whenDataIsValid() {
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = Map.of("name", "Fowler", "subject", "you");
        TemplateGenerator generator = new TemplateGenerator();
        assertThat(generator.produce(template, map), is("I am a Fowler, Who are you?"));
    }
}
