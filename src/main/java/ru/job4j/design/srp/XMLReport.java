package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XMLReport implements Report {

    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            try (StringWriter out = new StringWriter()) {
                List<Employee> employees = store.findBy(filter);
                marshaller.marshal(new Employees(employees), out);
                xml = out.getBuffer().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xml;
    }
}
