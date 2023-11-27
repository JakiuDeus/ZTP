package pl.wipb.ztp.flies.template;

import java.awt.*;

public class KoloMucha extends Mucha {
    @Override
    protected void calculateMove() {
        t = t % dt;
        t++;
        x = x + r * Math.cos(t*2*Math.PI/dt);
        y = y + r * Math.sin(t*2*Math.PI/dt);
    }

    @Override
    protected Color getColor() {
        return Color.RED;
    }
}
