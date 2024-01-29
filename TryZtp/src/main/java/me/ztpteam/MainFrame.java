package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.SeeInfoCommand;
import me.ztpteam.planning.TaskRunner;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private int sizeList = 40;

    private final JButton addButton = new JButton("dodaj");
    private final JLabel taskListLabel = new JLabel("Zaplanowane akcje");

    public MainFrame(String title, Map<Integer, BasicComponent> components) {
        super(title);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new ButtonPanel(this, components);
        taskPanel = new JPanel();
        taskPanel.setLayout(new GridLayout(sizeList,1,10,10));
        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(Color.WHITE);
        firstPanel.add(taskListLabel);
        firstPanel.setPreferredSize(new Dimension(450, 150));
        firstPanel.setBorder(new LineBorder(Color.BLACK, 1));
        firstPanel.add(addButton);
        taskPanel.add(firstPanel);
        addButton.addActionListener(addButtonFunctionality(components));
        infoPanel = new InfoPanel(this);
        JScrollPane rightPanel = new JScrollPane(taskPanel);
        rightPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        leftPanel = new JPanel(new CardLayout());
        leftPanel.setPreferredSize(new Dimension(720,720));
        leftPanel.add(buttonPanel, BUTTON_PANEL);
        leftPanel.add(infoPanel, INFO_PANEL);
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
    private ActionListener addButtonFunctionality(Map<Integer, BasicComponent> components){
        return e -> {
            if(taskPanel.getComponentCount()< sizeList-1){

                taskPanel.add(new SingleTask(taskPanel.getComponentCount(), taskPanel, components));
                taskPanel.revalidate();
                taskPanel.repaint();

            }else{
                addButton.setEnabled(false);
            }
        };
    }
}

