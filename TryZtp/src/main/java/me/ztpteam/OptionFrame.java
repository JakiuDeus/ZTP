package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;
import me.ztpteam.commands.TuneLightCommand;

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
                if (c instanceof SetLEDCommand) {
                    new SetLedJFrame((SetLEDCommand) c);
                } else if (c instanceof TuneLightCommand) {
                    new TuneLightJFrame((TuneLightCommand) c);
                } else {
                    c.execute();
                }
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
