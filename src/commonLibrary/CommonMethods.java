package commonLibrary;

import java.util.Random;

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
