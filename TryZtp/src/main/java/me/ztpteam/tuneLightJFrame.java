package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.TuneLightCommand;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class TuneLightJFrame extends JFrame {
    public TuneLightJFrame(TuneLightCommand c) {
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(false);
        Box box = Box.createVerticalBox();
        box.add(new JLabel("Wybierz wartość jasności"));
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        JLabel l = new JLabel(String.valueOf(slider.getValue()));
        slider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                l.setText(String.valueOf(source.getValue()));
                l.revalidate();
                l.repaint();
            }
        });
        box.add(slider);
        box.add(l);
        JButton button = new JButton("Zatwierdź");
        button.addActionListener(e -> {
            c.setTuneVal((byte) slider.getValue());
            c.execute();
            dispose();
        });
        box.add(button);
        add(box);
        setVisible(true);
    }
}
