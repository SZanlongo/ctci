package chapter3_StacksQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//implement a MyQueue class using two stacks
public class Question3_5 {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<Integer>();

		// reference queue
		Queue<Integer> refQueue = new LinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			if (Math.random() < 0.5) {
				// add to both queues
				myQueue.add(i);
				refQueue.add(i);
				System.out.println("Adding\t" + i);
			} else {
				// remove from queues
				if (myQueue.size() > 0) {
					System.out.println("Removing from myQueue\t" + myQueue.remove());
					System.out.println("Removing from refQueue\t" + refQueue.remove());
				}
			}
		}
	}

}

class MyQueue<T> {
	Stack<T> s1, s2;

	public MyQueue() {
		s1 = new Stack<T>();// new elems added by default
		s2 = new Stack<T>();// used to pop, peek
	}

	// always add new elemts to s1
	public void add(T item) {
		s1.push(item);
	}

	// move elems to s2, now in reverse order
	// pop
	public T remove() {
		moveStackItems();
		return s2.pop();
	}

	// move items to s2, reversing order
	public void moveStackItems() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
	}

	// same as pop
	public T peek() {
		moveStackItems();
		return s2.peek();
	}

	public int size() {
		return s1.size() + s2.size();
	}
}