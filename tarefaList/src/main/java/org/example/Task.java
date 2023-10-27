package org.example;

import org.json.JSONObject;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Clock;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class Task{

    public String user;
    public String title;
    public String description;
    public String date;
    public String time;
    public String priority;
    public String status;

    public Task(String user, String title, String description, String priority, String status) {

        try {

            this.user = user;
            this.title = title;

            this.date = ZonedDateTime.now(Clock.systemUTC()).getYear() +
                    "-" +
                    ZonedDateTime.now(Clock.systemUTC()).getMonth()  +
                    "-" +
                    ZonedDateTime.now(Clock.systemUTC()).getDayOfMonth() ;

            this.time = ZonedDateTime.now(Clock.systemUTC()).getHour()  +
                    ":" +
                    ZonedDateTime.now(Clock.systemUTC()).getMinute() ;

            this.description = description;
            this.priority = priority;
            this.status = status;

        } catch (Exception e) {
            System.out.println("Não foi possível criar a tarefa.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    public void SendTask() {

        try {
            Writer writer = Files.newBufferedWriter(Paths.get(Main.class.getResource("/tasks.json").toURI()));

            writer.write(
                    Constants.TASKS
                            .(this.user)
                            .put(
                                    new JSONObject()
                                            .put("title", this.title)
                                            .put("date", this.date)
                                            .put("time", this.time)
                                            .put("description", this.description)
                                            .put("priority", this.priority)
                                            .put("status", this.status)
                            ).toString()
            );

        } catch (Exception e) {
            System.out.println("Não foi possível enviar a tarefa.");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }

    }
}
