package me.jorlowski;

class Baza {
    private char[] tab = new char[100];

    private Baza() {

    }
    
    public static IPolaczenie getPolaczenie() {
        return Polaczenie.getInstance();
    }

    private static class Polaczenie implements IPolaczenie {
        private Baza baza;
        private static IPolaczenie[] polaczenie;
        private static int counter;

        static {
            polaczenie = new IPolaczenie[3];
            Baza baza = new Baza();
            polaczenie[0] = new Polaczenie(baza);
            polaczenie[1] = new Polaczenie(baza);
            polaczenie[2] = new Polaczenie(baza);
            counter = 0;
        }

        private Polaczenie(Baza baza) {
            this.baza = baza;
        }

        public static IPolaczenie getInstance() {
            counter = (counter >= 3) ? 0 : counter; 
            return polaczenie[counter++];
        }

        @Override
        public char get(int indeks) {
            return baza.tab[indeks];
        }

        @Override
        public void set(int indeks, char c) {
            baza.tab[indeks] = c;
        }

        @Override
        public int length() {
           return baza.tab.length;
        }
    }

    
}