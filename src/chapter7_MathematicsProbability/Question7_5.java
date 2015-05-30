package chapter7_MathematicsProbability;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

//Given two 2D squares, find a line that would cut these squares in half
//Assume the top/bottom run parallel to x-axis
public class Question7_5 {

	public static void main(String[] args) {
		Square s1 = new Square(50, 50, 50);
		Square s2 = new Square(250, 100, 100);
		Line l = centerSquares(s1, s2);
		draw(s1, s2, l);
	}

	// returns line that intersects the center of both squares
	public static Line centerSquares(Square s1, Square s2) {
		System.out.println(s1.center().toString());
		System.out.println(s2.center().toString());
		return new Line(s1.center(), s2.center());
	}

	@SuppressWarnings("serial")
	public static void draw(Square s1, Square s2, Line l) {
		JFrame frame = new JFrame("Divide Squares");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D ga = (Graphics2D) g;

				// Draw the red square
				ga.setColor(Color.RED);
				ga.draw(new Rectangle2D.Double(s1.p.x, s1.p.y, s1.radius * 2, s1.radius * 2));

				// Draw the blue square
				ga.setColor(Color.BLUE);
				ga.draw(new Rectangle2D.Double(s2.p.x, s2.p.y, s2.radius * 2, s2.radius * 2));

				ga.drawLine(l.p1.x, l.p1.y, l.p2.x, l.p2.y);
			}
		}, BorderLayout.CENTER);

		frame.pack();
		frame.setSize(new Dimension(500, 500));
		frame.setVisible(true);
	}

}

class Point {
	public int x, y;// coordinates

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isEqual(Point p2) {
		return this.x == p2.x && this.y == p2.y;
	}

	@Override
	public String toString() {
		return x + "\t" + y;
	}
}

class Line {
	public Point p1, p2;// endpoints

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public String toString() {
		return (p1 + "\t" + p2);
	}

}

class Square {
	public Point p;// top left corner
	public int radius;// distance from center to edge

	public Square(int x, int y, int r) {
		p = new Point(x, y);
		this.radius = r;
	}

	public Point center() {
		return new Point(p.x + radius, p.y + radius);
	}
}
