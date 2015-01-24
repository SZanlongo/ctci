package chapter9_Recursion_DP;

//Paint fill
//Given 2D array of colors, fill surrounding area until color changes
//this means we need a Color (use an enum ?)
public class Question9_7 {
	public static enum Color {
		RED("r"), GREEN("g"), BLUE("b");
		private String value;

		private Color(String value) {
			this.value = value;
		}

		public static Color getRandom() {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	public static void main(String[] args) {
		Color[][] canvas = createCanvas(5, 5);
		printCanvas(canvas);
		paintFill(canvas, 2, 2, Color.BLUE);
		System.out.println();
		printCanvas(canvas);
	}

	public static Color[][] createCanvas(int x, int y) {
		Color[][] canvas = new Color[x][y];
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				canvas[i][j] = Color.getRandom();
			}
		}
		return canvas;
	}

	public static void printCanvas(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print((screen[i][j]).value);
			}
			System.out.println();
		}
	}

	public static void paintFill(Color[][] canvas, int x, int y, Color newColor) {
		if (canvas[x][y] == newColor) {
			return;
		}
		paintFill(canvas, x, y, canvas[x][y], newColor);
	}

	public static void paintFill(Color[][] canvas, int x, int y, Color oldColor, Color newColor) {
		if (x < 0 || x >= canvas.length || y < 0 || y >= canvas[0].length) {
			return;
		}
		if (canvas[x][y] == oldColor) {
			canvas[x][y] = newColor;
			paintFill(canvas, x - 1, y, oldColor, newColor); // left
			paintFill(canvas, x + 1, y, oldColor, newColor); // right
			paintFill(canvas, x, y - 1, oldColor, newColor); // top
			paintFill(canvas, x, y + 1, oldColor, newColor); // bottom
		}
	}
}
