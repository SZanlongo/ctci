package chapter2;

import commonLibrary.CommonMethods;
import commonLibrary.LinkedListNode;

//find the kth to last element of a singly-linked-list
public class Question2_2 {
	private static final int LIST_SIZE = 10;
	private static final int KTH_ELEMENT = 2;

	public static void main(String[] args) {
		LinkedListNode head = CommonMethods.randomLinkedList(LIST_SIZE, 0, 10);
		System.out.println(head.printForward());

		System.out.println(nthToLastKnownLength(head, KTH_ELEMENT, 10));

		nthToLastRecursivePrint(head, KTH_ELEMENT);

		RecWrap wrap = new RecWrap();
		System.out.println(nthToLastRecursiveWrapper(head, KTH_ELEMENT, wrap).data);

		System.out.println(nthToLastIterative(head, KTH_ELEMENT).data);
	}

	// Linked-list size is known
	public static int nthToLastKnownLength(LinkedListNode head, int k, int len) {
		LinkedListNode curr = head;
		for (int i = 0; i < len - k - 1; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	// Recursive, unknown length
	// Assumes we can print inside the method, ugly implementation
	// Space:O(n)
	public static int nthToLastRecursivePrint(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int loc = nthToLastRecursivePrint(head.next, k) + 1;
		if (loc == k + 1) {
			System.out.println(head.data);
		}
		return loc;
	}

	// Recursive, unknown length
	// Assumes we can use a wrapper class to return two values
	// Space: O(n)
	public static LinkedListNode nthToLastRecursiveWrapper(LinkedListNode head, int k, RecWrap i) {
		if (head == null) {
			return null;
		}
		LinkedListNode node = nthToLastRecursiveWrapper(head.next, k, i);
		i.c = i.c + 1;
		if (i.c == k + 1) {
			return head;
		}
		return node;
	}

	public static class RecWrap {
		public int c = 0;
	}

	// Iterative, unknown length
	// Time: O(n)
	// Space: O(1)
	public static LinkedListNode nthToLastIterative(LinkedListNode head, int k) {
		/*
		 * use two pointers, seperated by k when the first pointer hits the end,
		 * the 2nd pointer is at kth node
		 */
		if (k <= 0 || head == null) {
			return null;
		}

		LinkedListNode first = head;
		LinkedListNode sec = head;

		// move first forward k times
		for (int i = 0; i < k; i++) {
			if (first.next == null) {
				return null;
			}
			first = first.next;
		}

		if (first == null) {
			return null;
		}

		// move both pointers simultaneously until first hits end
		while (first.next != null) {
			first = first.next;
			sec = sec.next;
		}

		return sec;
	}
}
