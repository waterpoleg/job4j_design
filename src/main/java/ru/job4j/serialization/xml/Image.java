package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "image")
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {
    private String link;

    public Image() {
    }

    public Image(String link) {
        this.link = link;
    }
}
