package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.planning.Task;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.Date;
import java.util.List;

public class CommandsPanel extends JPanel {
    private List<Command> commandList;
    Box box;
    public CommandsPanel(TaskEdit taskFrame, Task task) {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        commandList = task.getCommandList();
        box = Box.createVerticalBox();
        commandList.forEach(c -> box.add(new JLabel(c.getCommandType().getName())));
        add(box);
    }

    public void updateCommandList(Task task) {
        removeAll();
        box.removeAll();
        commandList = task.getCommandList();
        commandList.forEach(c -> box.add(new JLabel(c.getCommandType().getName())));
        add(box);
        revalidate();
        repaint();
    }
}
