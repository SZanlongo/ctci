package chapter3_StacksQueues;

import java.util.ArrayList;

//start a stack if previous stack exceeds a threshold
public class Question3_3 {

	public static final int MAX_SIZE = 5; // max size of each stack
	public static final int TEST_SIZE = 20;

	public static void main(String[] args) {
		SetOfStacks set = new SetOfStacks(MAX_SIZE);

		for (int i = 0; i < TEST_SIZE; i++) {
			set.push(i);
		}

		for (int i = 0; i < TEST_SIZE; i++) {
			System.out.println("Pop\t" + set.pop());
		}
	}

}

// set of stacks
class SetOfStacks {
	ArrayList<SizeStack> stackSet = new ArrayList<SizeStack>();
	public int size;

	public SetOfStacks(int capacity) {
		this.size = capacity;
	}

	public void push(int data) {
		SizeStack last = getLast();
		if (last != null && !last.isFull()) { // add to last stack
			last.push(data);
		} else { // full, create new stack
			SizeStack stack = new SizeStack(size);
			stack.push(data);
			stackSet.add(stack);
		}
	}

	// operate on last stack
	public int pop() {
		SizeStack last = getLast();
		int data = last.pop();
		if (last.currSize == 0) { // get prev
			stackSet.remove(stackSet.size() - 1);
		}
		return data;
	}

	public SizeStack getLast() {
		if (stackSet.size() == 0) {
			return null;
		}
		return stackSet.get(stackSet.size() - 1);
	}

	public boolean isEmpty() {
		SizeStack last = getLast();
		return (last == null || last.isEmpty());
	}
}

// custom stack with a set size
class SizeStack {
	public StackElem top;
	public StackElem bottom;
	private int maxSize; // max stack size
	public int currSize = 0; // current stack size

	public SizeStack(int capacity) {
		this.maxSize = capacity;
	}

	public boolean push(int data) {
		if (currSize >= maxSize) {
			return false;
		}

		currSize++;
		StackElem elem = new StackElem(data);

		if (currSize == 1) {
			bottom = elem;
		}

		link(elem, top);
		top = elem;

		return true;
	}

	public int pop() {
		StackElem elem = top;
		top = top.below;
		currSize--;

		return elem.value;
	}

	public boolean isEmpty() {
		return currSize == 0;
	}

	public boolean isFull() {
		return maxSize == currSize;
	}

	public void link(StackElem above, StackElem below) {
		if (below != null) {
			below.above = above;
		}
		if (above != null) {
			above.below = below;
		}
	}

	public int removeBottom() {
		StackElem b = bottom;
		bottom = bottom.above;

		if (bottom != null) {
			bottom.below = null;
		}

		currSize--;

		return b.value;
	}
}

// custom elem for stack
class StackElem {
	public StackElem above;
	public StackElem below;
	public int value;

	public StackElem(int value) {
		this.value = value;
	}
}