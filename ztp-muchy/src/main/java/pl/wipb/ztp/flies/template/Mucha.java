package pl.wipb.ztp.flies.template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Mucha {
	
	private final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy
	double r;
	int t, dt;
	double angle;

	public Mucha() {
		angle = Math.random() * 2 * Math.PI;
		r = Math.random() / 100;
		dt = (int)(Math.random()*100) + 20;
		t = (int)(Math.random()*dt);
		x = Math.random()/1.1;
		y = Math.random()/1.1;
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	
	public void move() {
		calculateMove();
	}

	protected abstract void calculateMove();
	protected abstract Color getColor();
}