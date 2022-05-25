package ru.job4j.ood.srp;

import java.util.function.Predicate;

public class DevsReport implements Report {

    private Store store;

    public DevsReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder html = new StringBuilder();
        html.append("<!doctype html>\n")
                .append("<html lang='en'>\n")
                .append("<head>\n")
                .append("<meta charset='utf-8'>\n")
                .append("<title>Salary report</title>\n")
                .append("</head>\n");
        StringBuilder body = new StringBuilder();
        body.append("<body>")
                .append("<table>")
                .append("<tr>")
                .append("<th>Name</th>")
                .append("<th>Hired</th>")
                .append("<th>Fired</th>")
                .append("<th>Salary</th>")
                .append("</tr>");
        for (Employee employee : store.findBy(filter)) {
            body.append("<tr>")
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td>")
                    .append("</tr>");
        }
        body.append("</table>").append("</body>");
        return html.append(body).append("</html>").toString();
    }
}
