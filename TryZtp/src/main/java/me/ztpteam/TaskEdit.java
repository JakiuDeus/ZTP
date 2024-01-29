package me.ztpteam;

import me.ztpteam.planning.Task;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Map;

public class TaskEdit extends JFrame {

    TaskEdit(Task task, String title, Map<Integer, BasicComponent> components){

        super(title);
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setLayout(null);
        setSize(600,400);
        JTextField titleField = new JTextField();
        titleField.setBorder(new LineBorder(Color.BLACK, 1));
        titleField.setFont(new Font("Arial", Font.PLAIN, 20));

        JTextField dateField = new JTextField(task.getDate().getHours()+ ":"+ task.getDate().getMinutes());
        dateField.setBorder(new LineBorder(Color.BLACK, 1));
        dateField.setFont(new Font("Arial", Font.PLAIN, 40));

        titleField.setBounds(10,10, 480, 30);
        dateField.setBounds(10, 50, 120, 80);
        add(dateField);
        add(titleField);

        setVisible(true);
    }
}
