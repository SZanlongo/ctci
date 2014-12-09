package commonLibrary;

public class LinkedListNode {
	public LinkedListNode prev;// previous node
	public LinkedListNode next; // next node
	public LinkedListNode last;// last node
	public int data;

	public LinkedListNode() {
	}

	public LinkedListNode(LinkedListNode p, LinkedListNode n, int d) {
		this.prev = p;
		this.next = n;
		this.data = d;
	}

	// in C/C++, would have to deallocate memory for deleted nodes

	public void setPrev(LinkedListNode p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}

	public void setNext(LinkedListNode n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrev(this);
		}
	}

	public LinkedListNode clone() {
		LinkedListNode nextNode = null;
		if (next != null) {
			nextNode = next.clone();
		}
		LinkedListNode cloneNode = new LinkedListNode(null, nextNode, data);
		return cloneNode;
	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
}
