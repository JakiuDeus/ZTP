package me.ztpteam.boards;

import me.ztpteam.BasicComponent;
import me.ztpteam.lights.BasicLight;
import me.ztpteam.lights.LED;
import me.ztpteam.lights.TunableLight;

import java.util.*;

public class Board {
    private final Map<Port, BasicComponent> components;
    private final List<Port> ports;

    public Board() {
        components = new HashMap<>();
        ports = new ArrayList<>();
        for (int i=0; i<12; i++) {
            Port p = new Port(i);
            ports.add(i, p);
            components.put(p, null);
        }
    }

    public Map<Integer, BasicComponent> initGetComponents() {
        initialize();
        if(checkStatus() == Status.ERROR) {
            return null;
        }
        Map<Integer, BasicComponent> newMap = new HashMap<>();
        for (int i=0; i<12; i++) {
            newMap.put(i, components.get(ports.get(i)));
        }
        return newMap;
    }

    public List<BasicComponent> getComponentList() {
        List<BasicComponent> componentList = new ArrayList<>();
        for (Port p : ports) {
            BasicComponent component = components.get(p);
            if (component != null) {
                componentList.add(component);
            }
        }
        return componentList;
    }

    private Status checkStatus() {
        for (Port p : ports) {
            if (p.respond() != Status.SUCCESS) {
                return Status.ERROR;
            }
        }
        return Status.SUCCESS;
    }

    private void initialize() {
        for (Port p : ports) {
            String componentType = p.getComponentType();
            switch (componentType) {
                case "10" -> components.put(p, new BasicLight(p));
                case "110" -> components.put(p, new LED(new BasicLight(p)));
                case "120" -> components.put(p, new TunableLight(new BasicLight(p)));
                case "1120" -> components.put(p, new LED(new TunableLight(new BasicLight(p))));
                case "20" -> todo(); //components.put(p, new BasicFridge());
                case "210" -> todo(); //components.put(p, new Refrigerator(new BasicFridge()));
                case "30" -> todo(); //components.put(p, new CoffeeMachine());
                case "40" -> todo(); //components.put(p, new WashingMachine());
                case "50" -> todo(); //components.put(p, new Dryer());
                case "60" -> todo(); //components.put(p, new Computer());
                case "70" -> todo(); //components.put(p, new TV());
                case "710" -> todo(); //components.put(p, new SmartHome(new TV()));
                case "720" -> todo(); //components.put(p, new Theater(new TV()));
                case "7120" -> todo(); //components.put(p, new SmartHome(new Theater(new TV())));
                case "80" -> todo(); //components.put(p, new Kettle());
                case "90" -> todo(); //components.put(p, new Microwave());
            }
        }
    }

    private void todo() {
    }
}
