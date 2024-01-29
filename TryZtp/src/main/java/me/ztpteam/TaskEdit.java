package me.ztpteam;

import me.ztpteam.planning.Task;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class TaskEdit extends JFrame {
    private Task task;
    TaskEdit(Task task1, String title, Map<Integer, BasicComponent> components, SingleTask singleTask){

        super(title);
        this.task = task1;
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setLayout(null);
        setSize(600,400);
        JTextField titleField = new JTextField(task.getName());
        titleField.setBorder(new LineBorder(Color.BLACK, 1));
        titleField.setFont(new Font("Arial", Font.PLAIN, 20));

        JTextField dateField = new JTextField(task.getDate().getHours()+ ":"+ task.getDate().getMinutes());
        dateField.setBorder(new LineBorder(Color.BLACK, 1));
        dateField.setFont(new Font("Arial", Font.PLAIN, 40));



        titleField.setBounds(10,10, 480, 30);
        dateField.setBounds(10, 50, 120, 80);
        add(dateField);
        add(titleField);
        CommandsPanel commandsPanel = new CommandsPanel(this, task);
        JScrollPane rightPanel = new JScrollPane(commandsPanel);
        rightPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        rightPanel.setBounds(10, 140, 480, 500);
        add(rightPanel);
        JButton button = new JButton("Zatwierdź");
        button.addActionListener(e -> {
            task.setName(titleField.getText());
            saveStringDate(dateField.getText(), task);
            singleTask.updateTask(task);
            dispose();
        });
        button.setBounds(200, 50, 150, 50);
        add(button);

        setVisible(true);
    }
    public void saveStringDate(String date, Task task) {
        String[] hm = date.split(":");
        Date d = task.getDate();
        d.setHours(Integer.parseInt(hm[0]));
        d.setMinutes(Integer.parseInt(hm[1]));
        task.setDate(d);
        this.task = task;
    }
}
