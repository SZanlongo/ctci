package chapter2_LinkedLists;

import commonLibrary.CommonMethods;
import commonLibrary.LinkedListNode;

//return node at beginning of circular linked-list
public class Question2_6 {

	public static void main(String[] args) {
		LinkedListNode head = CommonMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		head.next.next.next.next.next.next.next.next.next = head.next.next.next.next;
		LinkedListNode start = findStart(head);
		System.out.println(start.data);
	}

	public static LinkedListNode findStart(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		// detect if linked-list has a loop and where there is a collision
		while (fast != null && fast.next != null) {
			slow = slow.next;// advances by 1
			fast = fast.next.next;// advances by 2
			if (slow == fast) {
				// collision
				break;
			}
		}

		// never meet, so there must not be a loop
		if (fast == null || fast.next == null) {
			return null;
		}

		// return slow to head and fast at collision
		// both are k nodes away from start
		// moving at same speed, they will reach start
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		// now at start
		return slow;
	}

}
