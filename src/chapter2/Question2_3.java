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
		deleteNode(head.next.next); // delete node
		System.out.println(delNode.printForward());
	}

	public static boolean deleteNode(LinkedListNode n) {
		// check if last node in list
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		LinkedListNode next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}

}
