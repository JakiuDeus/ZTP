package me.jorlowski;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IPolaczenie> polaczenia = new ArrayList<>();
        for (int i=0; i<4; i++) {
            polaczenia.add(Baza.getPolaczenie());
        }
        System.out.println(polaczenia.get(0) == polaczenia.get(1));
        System.out.println(polaczenia.get(0) == polaczenia.get(2));
        System.out.println(polaczenia.get(0) == polaczenia.get(3));
        System.out.println(polaczenia.get(1) == polaczenia.get(2));
        System.out.println(polaczenia.get(1) == polaczenia.get(3));
        System.out.println(polaczenia.get(2) == polaczenia.get(3));
        polaczenia.get(0).set(0, '@');
        polaczenia.stream().forEach(p -> System.out.println(p.get(0)));
        polaczenia.get(2).set(2, 'a');
        polaczenia.stream().forEach(p -> System.out.println(p.length()));
        polaczenia.stream().forEach(p -> System.out.println(p.get(2)));
    }
}
