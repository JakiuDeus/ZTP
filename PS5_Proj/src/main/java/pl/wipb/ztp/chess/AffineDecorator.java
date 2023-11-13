package pl.wipb.ztp.chess;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class AffineDecorator extends Decorator {

    private final AffineTransform transform;

    public AffineDecorator(IPiece piece, AffineTransform transform) {
        super(piece);
        this.transform = transform;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform temp = g2d.getTransform();
        g2d.transform(transform);
        piece.draw(g2d);
        g2d.setTransform(temp);
    }
}
