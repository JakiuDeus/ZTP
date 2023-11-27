package pl.wipb.ztp.flies.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class Mucha {
	
	private final double k = 0.01;
	double x, y; // pozycja muchy
	double r;
	int t, dt;
	double angle;


	public Mucha() {
		angle = Math.random() * 2 * Math.PI;
		x = Math.random()/1.1;
		y = Math.random()/1.1;
		r = Math.random() / 100;
		dt = (int)(Math.random()*100) + 20;
		t = (int)(Math.random()*dt);
	}

	public void draw(Graphics g) {
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
}