package commonLibrary;

public class CommonMethods {
	public static String charToString(char[] arr) {
		// mutable sequence of chars
		StringBuilder builder = new StringBuilder(arr.length);
		for (char c : arr) {
			if (c == 0) {
				break;
			}
			builder.append(c);
		}
		return builder.toString();
	}

	// generate an NxN matrix with random number between min/max
	public static int[][] randomMatrix(int n, int min, int max) {
		int[][] randomMatrix = new int[n][n]; // NxN matrix

		// populate
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				randomMatrix[i][j] = randomIntInRange(min, max);
			}
		}

		return randomMatrix;
	}

	// print an NxN matrix, given N
	public static void printMatrix(int[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	// create a linked-list with random values
	public static LinkedListNode randomLinkedList(int n, int min, int max) {
		LinkedListNode root = new LinkedListNode(null, null, randomIntInRange(min, max));
		LinkedListNode prev = root;
		for (int i = 1; i < n; i++) {
			int data = randomIntInRange(min, max);
			LinkedListNode next = new LinkedListNode(null, null, data);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}

	// return a random int
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	// return a random int between min and max
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
}
