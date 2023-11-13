package pl.wipb.ztp.chess;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

class Piece implements IPiece {
	private static Image image;
	private int index, x, y;

	static {
		try {
			image = Main.getImage("pieces4.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Piece(int index, int x, int y) {
		this.index = index;
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(image, x, y,
				x + 1, y + 1,
				index * TILESIZE, 0,
				(index + 1) * TILESIZE, TILESIZE,
				null);
	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public IPiece getDecorated() {
		return null;
	}
}