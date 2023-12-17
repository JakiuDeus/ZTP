package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

class Piece implements IPiece {
	private static IPiece[] pieces = new IPiece[12];
	private static Image image;
	private int index;

	static {
		try {
			image = Main.getImage("pieces4.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IPiece getPiece(int index) {
		if (pieces[index] == null) {
			pieces[index] = new Piece(index);
		}
		return pieces[index];
	}

	private Piece(int index) {
		this.index = index;
	}

	@Override
	public void draw(Graphics2D g, int x, int y) {
		g.drawImage(image, x, y,
				x + 1, y + 1,
				index * TILESIZE, 0,
				(index + 1) * TILESIZE, TILESIZE,
				null);
	}

	@Override
	public IPiece getDecorated() {
		return null;
	}
}