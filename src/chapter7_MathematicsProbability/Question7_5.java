package chapter7_MathematicsProbability;

//Given two 2D squares, find a line that would cut these squares in half
//Assume the top/bottom run parallel to x-axis
public class Question7_5 {

	public static void main(String[] args) {
		Square s1 = new Square(10, 10, 5);
		Square s2 = new Square(37, 48, 12);

	}

	// returns line that intersects the center of both squares
	public Line centerSquares(Square s1, Square s2) {
		Point s1c = s1.center();
		Point s2c = s2.center();

		return new Line(s1c, s2c);
	}

}

class Point {
	public double x, y;// coordinates

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean isEqual(Point p2) {
		return this.x == p2.x && this.y == p2.y;
	}
}

class Line {
	public Point p1, p2;// endpoints

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

}

class Square {
	Point p;// top left corner
	double radius;// distance from center to edge

	public Square(double x, double y, double r) {
		p = new Point(x, y);
		this.radius = r;
	}

	public Point center() {
		return new Point(p.x + radius / 2, p.y + radius / 2);
	}
}
