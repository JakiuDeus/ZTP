package me.ztpteam;

import me.ztpteam.planning.Task;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ComponentFrame extends JFrame {

    int i = 0;

    ComponentFrame(String title, TaskEdit taskEdit, Map<Integer, BasicComponent> components, Task task){
        super(title);
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setLayout(null);
        setSize(400,400);
        components.keySet().forEach(k -> {
            JButton compButton;
            BasicComponent bc = components.get(k);
            if (bc != null) {

                StringBuilder sb = new StringBuilder();
                bc.getType().forEach(type -> sb.append(type.getName()).append(" "));
                compButton = new JButton(sb.toString());
                compButton.setBounds(50,10+i*50,300, 50);
                compButton.addActionListener(e -> {

                    CommandFrame commandFrame = new CommandFrame(sb.toString(), taskEdit, this, bc, task);
                });
                i++;
                add(compButton);
            }
        });
        setVisible(true);
    }
}
