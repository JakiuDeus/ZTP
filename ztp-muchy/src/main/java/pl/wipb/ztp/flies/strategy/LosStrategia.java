package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public class LosStrategia implements Strategia {
    @Override
    public void move(Mucha mucha) {
        mucha.angle = mucha.angle + (Math.random()-0.5) / 40;
        mucha.angle = mucha.angle % (2*Math.PI);
        double dx = Math.cos(mucha.angle % (Math.PI/2)) * mucha.r;
        double dy = Math.sin(mucha.angle % (Math.PI/2)) * mucha.r;
        if (mucha.angle >= 0.0 && mucha.angle < Math.PI/2) {

        } else if (mucha.angle >= Math.PI/2 && mucha.angle < Math.PI) {
            dx = -dx;
        } else if (mucha.angle >= Math.PI && mucha.angle < Math.PI/2*3) {
            dx = -dx;
            dy = -dy;
        } else {
            dy = -dy;
        }
        mucha.x += dx;
        mucha.y += dy;
        if(mucha.x<0) { mucha.x = -mucha.x; mucha.angle = Math.abs(Math.PI-mucha.angle); }
        if(mucha.x>1) { mucha.x = 2-mucha.x;mucha.angle = Math.abs(Math.PI-mucha.angle); }
        if(mucha.y<0) { mucha.y = -mucha.y; mucha.angle = Math.abs(Math.PI-mucha.angle); }
        if(mucha.y>1) { mucha.y = 2-mucha.y;mucha.angle = Math.abs(Math.PI*2-mucha.angle); }

    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
