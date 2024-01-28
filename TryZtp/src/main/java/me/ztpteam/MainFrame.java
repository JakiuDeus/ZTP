package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.SeeInfoCommand;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;


public class MainFrame extends JFrame {

    private static final String BUTTON_PANEL = "BUTTON_PANEL";
    public static final String INFO_PANEL = "INFO_PANEL";
    private final JPanel buttonPanel;
    private JPanel leftPanel;
    private final JPanel taskPanel;
    private JPanel rightPanel;
    private InfoPanel infoPanel;
    private final JSplitPane splitPane;

    public MainFrame(String title, Map<Integer, BasicComponent> components) {
        super(title);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ButtonPanel(this, components);
        taskPanel = new JPanel();
        infoPanel = new InfoPanel();
        leftPanel = new JPanel(new CardLayout());
        leftPanel.add(buttonPanel, BUTTON_PANEL);
        leftPanel.add(infoPanel, INFO_PANEL);
        rightPanel = new JPanel();
        rightPanel.add(taskPanel);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

        add(splitPane);
        setVisible(true);
    }

    public void setInfoPanel(BasicComponent component) {
        CardLayout cl = (CardLayout)leftPanel.getLayout();
        infoPanel.setComponent(component);
        cl.show(leftPanel, INFO_PANEL);
    }

    public void setButtonPanel() {
        CardLayout cl = (CardLayout)leftPanel.getLayout();
        cl.show(leftPanel, BUTTON_PANEL);
    }
}

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
        l2.setText("<html>"+component.getStatus()+"</html>");
    }
}

class ButtonPanel extends JPanel {
    ImageIcon bulb = new ImageIcon("/lightbulb.jpg");
    public ButtonPanel(MainFrame frame, Map<Integer, BasicComponent> components) {
        setLayout(new GridLayout(4, 3));
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
                List<Command> commandList = bc.getCommands();
                commandList.addFirst(new SeeInfoCommand(bc, frame));
                button.addActionListener(e -> new OptionFrame(commandList));
            }
            add(button);
        });
    }
}
