package me.ztpteam;

import me.ztpteam.planning.Task;
import me.ztpteam.planning.TaskRunner;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class SingleTask extends JPanel {

    private ImageIcon deleteIcon = new ImageIcon(this.getClass().getResource("/delete.png"));
    private ImageIcon editIcon = new ImageIcon(this.getClass().getResource("/edit.png"));
    private ImageIcon powerIcon = new ImageIcon(this.getClass().getResource("/power.png"));
    private int id;

    private JLabel taskTitle;
    private JLabel taskDate;
    SingleTask(int count, JPanel taskPanel, Map<Integer, BasicComponent> components){
        Date currentDate = new Date();
        long currentTimeMillis = currentDate.getTime();
        long oneHourInMillis = (long) 60 * 60 * 1000;
        long updatedTimeMillis = currentTimeMillis + oneHourInMillis;
        Date updatedDate = new Date(updatedTimeMillis);
        updatedDate.setSeconds(0);
        Task task = new Task(new ArrayList<>(),  updatedDate);
        TaskRunner.getInstance().addTask(task);
        id = count;

        setBounds(5,50*count,450,150);
        setLayout(null);
        taskTitle = new JLabel(task.getName());
        taskTitle.setBorder(new LineBorder(Color.BLACK, 1));
        taskTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        add(taskTitle);
        taskTitle.setBounds(10,10, 480, 30);
        taskDate = new JLabel(task.getDate().getHours()+ ":"+ task.getDate().getMinutes());
        taskDate.setBorder(new LineBorder(Color.BLACK, 1));
        taskDate.setFont(new Font("Arial", Font.PLAIN, 40));
        add(taskDate);
        taskDate.setBounds(10,70, 150, 60);

        JButton onButton = new JButton(powerIcon);
        onButton.setBounds(222, 90, 50, 50);
        onButton.setBackground(Color.white);
        add(onButton);

        JButton editButton = new JButton(editIcon);
        editButton.setBounds(305, 90, 50, 50);
        editButton.setBackground(Color.white);
        editButton.addActionListener(e -> {
            TaskEdit taskEdit = new TaskEdit(task, "TaskEdit", components, this);
        });
        add(editButton);

        JButton deleteButton = new JButton(deleteIcon);
        deleteButton.setBounds(388, 90, 50, 50);
        deleteButton.setBackground(Color.white);
        deleteButton.addActionListener(e -> {
            taskPanel.remove(this);
            taskPanel.revalidate();
            taskPanel.repaint();
            for(int i = id+1; i < taskPanel.getComponentCount(); i++ ){
                SingleTask p = (SingleTask) taskPanel.getComponent(i);
                p.setBounds(5,50*i,450,150);
                p.setId(i);
            }
        });
        add(deleteButton);
        setBorder(new LineBorder(Color.BLACK, 1));
    }

    public void updateTask(Task task) {
        taskTitle.setText(task.getName());
        taskDate.setText(task.getDate().getHours()+ ":"+ task.getDate().getMinutes());
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
}
