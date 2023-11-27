package pl.wipb.ztp.flies.template;

import java.awt.*;

public class NormalnaMucha extends Mucha {
    @Override
    protected void calculateMove() {
        x += vx;
        y += vy;
        if(x<0) { x = -x; vx = -vx; }
        if(x>1) { x = 2-x;vx = -vx; }
        if(y<0) { y = -y; vy = -vy; }
        if(y>1) { y = 2-y;vy = -vy; }
    }

    @Override
    protected Color getColor() {
        return Color.GREEN;
    }
}
