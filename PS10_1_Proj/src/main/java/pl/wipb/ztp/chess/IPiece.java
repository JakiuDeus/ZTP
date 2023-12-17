package pl.wipb.ztp.chess;

import java.awt.*;

public interface IPiece {
    int TILESIZE = 32;
    void draw(Graphics2D g2d, int x, int y);
    IPiece getDecorated();
}
