package chapter1_ArraysStrings;

import commonLibrary.CommonMethods;

//Rotate an NxN matrix 90 degrees
public class Question1_6 {
	// Hint: can be done in-place

	public static void main(String[] args) {
		int n = 4;// matrix size
		int min = 0;// min random number
		int max = 9;// max random number
		int[][] matrix = CommonMethods.randomMatrix(n, min, max);
		System.out.println("Original");
		CommonMethods.printMatrix(matrix, n);
		System.out.println();
		rotate(matrix, n);
		System.out.println("Rotated");
		CommonMethods.printMatrix(matrix, n);
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
}
