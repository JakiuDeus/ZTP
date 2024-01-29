package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;
import me.ztpteam.commands.TuneLightCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class SetLedJFrame extends JFrame{
    public SetLedJFrame(SetLEDCommand c) {
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(false);
        Box box = Box.createVerticalBox();
        box.add(new JLabel("Wpisz wartość światła"));
        JTextField textField = new JTextField();
        box.add(textField);
        JButton button = new JButton("Zatwierdź");
        button.addActionListener(e -> {
            c.setLedVal(textField.getText());
            c.execute();
            dispose();
        });
        box.add(button);
        add(box);
        setVisible(true);
    }
}
