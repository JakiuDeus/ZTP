package me.ztpteam.singleton;

public class Configuration {
    private static Configuration instance;

    private String DataBaseKeyHash = """
            157d4b05faf3fa754adcbec834227c19
            877c43adac5f59cbe1014cf28e0f01b7
            f25d33044a998f4c9ef5e38f16bba9cb
            59cc31239afbbd6536e3a369c7b85023
            5fc022e972ff05e5ddf821f63222948c
            8151288d4e0ba62e83e60c81a2ceeb44
            27b7646a43842344aeaa390e6021b6bb
            cd078ec3a91ae793d257717f80b54bff
            32abbe8884ad43bab28019111bbb4ce4
            7f842e6cf3e1d504583544947d3b069e""";

    private Configuration() {}

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }
    // Metoda sprawdza czy istnieje połączenie z bazą danych
    public boolean isOnline() {
        System.out.println("Testing connection to database");
        return true;
    }

    // Normalnie zwraca ścieżkę do zdjęć produktu
    public String getImgPath() {
        return "/src/main/resources/img";
    }

    public String getPricePath() {
        return "/src/main/resources/price";
    }
}
