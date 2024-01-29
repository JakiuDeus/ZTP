package me.ztpteam.planning;

import me.ztpteam.commands.Command;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class Task {
    protected Date date;
    protected String name;
    protected boolean isActive;
    protected List<Command> commandList;
    public Task(List<Command> commands, Date date) {
        commandList = commands;
        this.date = date;
        isActive = true;
        name = "Nowy Task";
    }

    public void execute() {
        for (Command c : commandList) {
            c.execute();
        }
        isActive = false;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Command> commands) {
        commandList = commands;
    }

    public Date getDate() {
        return date;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
