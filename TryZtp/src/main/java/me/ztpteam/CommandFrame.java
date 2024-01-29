package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.planning.Task;

import javax.swing.*;
import java.awt.*;

import java.util.List;

public class CommandFrame extends JFrame {
    int i = 0;

    CommandFrame(String title, TaskEdit taskEdit, ComponentFrame componentFrame, BasicComponent bc, Task task){
        super(title);
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setLayout(null);
        setSize(400,400);
        bc.getCommands().forEach(k ->{
            JButton commandButton  = new JButton(k.getCommandType().getName());
            commandButton.setBounds(50,10+i*50,300, 50);
            commandButton.addActionListener(e ->{
                List<Command> tmp = task.getCommandList();
                tmp.add(k);
                task.setCommandList(tmp);
                taskEdit.getCommandPanel().updateCommandList(task);
            });
            add(commandButton);
            i++;
        });


        setVisible(true);
    }
}
