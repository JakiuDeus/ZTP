package me.ztpteam.lights;

import me.ztpteam.BasicComponent;
import me.ztpteam.ComponentType;
import me.ztpteam.commands.Command;

import java.util.List;

public interface Light extends BasicComponent {
    void decorate(Light light);
    List<ComponentType> getType();
}
