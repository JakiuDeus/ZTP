package pl.wipb.ztp.flies.strategy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Muchy extends JPanel implements Runnable {

	private Mucha[] ar;
	private Strategia kolo;
	private Strategia los;

	public Muchy() {
		kolo = new KoloStrategia();
		los = new LosStrategia();
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Mucha[30];
		for (int i = 0; i < ar.length; ++i)
			if (i%2 == 0) {
				ar[i] = new Mucha();
			} else {
				ar[i] = new Mucha();
			}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ar.length; ++i) {
			if (i%2 == 0) {
				g.setColor(kolo.getColor());
			} else {
				g.setColor(los.getColor());
			}
			ar[i].draw(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < ar.length; ++i) {
				if (i%2 == 0) {
					kolo.move(ar[i]);
				} else {
					los.move(ar[i]);
				}
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");

		JFrame frame = new JFrame("Muchy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Muchy m = new Muchy();
		frame.getContentPane().add(m);
		frame.pack();
		frame.setVisible(true);
		new Thread(m).start();
	}
}