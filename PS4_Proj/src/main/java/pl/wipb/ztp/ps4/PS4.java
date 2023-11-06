package pl.wipb.ztp.ps4;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;


public class PS4 {
	
	private static Logger LOGGER = Logger.getLogger(PS4.class.getName());

    public static void main(String[] args) {
    	try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        	LOGGER.log(Level.SEVERE, null, ex);
        }

        final Baza baza = new Baza();

        final JFrame frame = new JFrame("Zadanie 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JSplitPane splitPane = new JSplitPane();

        final JList<Data> list = new JList<>(baza);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Tablice: "));
        splitPane.setLeftComponent(scrollPane);

        TableModel adapter = new TableModel();
        JTable table = new JTable(adapter);
        scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder(" Zawartość: "));
        splitPane.setRightComponent(scrollPane);

        frame.getContentPane().add(splitPane);

        JMenuBar bar = new JMenuBar();
        JButton add = new JButton("Dodaj tablicę");
        JButton del = new JButton("Usuń tablicę");
        JButton copy = new JButton("Skopiuj tablicę");
        bar.add(add);
        bar.add(del);
        bar.add(copy);

        frame.setJMenuBar(bar);

        frame.setSize(600, 450);
        frame.setVisible(true);

        splitPane.setDividerLocation(0.5);

        add.addActionListener(e -> {
            String value = JOptionPane.showInputDialog(frame,
                    "Podaj rozmiar tablicy",
                    "Dodaj",
                    JOptionPane.INFORMATION_MESSAGE);
            if (value == null) {
                return;
            }
            try{
                int size = Integer.parseInt(value);
                baza.add(new ProxyData(size));
            } catch(Exception ex) {
                LOGGER.log(Level.SEVERE, "Wprowadź liczbę całkowitą większą od 0.", ex);
                JOptionPane.showMessageDialog(frame, "Wprowadź liczbę całkowitą większą od 0.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });
        del.addActionListener(e -> {
            int idx = list.getSelectedIndex();
            try{
                baza.remove(idx);
                adapter.changeData(null);
            } catch(Exception ex) {
                LOGGER.log(Level.SEVERE, "Zaznacz tablicę do usunięcia", ex);
                JOptionPane.showMessageDialog(frame, "Zaznacz tablicę do usunięcia", "Błąd", JOptionPane.ERROR_MESSAGE);
            };
        });
        copy.addActionListener(e -> {
            try {
                baza.add(new ProxyCopy(list.getSelectedValue()));
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Zaznacz tablicę do skopiowania", ex);
                JOptionPane.showMessageDialog(frame, "Zaznacz tablicę do skopiowania", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        // zmiana wyboru na liście powoduje odświeżenie tabeli
        list.addListSelectionListener(e -> {
            int idx = list.getSelectedIndex();
            if (idx >= 0) {
                adapter.changeData(list.getSelectedValue());
            }
        });
    }
}
