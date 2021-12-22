package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String line;
            StringBuilder tmp = null;
            while ((line = in.readLine()) != null) {
                String[] times = line.split(" ");
                if (("400".equals(times[0]) || "500".equals(times[0])) && tmp == null) {
                    tmp = new StringBuilder(times[1] + ";");
                } else if (("200".equals(times[0]) || "300".equals(times[0])) && tmp != null) {
                    out.println(tmp.append(times[1]).append(";"));
                    tmp = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log", "./data/target.log");
        analysis.unavailable("./data/server_2.log", "./data/target_2.log");
    }
}