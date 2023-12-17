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
import java.util.LinkedList;
import java.util.List;
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
	private int draggedX, draggedY;
	private List<ICommand> undoList = new LinkedList<>();
	private List<ICommand> redoList = new LinkedList<>();
	public void drop(IPiece p, int x, int y) {
		repaint();
		board.put(new Point(x, y), p);
	}

	public IPiece take(int x, int y) {
		repaint();
		draggedX = x;
		draggedY = y;
		return board.remove(new Point(x, y));
	}



	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
		Graphics2D g2d = (Graphics2D) g;
		for (Map.Entry<Point, IPiece> e : board.entrySet()) {
			Point pt = e.getKey();
			IPiece pc = e.getValue();
			pc.draw(g2d, pt.x, pt.y);
		}
		if (mouse != null && dragged != null) {
			dragged.draw(g2d, draggedX, draggedY);
		}
	}

	Chessboard() throws IOException {
		AffineTransform transform = new AffineTransform();
		transform.translate(ZEROX, ZEROY);
		transform.scale(TILESIZE, TILESIZE);
		board.put(new Point(0, 2), new AffineDecorator(Piece.getPiece(11), transform));
		board.put(new Point(0, 6), new AffineDecorator(Piece.getPiece(0), transform));
		board.put(new Point(1, 4), new AffineDecorator(Piece.getPiece(6), transform));
		board.put(new Point(1, 5), new AffineDecorator(Piece.getPiece(5), transform));
		board.put(new Point(3, 7), new AffineDecorator(Piece.getPiece(1), transform));
		board.put(new Point(4, 3), new AffineDecorator(Piece.getPiece(6), transform));
		board.put(new Point(4, 4), new AffineDecorator(Piece.getPiece(7), transform));
		board.put(new Point(5, 4), new AffineDecorator(Piece.getPiece(6), transform));
		board.put(new Point(5, 6), new AffineDecorator(Piece.getPiece(0), transform));
		board.put(new Point(6, 5), new AffineDecorator(Piece.getPiece(0), transform));
		board.put(new Point(7, 4), new AffineDecorator(Piece.getPiece(0), transform));
		image = Main.getImage("board3.png");
		setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				draggedX = (e.getX() - ZEROX) / TILESIZE;
				draggedY = (e.getY() - ZEROY) / TILESIZE;
				if (!board.containsKey(new Point(draggedX, draggedY))) {
					return;
				}
				dragged = take(draggedX, draggedY);
				draggedTransform = new AffineTransform();
				dragged = new AffineDecorator(dragged, draggedTransform);
				mouse = e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (dragged == null) {
					return;
				}
				Point square = new Point((e.getX() - ZEROX) / TILESIZE, (e.getY() - ZEROY) / TILESIZE);
				RemoveCommand removeCommand = null;
				if (board.containsKey(square)) {
					removeCommand = new RemoveCommand(square, board.get(square));
				}
				IPiece piece = dragged.getDecorated();
				drop(piece, square.x, square.y);
				MoveCommand moveCommand = new MoveCommand(new Point(draggedX, draggedY), square);
				redoList.clear();
				redo.setEnabled(false);
				if (removeCommand == null) {
					undoList.addLast(moveCommand);
				} else {
					Macro macro = new Macro();
					macro.addCommand(moveCommand);
					macro.addCommand(removeCommand);
					undoList.addLast(macro);
				}
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
			ICommand command = undoList.removeLast();
			if (undoList.isEmpty()) {
				undo.setEnabled(false);
			}
			command.undo();
			redoList.addLast(command);
			redo.setEnabled(true);
		}
	}

	class RedoButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ICommand command = redoList.removeLast();
			if (redoList.isEmpty()) {
				redo.setEnabled(false);
			}
			command.redo();
			undoList.addLast(command);
			undo.setEnabled(true);
		}
	}

	private class RemoveCommand implements ICommand {
		private Point square;
		private IPiece piece;

		public RemoveCommand(Point square, IPiece piece) {
			this.square = square;
			this.piece = piece;
			System.out.println("NEW REMOVE");
		}

		@Override
		public void undo() {
			drop(piece, square.x, square.y);
		}

		@Override
		public void redo() {
			take(square.x, square.y);
		}
	}

	private class MoveCommand implements ICommand {

		private Point from;
		private Point to;

        public MoveCommand(Point from, Point to) {
			this.from = from;
			this.to = to;
			System.out.println("NEW MOVE");
        }

		@Override
		public void undo() {
			drop(take(to.x, to.y), from.x, from.y);
		}

		@Override
		public void redo() {
			drop(take(from.x, from.y), to.x, to.y);
		}
	}
}