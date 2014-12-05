package ctci;

import java.util.Random;

//Rotate an NxN matrix 90 degrees
public class Question6 {
	// Hint: can be done in-place

	public static void main(String[] args) {
		int n = 4;// matrix size
		int min = 0;// min random number
		int max = 9;// max random number
		int[][] matrix = randomMatrix(n, min, max);
		System.out.println("Original");
		printMatrix(matrix, n);
		System.out.println();
		rotate(matrix, n);
		System.out.println("Rotated");
		printMatrix(matrix, n);
	}

	// Time: O(n^2), best since we are modifying a matrix with n^2 elements
	public static void rotate(int[][] matrix, int n) {
		// peel away layers going in
		for (int i = 0; i < n / 2; ++i) {// n/2 is center
			int start = i;// start of segment
			int end = n - 1 - i;// send of segment
			// each layer is 2 cells smaller
			for (int j = start; j < end; ++j) {
				int offset = j - start;
				// store the top segment
				int top = matrix[start][j];

				// left is now on top
				matrix[start][j] = matrix[end - offset][start];

				// bottom is now on left
				matrix[end - offset][start] = matrix[end][end - offset];

				// right is not on bottom
				matrix[end][end - offset] = matrix[j][end];

				// top is now on right
				matrix[j][end] = top;
			}
		}
	}

	// generate an NxN matrix with random number between min/max
	private static int[][] randomMatrix(int n, int min, int max) {
		int[][] randomMatrix = new int[n][n]; // NxN matrix

		Random rand = new Random();
		// populate
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				randomMatrix[i][j] = Math.abs(rand.nextInt((max - min) + 1) + min);
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
}
