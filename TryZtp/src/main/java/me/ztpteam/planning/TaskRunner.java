package me.ztpteam.planning;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRunner extends Thread{

    private static TaskRunner instance;
    private static long date;
    private List<Task> tasks = new ArrayList<>();

    private TaskRunner() {}

    public static TaskRunner getInstance() {
        if (instance == null) {
            instance = new TaskRunner();
            date = new Date().getTime();
            instance.start();
            return instance;
        }
        return instance;
    }

    @Override
    public void run() {
        while (true) {
            if (System.currentTimeMillis() - date > 1000) {
                tasks.forEach(task -> {
                    System.out.println(task.getDate()+ " " + new Date(date));
                    System.out.println(task.getDate().before(Date.from(Instant.now())));
                    if (task.isActive() && task.getDate().before(Date.from(Instant.now()))) {
                        task.execute();

                    }
                });
                date = System.currentTimeMillis();
            }

        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
