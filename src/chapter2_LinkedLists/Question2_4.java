package chapter2_LinkedLists;

import commonLibrary.CommonMethods;
import commonLibrary.LinkedListNode;

//Partition a linked-list around a value x
//Nodes <x are before nodes >=x
public class Question2_4 {

	public static void main(String[] args) {
		LinkedListNode head = CommonMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		LinkedListNode partitioned = partition(head, 5);
		System.out.println(partitioned.printForward());
	}

	public static LinkedListNode partition(LinkedListNode n, int x) {
		// don't have to sort, only split; so we can use two lists and then
		// merge
		LinkedListNode less = null; // <x
		LinkedListNode geq = null; // >=x

		// partition list
		while (n != null) {
			LinkedListNode nextNode = n.next;
			if (n.data < x) {
				n.next = less; // add node to start of less
				less = n;
			} else {
				n.next = geq; // add node to start of geq
				geq = n;
			}
			n = nextNode;
		}

		// merge two lists
		if (less == null) {
			return geq;
		}

		// get end of less and merge
		LinkedListNode head = less;
		while (less.next != null) {
			less = less.next;
		}
		less.next = geq;
		
		return head;
	}

}
