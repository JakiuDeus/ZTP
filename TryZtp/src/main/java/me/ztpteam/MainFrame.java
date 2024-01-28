package me.ztpteam;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {

    private final JPanel buttonPanel;
    private final JPanel taskPanel;
    private final JSplitPane splitPane;

    private static ImageIcon bulb = new ImageIcon("/lightbulb.jpg");

    public MainFrame(String title, Map<Integer, BasicComponent> components) {
        super(title);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new JPanel(new GridLayout(4, 3));
        taskPanel = new JPanel();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, taskPanel);

        components.keySet().forEach(k -> {
            JButton button;
            BasicComponent bc  = components.get(k);
            if (bc == null) {
                button = new JButton("Niepodpięty");
                button.setEnabled(false);
                button.setBackground(Color.orange);
            } else {
                button = new JButton(String.valueOf(bc.getType()));
                button.setIcon(bulb);
                button.setHorizontalTextPosition(AbstractButton.CENTER);
                button.setVerticalTextPosition(AbstractButton.BOTTOM);
            }
            buttonPanel.add(button);
            buttonPanel.add(button);
        });
        add(splitPane);
        setVisible(true);
        System.out.println(buttonPanel.getComponent(0));
    }
}
