package me.ztpteam.commands;

import me.ztpteam.BasicComponent;
import me.ztpteam.ComponentType;
import me.ztpteam.MainFrame;
import me.ztpteam.boards.Status;

import javax.swing.*;

public class SeeInfoCommand implements Command {

    private BasicComponent component;
    private MainFrame frame;
    
    public SeeInfoCommand(BasicComponent component, MainFrame frame) {
        this.component = component;
        this.frame = frame;
    }
    
    @Override
    public Status execute() {
        frame.setInfoPanel(component);
        return Status.SUCCESS;
    }

    @Override
    public ComponentType getComponentType() {
        return component.getType().getFirst();
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.SEE_INFO;
    }
}
