package me.ztpteam.planning;

import me.ztpteam.commands.Command;

import java.util.Date;
import java.util.List;
import java.util.Queue;

public class RepeatableTask extends Task {
    private boolean[] repeat;
    public RepeatableTask(List<Command> commands, Date date, boolean[] repeat) {
        super(commands, date);
        this.repeat = repeat;
    }

    public boolean repeatsAtDay(DayNumberMap day) {
        return repeat[day.value - 1];
    }

    public void setRepeat(boolean[] repeat) {
        this.repeat = repeat;
    }

    public boolean[] getRepeat() {
        return repeat;
    }
}
