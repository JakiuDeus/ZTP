package me.ztpteam;

import me.ztpteam.planning.Task;

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
    SingleTask(int count, JPanel taskPanel, Map<Integer, BasicComponent> components){
        id = count;

        setBounds(5,50*count,450,150);
        setLayout(null);
        JLabel taskTitle = new JLabel(String.valueOf(id));
        taskTitle.setBorder(new LineBorder(Color.BLACK, 1));
        taskTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        add(taskTitle);
        taskTitle.setBounds(10,10, 480, 30);


        Task task = new Task(new ArrayList<>(), new Date());

        JLabel taskDate = new JLabel("test");
        taskDate.setBorder(new LineBorder(Color.BLACK, 1));
        taskDate.setFont(new Font("Arial", Font.PLAIN, 40));
        add(taskDate);
        taskDate.setBounds(10,70, 150, 60);

        JButton onButton = new JButton(powerIcon);
        onButton.setBounds(222, 90, 50, 50);
        add(onButton);

        JButton editButton = new JButton(editIcon);
        editButton.setBounds(305, 90, 50, 50);
        editButton.setBackground(Color.white);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskEdit taskEdit = new TaskEdit(task, "TaskEdit", components);
            }
        });
        add(editButton);

        JButton deleteButton = new JButton(deleteIcon);
        deleteButton.setBounds(388, 90, 50, 50);
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

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
}
