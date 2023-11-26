package me.ztpteam.components;

public class NameComponent extends Component {
    private String name;

    public NameComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
