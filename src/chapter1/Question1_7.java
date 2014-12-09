package chapter1;

import java.util.Random;

//If an element in an MxN matrix is 0, set its row and column to 0
public class Question1_7 {

	public static void main(String[] args) {
		int n = 5;// matrix size
		int min = 0;// min random number
		int max = 9;// max random number
		int[][] matrix = randomMatrix(n, min, max);
		System.out.println("Original");
		printMatrix(matrix, n);
		System.out.println();
		setZeroes(matrix);
		System.out.println("Zeroed");
		printMatrix(matrix, n);
	}

	// Naive approach would be to create another MxN matrix
	// then copy matrix over, setting 0's
	public static void setZeroes(int[][] matrix) {
		// keep boolean indicating of row/column contains a 0
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];

		// check if row/column has a 0
		for (int r = 0; r < row.length; r++) {
			for (int c = 0; c < col.length; c++) {
				if (matrix[r][c] == 0) {
					row[r] = true;
					col[c] = true;
				}
			}
		}

		// set rest of matrix to 0's
		for (int r = 0; r < row.length; r++) {
			for (int c = 0; c < col.length; c++) {
				if (row[r] || col[c]) {
					matrix[r][c] = 0;
				}
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
