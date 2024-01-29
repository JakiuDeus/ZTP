package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.SeeInfoCommand;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

class ButtonPanel extends JPanel {
    ImageIcon bulb = new ImageIcon(App.class.getResource("/lightbulb.jpg"));

    public ButtonPanel(MainFrame frame, Map<Integer, BasicComponent> components) {
        setLayout(new GridLayout(4, 3));
        components.keySet().forEach(k -> {
            JButton button;
            BasicComponent bc = components.get(k);
            if (bc == null) {
                button = new JButton("Niepodpięty");
                button.setEnabled(false);
                button.setBackground(Color.orange);
            } else {
                StringBuilder sb = new StringBuilder();
                bc.getType().forEach(type -> sb.append(type.getName()).append(" "));
                button = new JButton(sb.toString());
                button.setIcon(bulb);
                button.setHorizontalTextPosition(AbstractButton.CENTER);
                button.setVerticalTextPosition(AbstractButton.BOTTOM);
                button.setSize(175, 175);
                List<Command> commandList = bc.getCommands();
                commandList.addFirst(new SeeInfoCommand(bc, frame));
                button.addActionListener(e -> new OptionFrame(commandList));
            }
            add(button);
        });
    }


}
