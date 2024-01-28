package me.ztpteam;

import me.ztpteam.boards.Board;

import javax.swing.*;
import java.awt.*;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ImageIcon test = new ImageIcon(App.class.getResource("/lightbulb.jpg"));

        Board board = new Board();
        Map<Integer, BasicComponent> components = board.initGetComponents();
        MainFrame mainFrame = new MainFrame("SmartHome", components);





//        components.keySet().forEach(k -> {
//            if (components.get(k) == null) {
//                System.out.println("Port: " + k + ", : NULL");
//            } else {
//                System.out.println("Port: " + k + ", : " + components.get(k).getType().toString());
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
