package chapter2;

import commonLibrary.CommonMethods;
import commonLibrary.LinkedListNode;

//Delete a node in the middle of a singly-linked list
//given only access to that node
public class Question2_3 {

	public static void main(String[] args) {
		LinkedListNode head = CommonMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		LinkedListNode delNode = head;
		for (int i = 0; i < 4; i++) {// set nth node
			delNode = delNode.next;
		}
		deleteNode(delNode); // delete node
		System.out.println(head.printForward());
	}

	public static boolean deleteNode(LinkedListNode n) {
		// check if last node in list
		if (n == null || n.next == null) {
			return false;
		}
		LinkedListNode nextNode = n.next;
		n.prev = nextNode.prev;
		n.next = nextNode.next;
		n.data = nextNode.data;
		return true;
	}

}
