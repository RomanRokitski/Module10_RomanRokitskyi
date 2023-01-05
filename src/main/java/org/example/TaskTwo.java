package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TaskTwo {

    public static void main(String[] args) {
        JsonArray user = new JsonArray();

        File file = new File("D:\\Goit\\Module10\\Homework10\\untitled\\src\\main\\resources\\userinfo.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean flag = true;
            List<String> columns = null;
            while ((line = br.readLine()) != null) {
                if (flag) {
                    flag = false;
                    columns = Arrays.asList(line.split(" "));
                } else {
                    JsonObject obj = new JsonObject();
                    List<String> chunks = Arrays.asList(line.split(" "));

                    for (int i = 0; i < columns.size(); i++) {
                        obj.addProperty(columns.get(i), chunks.get(i));
                    }
                    user.add(obj);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException io) {
            System.out.println("Cannot read file.");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(user));

        try {
            FileWriter file1 = new FileWriter("D:\\Goit\\Module10\\Homework10\\untitled\\src\\main\\resources\\user.json");
            file1.write(gson.toJson(user));
            file1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
