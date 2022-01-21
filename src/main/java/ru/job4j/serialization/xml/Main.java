package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        final Thing thing = new Thing(
                "label",
                "description",
                125,
                35,
                new Image[]{new Image("link1"), new Image("link2"), new Image("link3")},
                true);

        JAXBContext context = JAXBContext.newInstance(Thing.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(thing, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Thing result = (Thing) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
