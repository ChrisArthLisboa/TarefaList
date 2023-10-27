package org.example;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

    public static final JSONObject USER = JSONPull("/user.json");
    public static final JSONObject TASKS = JSONPull("/tasks.json");

    static public final class User {

        public static class HowMuchTasks {

            protected HowMuchTasks(int done, int notDone) {
                this.all = done + notDone;
                this.done = done;
                this.notDone = notDone;
            }

            protected int all;
            protected int done;
            protected int notDone;
        }

        public static String name;
        public static HowMuchTasks Tasks;
        public static String email;
        public static String password;
    }

    private static JSONObject JSONPull(String path) {

        try {

            Path filePath = Paths.get(Main.class.getResource(path).toURI());

            String fileContent = Files.readString(filePath, StandardCharsets.UTF_8);

            JSONObject jsonFile = new JSONObject(fileContent);

            return jsonFile;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
