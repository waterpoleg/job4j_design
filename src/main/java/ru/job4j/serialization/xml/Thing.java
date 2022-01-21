package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "thing")
@XmlAccessorType(XmlAccessType.FIELD)
public class Thing {
    @XmlAttribute
    private String label;
    @XmlElement
    private String description;
    @XmlElement
    private int price;
    @XmlElement
    private int discount;
    @XmlElementWrapper
    @XmlElement(name = "images")
    private Image[] images;
    @XmlElement
    private boolean recycable;

    public Thing() {

    }

    public Thing(String label, String description, int price, int discount, Image[] images, boolean recycable) {
        this.label = label;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.images = images;
        this.recycable = recycable;
    }

   /* @Override
    public String toString() {
        return "Thing{"
                + "label='" + label + '\''
                + ", description='" + description + '\''
                + ", price=" + price
                + ", discount=" + discount
                + ", images=" + Arrays.toString(images)
                + ", recycable=" + recycable
                + '}';
    }*/
}
