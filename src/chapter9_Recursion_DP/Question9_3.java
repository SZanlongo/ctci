package chapter9_Recursion_DP;

//Given a sorted array of distinct numbers, find magic index
//Magic index is defined as Array[i] = i
public class Question9_3 {

	public static void main(String[] args) {
		// example array
		int[] arr = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		System.out.println("Linear search\t\t" + magicIndexLinear(arr));
		System.out.println("Fast binary search\t" + magicIndexBinary(arr));
	}

	// linear scan across array
	public static int magicIndexLinear(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				return i;
			}
		}
		return -1;
	}

	public static int magicIndexBinary(int[] arr) {
		return magicIndexBinary(arr, 0, arr.length - 1);
	}

	public static int magicIndexBinary(int[] arr, int start, int end) {
		if (start < 0 || end < start || end >= arr.length) {
			return -1;
		}

		// check against middle for A[i] = i
		int middle = (start + end) / 2;
		if (arr[middle] == middle) {
			return middle;
		}

		// otherwise, check left subarray
		int result = magicIndexBinary(arr, start, middle - 1);
		if (result >= 0) {
			return result;
		}

		// check right subarray
		result = magicIndexBinary(arr, middle + 1, end);
		return result;
	}
}
