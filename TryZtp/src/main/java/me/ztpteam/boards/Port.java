package me.ztpteam.boards;

import me.ztpteam.ComponentType;

import java.util.Random;

public class Port {
    private int id;

    public Port(int id) {
        this.id = id;
    }

    public Status send(String instructions) {
        // Przesyłamy nasze instrukcje przez port i oczekujemy odpowiedzi komponentu
        System.out.println("PORT ID: " + id + ", INSTRUCTIONS: " + instructions);
        return respond();
    }

    public Status respond() {
        // Tutaj zwracamy odpowiedź komponentu na zadaną instrukcję
        return Status.SUCCESS;
    }

    public int getId() {
        return id;
    }
    public String getComponentType() {
        /*
        Dzieli się od lewej na sekwencję najbardziej znaczącą
        0 - Nie wykryto, reszta to dane śmieciowe
        1 - Światło
            Kolejne znaki w dowolnej kolejności mówią o tym jakiego typu to światło
            0 - Koniec
            1 - LED
            2 - Tunable
        2 - Lodówka
            0 - Koniec
            1 - Z zamrażarką
        3 - Maszyna do kawy
        4 - Pralka
        5 - Suszarka
        6 - Komputer
        7 - Telewizor
            0 - Koniec
            1 - SmartHome
            2 - Z kinem domowym (Nagłośnienie)
        8 - Czajnik
        9 - Mikrofalówka
         */
        // Poniższa część kodu generuje komponenty na potrzeby testów i jest zastąpieniem komunikacji

        String[] types = new String[10];
        types[0] = "0";
        types[1] = "10";
        types[2] = "110";
        types[3] = "1120";
        types[4] = "120";
        types[5] = "30";
        types[6] = "40";
        types[7] = "210";
        types[8] = "80";
        types[9] = "90";
        Random random = new Random();
        return types[random.nextInt(0, 10)];
    }
}
