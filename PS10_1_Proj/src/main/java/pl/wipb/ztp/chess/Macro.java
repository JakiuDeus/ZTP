package pl.wipb.ztp.chess;

import java.util.LinkedList;
import java.util.List;

public class Macro implements ICommand {

    private final List<ICommand> commands = new LinkedList<>();

    public void addCommand(ICommand command) {
        commands.addLast(command);
    }
    @Override
    public void undo() {
        commands.forEach(ICommand::undo);
    }

    @Override
    public void redo() {
        commands.reversed().forEach(ICommand::redo);
    }
}
