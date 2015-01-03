package chapter9_Recursion_DP;

//number of ways to count going up stairs
//steps can be done in increments of 1, 2, 3
public class Question9_1 {
	public static final int STAIRS = 5;

	public static void main(String[] args) {
		System.out.println(recursiveWays(STAIRS));
		int[] prev = new int[STAIRS];
		for (int i = 0; i < STAIRS; i++) {
			prev[i] = -1;
		}
		System.out.println(dynamicWays(STAIRS, prev));
	}

	public static int recursiveWays(int stairs) {
		if (stairs < 0) {
			return 0;
		}
		if (stairs == 0) {
			return 1;
		}

		return recursiveWays(stairs - 1) + recursiveWays(stairs - 2) + recursiveWays(stairs - 3);
	}

	public static int dynamicWays(int stairs, int[] prev) {
		if (stairs < 0) {
			return 0;
		}
		if (stairs == 0) {
			return 1;
		}
		if (prev[stairs - 1] > -1) {
			return prev[stairs - 1];
		}
		prev[stairs - 1] = dynamicWays(stairs - 1, prev) + dynamicWays(stairs - 2, prev)
				+ dynamicWays(stairs - 3, prev);
		return prev[stairs - 1];

	}

}
