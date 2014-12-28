package chapter2_LinkedLists;

import commonLibrary.CommonMethods;
import commonLibrary.LinkedListNode;

//Add two numbers represented as a single linked-list
public class Question2_5 {

	public static void main(String[] args) {
		LinkedListNode a = CommonMethods.randomLinkedList(3, 0, 9);
		System.out.println(LLToInt(a) + "\t" + a.printForward());
		LinkedListNode b = CommonMethods.randomLinkedList(3, 0, 9);
		System.out.println(LLToInt(b) + "\t" + b.printForward());

		LinkedListNode BWsum = addListsBW(a, b);
		System.out.println(LLToInt(BWsum) + "\t" + BWsum.printForward());
	}

	public static LinkedListNode addListsBW(LinkedListNode a, LinkedListNode b) {
		return addListsBW(a, b, 0);
	}

	// lists stored in "backwards" order
	public static LinkedListNode addListsBW(LinkedListNode a, LinkedListNode b, int carry) {
		if (a == null && b == null && carry == 0) {
			return null;
		}

		int flag = carry; // carry flag

		if (a != null) {
			flag += a.data;
		}
		if (b != null) {
			flag += b.data;
		}

		LinkedListNode sum = new LinkedListNode(null, null, flag % 10);
		flag = (flag >= 10 ? 1 : 0);

		// recursive step
		if (a != null || b != null) {
			LinkedListNode remaining = addListsBW(a == null ? null : a.next, b == null ? null : b.next, flag);
			sum.setNext(remaining);
		}

		return sum;
	}

	public static int LLToInt(LinkedListNode n) {
		int val = 0;
		if (n.next != null) {
			val = 10 * LLToInt(n.next);
		}
		return val + n.data;
	}

}
