package me.ztpteam;

import me.ztpteam.commands.Command;
import me.ztpteam.commands.SeeInfoCommand;

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
    private JPanel infoPanel;
    private final JSplitPane splitPane;
    private int sizeList = 40;

    private final JButton addButton = new JButton("dodaj");
    private final JLabel taskListLabel = new JLabel("Zaplanowane akcje");





    private static ImageIcon bulb = new ImageIcon("/lightbulb.jpg");

    public MainFrame(String title, Map<Integer, BasicComponent> components) {
        super(title);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonPanel = new JPanel(new GridLayout(4, 3));
        taskPanel = new JPanel();
        JScrollPane rightPanel = new JScrollPane(taskPanel);
        rightPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        infoPanel = new JPanel();
        infoPanel.add(new JLabel("INFO"));
        leftPanel = new JPanel(new CardLayout());
        leftPanel.setPreferredSize(new Dimension(720,720));

        leftPanel.add(buttonPanel, BUTTON_PANEL);
        leftPanel.add(infoPanel, INFO_PANEL);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);


        taskPanel.setLayout(new GridLayout(sizeList,1,10,10));

        JPanel firstPanel = new JPanel();
        firstPanel.setBackground(Color.WHITE);
        firstPanel.add(taskListLabel);
        firstPanel.setPreferredSize(new Dimension(450, 150));
        firstPanel.setBorder(new LineBorder(Color.BLACK, 1));
        firstPanel.add(addButton);
        taskPanel.add(firstPanel);
        addButton.addActionListener(addButtonFunctionality(components));



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
                button.setSize(175,175);
                List<Command> commandList = bc.getCommands();
                commandList.addFirst(new SeeInfoCommand(bc, this));
                button.addActionListener(e -> new OptionFrame(commandList));
            }
            buttonPanel.add(button);
            buttonPanel.add(button);
        });

        add(splitPane);
        setVisible(true);
        System.out.println(buttonPanel.getComponent(0));
    }

    public void setInfoPanel() {
        CardLayout cl = (CardLayout)leftPanel.getLayout();
        cl.show(leftPanel, INFO_PANEL);
    }

    public void setButtonPanel() {
        CardLayout cl = (CardLayout)leftPanel.getLayout();
        cl.show(leftPanel, BUTTON_PANEL);
    }
    private ActionListener addButtonFunctionality(Map<Integer, BasicComponent> components){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(taskPanel.getComponentCount()< sizeList-1){

                    taskPanel.add(new SingleTask(taskPanel.getComponentCount(), taskPanel, components));
                    taskPanel.revalidate();
                    taskPanel.repaint();

                }else{
                    addButton.setEnabled(false);
                }
            }
        };
    }


}
