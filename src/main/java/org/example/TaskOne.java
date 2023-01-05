package org.example;

import java.io.*;

public class TaskOne {
    public static void main(String[] args) {
        String ABSOLUTE_PATH = "D:\\Goit\\Module10\\Homework10\\untitled\\src\\main\\resources\\file.txt";
        File file = new File(ABSOLUTE_PATH);

        if (!file.exists()) {
            throw new RuntimeException("File with name" + file.getName() + " not exist");
        }

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fileReader);

            while (reader.ready()) {
                String phoneNumber = reader.readLine();
                if (phoneNumber.contains("-")) {
                    System.out.println(phoneNumber);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}