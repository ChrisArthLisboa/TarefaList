package org.example;


import java.time.Clock;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
public class Main {


    public static void main(String[] args) {
        try {


            Task task = new Task(
                    Constants.USER.getJSONArray("users").getJSONObject(0).getString("name"),
                    "Tarefa 1",
                    "Descrição da tarefa 1",
                    "Alta",
                    "Não concluída"
            );

            task.SendTask();

            System.out.println(
                    Constants.TASKS
                            .getJSONArray(task.user)
                            .getJSONObject(0)
                            .getString("title")
            );


        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());

        }
    }
}