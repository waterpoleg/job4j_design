package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class AccountReport implements Report {

    public final static double SALARY_RATE = 0.75;
    private Store store;

    public AccountReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() * SALARY_RATE).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
