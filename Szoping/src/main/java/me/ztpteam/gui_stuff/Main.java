package me.ztpteam.gui_stuff;

import me.ztpteam.singleton.Configuration;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {

    private JPanel mainPanel;
    private JPanel buttonPanel;
    private List<JButton> buttons = new ArrayList<>();
    private List<JLabel> labels = new ArrayList<>();

    public Main () {
        Configuration configuration = Configuration.getInstance();
        Scanner priceScanner = new Scanner(configuration.getPricePath());
        String imagePath = configuration.getImgPath();
        for(int i=0; i<16; i++) {
            JButton button = new JButton("button"+i+1);
            button.setIcon(new ImageIcon(img));
            buttons.add(button);
        }
        setContentPane(mainPanel);
        setTitle("Simple GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
