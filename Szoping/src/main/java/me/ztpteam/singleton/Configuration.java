package me.ztpteam.singleton;

public class Configuration {
    private static Configuration instance;

    private Configuration() {}

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }
}
