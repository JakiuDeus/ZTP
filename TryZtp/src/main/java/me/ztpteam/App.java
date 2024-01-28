package me.ztpteam;

import me.ztpteam.boards.Board;
import me.ztpteam.boards.Port;
import me.ztpteam.commands.Command;
import me.ztpteam.commands.SetLEDCommand;
import me.ztpteam.lights.BasicLight;
import me.ztpteam.lights.LED;
import me.ztpteam.lights.Light;

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
    public static void main( String[] args )
    {
        Board board = new Board();
        Map<Integer, BasicComponent> components = board.initGetComponents();
        components.keySet().forEach(k -> {
            if (components.get(k) == null) {
                System.out.println("Port: " + k + ", : NULL");
            } else {
                System.out.println("Port: " + k + ", : " + components.get(k).getType().toString());
            }
        });


//        for (BasicComponent bc : components) {
//            System.out.println(bc.getType());
//            System.out.println(bc.getStatus());
//            bc.getCommands().forEach(c -> System.out.println("\t" + c.getType() + " " + c));
//        }




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