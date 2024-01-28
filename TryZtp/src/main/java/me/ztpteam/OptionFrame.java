package me.ztpteam;

import me.ztpteam.commands.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class OptionFrame extends JFrame {

    public OptionFrame(List<Command> commands) {
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setFocusable(true);
        setLayout(new GridLayout(commands.size(), 1));
        setSize(150, commands.size() * 50);
        setUndecorated(true);
        for (Command c : commands) {
            JButton button = new JButton(c.getCommandType().getName());
            button.setSize(150, 50);
            button.addActionListener(e -> {
                c.execute();
                dispose();
            });
            add(button);
        }
        addWindowFocusListener(new WindowFocusAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}
