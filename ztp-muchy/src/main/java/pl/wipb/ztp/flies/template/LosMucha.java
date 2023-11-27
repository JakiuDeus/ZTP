package pl.wipb.ztp.flies.template;

import java.awt.*;

public class LosMucha extends Mucha {
    @Override
    protected void calculateMove() {
        angle = angle + (Math.random()-0.5) / 40;
        angle = angle % (2*Math.PI);
        double dx = Math.cos(angle % (Math.PI/2)) * r;
        double dy = Math.sin(angle % (Math.PI/2)) * r;
        if (angle >= 0.0 && angle < Math.PI/2) {

        } else if (angle >= Math.PI/2 && angle < Math.PI) {
            dx = -dx;
        } else if (angle >= Math.PI && angle < Math.PI/2*3) {
            dx = -dx;
            dy = -dy;
        } else {
            dy = -dy;
        }
        x += dx;
        y += dy;
        if(x<0) { x = -x; angle = Math.abs(Math.PI-angle); }
        if(x>1) { x = 2-x;angle = Math.abs(Math.PI-angle); }
        if(y<0) { y = -y; angle = Math.abs(Math.PI-angle); }
        if(y>1) { y = 2-y;angle = Math.abs(Math.PI*2-angle); }
    }

    @Override
    protected Color getColor() {
        return Color.BLUE;
    }
}
