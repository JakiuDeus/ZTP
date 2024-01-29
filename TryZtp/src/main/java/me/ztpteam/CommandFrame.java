package me.ztpteam;

import javax.swing.*;
import java.awt.*;

public class CommandFrame extends JFrame {

    CommandFrame(String title, TaskEdit taskEdit, ComponentFrame componentFrame){
        super(title);
        setLocation(MouseInfo.getPointerInfo().getLocation());
        setLayout(null);
        setSize(400,400);
    }
}
