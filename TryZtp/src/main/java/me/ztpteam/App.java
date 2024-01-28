package me.ztpteam;

import me.ztpteam.boards.Board;
import me.ztpteam.boards.ButtonBoard;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;
import me.ztpteam.lights.BasicLight;
import me.ztpteam.lights.LED;
import me.ztpteam.lights.Light;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Hello world!
 *
 */
public class App 
{
    public static JFrame frame;
    public static JPanel buttons;
    public static JPanel right;
    public static JSplitPane s1;
    public static TextArea terminal;
    public static JButton[] buttonBoard = new JButton[12];
    public static ImageIcon bulb = new ImageIcon("/lightbulb.jpg");
    public static int i = 0;
    public static void main( String[] args )
    {
        frame = new JFrame();
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttons = new JPanel(new GridLayout(4,3));
        terminal = new TextArea("tescik");
        right  = new JPanel();
        right.add(terminal);
        s1 = new JSplitPane(SwingConstants.VERTICAL, buttons, right);


        Board board = new Board();
        Map<Integer, BasicComponent> components = board.initGetComponents();
        components.keySet().forEach(k -> {
            if (components.get(k) == null) {
                System.out.println("Port: " + k + ", : NULL");
            } else {
                System.out.println("Port: " + k + ", : " + components.get(k).getType().toString());
            }
        });



       components.keySet().forEach(k ->{
           BasicComponent bc  = components.get(k);
           if (bc == null) {
               buttonBoard[i] = new JButton("Niepodpięty");
               buttonBoard[i].setEnabled(false);
               buttonBoard[i].setBackground(Color.orange);
               buttons.add(buttonBoard[i]);
               i++;
           }else {
               System.out.println(bc.getType());
               System.out.println(bc.getStatus());
               buttonBoard[i] = new JButton(String.valueOf(bc.getType()));
               buttonBoard[i].setIcon(bulb);
               buttonBoard[i].setHorizontalTextPosition(AbstractButton.CENTER);
               buttonBoard[i].setVerticalTextPosition(AbstractButton.BOTTOM);
               buttons.add(buttonBoard[i]);
               i++;
               bc.getCommands().forEach(c -> System.out.println("\t" + c.getType() + " " + c));
           }


       });{

        }

        frame.add(s1);
        frame.setVisible(true);
//        List<Command> commands = light.getCommands();
//        System.out.println(commands);
//        System.out.println();
//        System.out.println(light.getStatus());
//        System.out.println();
        // Tworzenie przycisków
//        SetLEDCommand setLEDCommand = null;
//        for (Command command : ) {
//            if (command.getType() == ComponentType.LED) {
//                setLEDCommand = (SetLEDCommand) command;
//            }
//        }
//        // Wciśnięcie przycisku
//        if (setLEDCommand != null) {
//            setLEDCommand.setLedVal("#AABBAA");
//            setLEDCommand.execute();
//        }
//
//        for (Command command : commands) {
//            if (command.getType() == ComponentType.BASIC_LIGHT) {
//                command.execute();
//            }
//        }
//        System.out.println(light.getStatus());
//        System.out.println();
    }
}
