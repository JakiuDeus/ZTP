package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public class KoloStrategia implements Strategia {
    @Override
    public void move(Mucha mucha) {
        mucha.t = mucha.t % mucha.dt;
        mucha.t++;
        mucha.x = mucha.x + mucha.r * Math.cos(mucha.t*2*Math.PI/mucha.dt);
        mucha.y = mucha.y + mucha.r * Math.sin(mucha.t*2*Math.PI/mucha.dt);

    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
