package pl.wipb.ztp.iter;

import java.util.Iterator;

// ten wątek nie wykorzystuje iteratora
class Watek implements Runnable {

	private Kafelki kafelki;
	private Iterator<Tile> iterator;
	private int x, y;

	// x, y to początkowa pozycja do iteracji
	public Watek(Kafelki kafelki, int x, int y) {
		this.kafelki = kafelki;
		this.x = x;
		this.y = y;
		iterator = kafelki.random2DIterator(x, y);
	}

	public void run() {
		// klasyczna podwójna pętla do iteracji
		// tutaj kontrolujemy kolejność odwiedzin
		// zostanie to zastąpione pętlą z użyciem iteratora
		while (iterator.hasNext()) {
			iterator.next().flip();
			kafelki.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}