package me.ztpteam;

import com.sun.tools.javac.Main;
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

        Board board = new Board();
        Map<Integer, BasicComponent> components = board.initGetComponents();
        MainFrame mainFrame = new MainFrame("SmartHome", components);





//        components.keySet().forEach(k -> {
//            if (components.get(k) == null) {
//                System.out.println("Port: " + k + ", : NULL");
//            } else {
//                System.out.println("Port: " + k + ", : " + components.get(k).getType().toString());
//            }
//        });
    }
}
