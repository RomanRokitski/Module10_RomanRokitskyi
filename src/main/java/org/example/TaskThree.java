package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskThree {
    static void CountWords(String filename, Map<String, Integer> words) throws FileNotFoundException {

        Scanner file = new Scanner(new File(filename));
        while (file.hasNext()) {
            String word = file.next();
            Integer count = words.get(word);
            if (count != null)
                count++;
            else
                count = 1;
            words.put(word, count);
        }
        file.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String ABSOLUTE_PATH = "D:\\Goit\\Module10\\Homework10\\untitled\\src\\main\\resources\\words.txt";
        Map<String, Integer> words = new HashMap<>();
        CountWords(ABSOLUTE_PATH, words);
        words.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}

