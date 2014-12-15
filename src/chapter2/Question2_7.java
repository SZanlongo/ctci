package chapter2;

import java.util.Stack;

import commonLibrary.LinkedListNode;

//check if a linked-list is a palindrome
public class Question2_7 {

	public static final int K = 5;

	public static void main(String[] args) {
		// create linked list nodes
		LinkedListNode[] nodes = new LinkedListNode[5];
		for (int i = 0; i < K; i++) {
			int data = 0;
			if (i >= K / 2) {
				data = K - i - 1;
			} else {
				data = i;
			}

			nodes[i] = new LinkedListNode(null, null, data);
		}

		// set next and prev
		for (int i = 0; i < K; i++) {
			if (i < K - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrev(nodes[i - 1]);
			}
		}

		// nodes[K - 2].data = 100; // no longer a palindrome

		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());

		System.out.println("Is palindrome:\t" + isPailindrome(head));
	}

	public static boolean isPailindrome(LinkedListNode head) {
		// use a slow/fast-runner approach to find length and midpoint of list
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();// holds first half of list

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;// advances by 1
			fast = fast.next.next;// advances by 2
		}

		if (fast != null) {
			// list has odd number of elements
			slow = slow.next;
		}

		while (!stack.isEmpty()) {
			if (stack.pop() != slow.data) {
				return false;
			} else {
				slow = slow.next;
			}
		}

		return true;
	}

}
