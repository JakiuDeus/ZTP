package pl.wipb.ztp.chess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Chessboard board = new Chessboard();

        JToolBar bar = new JToolBar();
        board.setUndo(new JButton(new ImageIcon(getImage("undo.png"))));
        board.setRedo(new JButton(new ImageIcon(getImage("redo.png"))));

        bar.add(board.getUndo());
        bar.add(board.getRedo());

        frame.add(bar, BorderLayout.PAGE_START);
        frame.add(board);

        frame.pack();
        frame.setVisible(true);
    }

    public static Image getImage(String path) throws IOException {
        InputStream fileName = Chessboard.class.getResourceAsStream("/img/" + path);
        return ImageIO.read(fileName);
    }
}
