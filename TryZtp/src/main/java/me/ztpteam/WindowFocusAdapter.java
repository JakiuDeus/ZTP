package me.ztpteam;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public abstract class WindowFocusAdapter implements WindowFocusListener {
    @Override
    public void windowGainedFocus(WindowEvent e) {

    }

    public abstract void windowLostFocus(WindowEvent e);
}
