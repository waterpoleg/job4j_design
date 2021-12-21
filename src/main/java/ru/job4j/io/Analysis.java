package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        List<String> downtime = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = in.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder tmp = null;
        for (var line : list) {
            String[] times = line.split(" ");
            if (("400".equals(times[0]) || "500".equals(times[0])) && tmp == null) {
                tmp = new StringBuilder(times[1] + ";");
            } else if (("200".equals(times[0]) || "300".equals(times[0])) && tmp != null) {
                tmp.append(times[1]).append(";");
                downtime.add(tmp.toString());
                tmp = null;
            }
        }
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            downtime.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("src/main/java/ru/job4j/io/server.log",
                "src/main/java/ru/job4j/io/target.log");
        analysis.unavailable("src/main/java/ru/job4j/io/server_2.log",
                "src/main/java/ru/job4j/io/target_2.log");
    }
}