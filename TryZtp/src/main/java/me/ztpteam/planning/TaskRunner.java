package me.ztpteam.planning;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class TaskRunner extends Thread{

    private static TaskRunner instance;
    private long date;
    private List<Task> tasks;

    private TaskRunner() {}

    public TaskRunner getInstance() {
        if (instance == null) {
            instance = new TaskRunner();
            return instance;
        }
        return instance;
    }

    @Override
    public void run() {
        if (System.currentTimeMillis() - date > 5000) {
            tasks.forEach(task -> {
                if (task.isActive() && task.getDate().before(Date.from(Instant.now()))) {
                    task.execute();
                }
            });
            date = System.currentTimeMillis();
        }
    }
}
