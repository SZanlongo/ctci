package chapter2_LinkedLists;

import java.util.HashSet;

import commonLibrary.LinkedListNode;

//Remove duplicates from unsorted linked-list
public class Question2_1 {

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(null, null, 0);
		LinkedListNode head = first;
		LinkedListNode second = first;

		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(null, null, i % 2);
			first.setNext(second);
			second.setPrev(first);
			first = second;
		}

		System.out.println(head.printForward());
		LinkedListNode clone = head.clone();
		deleteDups(head);
		System.out.println(head.printForward());
		deleteDupsNoBuff(clone);
		System.out.println(clone.printForward());
	}

	public static void deleteDups(LinkedListNode n) {
		// can use a hash table
		// Time: O(n)
		HashSet<Integer> hasSet = new HashSet<Integer>();
		LinkedListNode prev = null;
		while (n != null) {
			if (hasSet.contains(n.data)) {
				prev.next = n.next;
				if (n.next != null) {
					n.next.prev = prev;
				}
			} else {
				hasSet.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}

	// solve without a buffer
	public static void deleteDupsNoBuff(LinkedListNode head) {
		// this requires 2 pointers
		// one iterates list, other checks remaining nodes for dups
		if (head == null)
			return;

		LinkedListNode current = head;
		while (current != null) {// set curr node
			// compare remaining nodes against curr
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
