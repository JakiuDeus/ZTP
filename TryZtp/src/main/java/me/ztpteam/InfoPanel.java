package me.ztpteam;

import javax.swing.*;
import java.awt.*;

class InfoPanel extends JPanel {
    private JLabel l1 = new JLabel("Empty");
    private JLabel l2 = new JLabel("Empty2");
    private Box box;

    public InfoPanel() {
        l1.setFont(new Font("Serif", Font.PLAIN, 26));
        l2.setFont(new Font("Serif", Font.PLAIN, 26));
        box = Box.createVerticalBox();
        add(box);
        box.add(l1);
        box.add(l2);
    }

    public void setComponent(BasicComponent component) {
        StringBuilder sb = new StringBuilder();
        component.getType().forEach(type -> sb.append(type.getName()).append(" "));
        l1.setText(sb.toString());
        l2.setText("<html>" + component.getStatus() + "</html>");
    }
}
