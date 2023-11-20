package pl.wipb.ztp.chess;

import java.awt.*;

public class Decorator implements IPiece {

    protected IPiece piece;

    protected Decorator(IPiece piece) {
        this.piece = piece;
    }

    @Override
    public void draw(Graphics2D g2d, int x, int y) {
        piece.draw(g2d, x, y);
    }
    @Override
    public IPiece getDecorated() {
        return piece;
    }
}
