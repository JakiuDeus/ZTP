package pl.wipb.ztp.chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import static pl.wipb.ztp.chess.IPiece.TILESIZE;

public class Chessboard extends JPanel {
	public static final int ZEROX = 23;
	public static final int ZEROY = 7;
	private Image image;
	private IPiece dragged = null;
	private AffineTransform draggedTransform = null;
	private Point mouse = null;
	private JButton undo, redo;
	private HashMap<Point, IPiece> board = new HashMap<>();

	public void drop(IPiece p, int x, int y) {
		repaint();
		p.moveTo(x, y);
		board.put(new Point(x, y), p);
	}

	public IPiece take(int x, int y) {
		repaint();
		return board.remove(new Point(x, y));
	}



	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		Graphics2D g2d = (Graphics2D) g;
		for (Map.Entry<Point, IPiece> e : board.entrySet()) {
			IPiece pc = e.getValue();
			pc.draw(g2d);
		}
		if (mouse != null && dragged != null) {
			dragged.draw(g2d);
		}
	}

	Chessboard() throws IOException {
		AffineTransform transform = new AffineTransform();
		transform.translate(ZEROX, ZEROY);
		transform.scale(TILESIZE, TILESIZE);
		board.put(new Point(0, 2), new AffineDecorator(new Piece(11, 0, 2), transform));
		board.put(new Point(0, 6), new AffineDecorator(new Piece(0, 0, 6), transform));
		board.put(new Point(1, 4), new AffineDecorator(new Piece(6, 1, 4), transform));
		board.put(new Point(1, 5), new AffineDecorator(new Piece(5, 1, 5), transform));
		board.put(new Point(3, 7), new AffineDecorator(new Piece(1, 3, 7), transform));
		board.put(new Point(4, 3), new AffineDecorator(new Piece(6, 4, 3), transform));
		board.put(new Point(4, 4), new AffineDecorator(new Piece(7, 4, 4), transform));
		board.put(new Point(5, 4), new AffineDecorator(new Piece(6, 5, 4), transform));
		board.put(new Point(5, 6), new AffineDecorator(new Piece(0, 5, 6), transform));
		board.put(new Point(6, 5), new AffineDecorator(new Piece(0, 6, 5), transform));
		board.put(new Point(7, 4), new AffineDecorator(new Piece(0, 7, 4), transform));
		image = Main.getImage("board3.png");
		setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dragged = take((e.getX() - ZEROX) /TILESIZE, (e.getY() - ZEROY) / TILESIZE);
				if (dragged == null) {
					return;
				}
				draggedTransform = new AffineTransform();
				dragged = new AffineDecorator(dragged, draggedTransform);
				mouse = e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (dragged == null) {
					return;
				}
				int x = (e.getX() - ZEROX) / TILESIZE;
				int y = (e.getY() - ZEROY) / TILESIZE;
				drop(dragged.getDecorated(), x, y);
				dragged = null;
				undo.setEnabled(true);
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (draggedTransform == null) {
					return;
				}
				draggedTransform.setToTranslation((double)e.getX() - mouse.getX(), (double)e.getY() - mouse.getY());
				repaint();
			}
		});
	}

	public void setUndo(JButton undoButton) {
		undo = undoButton;
		undo.addActionListener(new UndoButton());
		undo.setEnabled(false);
	}

	public void setRedo(JButton redoButton) {
		redo = redoButton;
		redo.addActionListener(new RedoButton());
		redo.setEnabled(false);
	}

	public JButton getUndo() {
		return undo;
	}

	public JButton getRedo() {
		return redo;
	}

	class UndoButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("UNDO");
			redo.setEnabled(true);
		}
	}

	class RedoButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("REDO");
		}
	}
}