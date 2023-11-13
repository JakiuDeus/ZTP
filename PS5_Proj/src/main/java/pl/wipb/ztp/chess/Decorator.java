package pl.wipb.ztp.chess;

import java.awt.*;

public class Decorator implements IPiece {

    protected IPiece piece;

    protected Decorator(IPiece piece) {
        this.piece = piece;
    }

    @Override
    public void draw(Graphics2D g2d) {
        piece.draw(g2d);
    }
    @Override
    public int getX() {
        return piece.getX();
    }

    @Override
    public int getY() {
        return piece.getY();
    }

    @Override
    public void moveTo(int p0, int p1) {
        piece.moveTo(p0, p1);
    }

    @Override
    public IPiece getDecorated() {
        return piece;
    }
}
