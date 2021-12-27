package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Random rnd = new Random();
        List<String> botPhrases = readPhrases();
        List<String> dialog = new ArrayList<>();
        boolean isKeepTalking = true;
        Scanner scanner = new Scanner(System.in);
        String userPhrase = null;
        String botPhrase;
        while (!OUT.equals(userPhrase)) {
            userPhrase = scanner.nextLine();
            dialog.add(userPhrase);
            switch (userPhrase) {
                case OUT:
                    break;
                case STOP:
                    isKeepTalking = false;
                    break;
                case CONTINUE:
                    isKeepTalking = true;
                default:
                    if (isKeepTalking) {
                        botPhrase = botPhrases.get(rnd.nextInt(botPhrases.size()));
                        System.out.println(botPhrase);
                        dialog.add(botPhrase);
                    }
            }
        }
        saveLog(dialog);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/consoleChat.txt", "./data/botAnswers.txt");
        cc.run();
    }
}
