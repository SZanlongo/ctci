package chapter3_StacksQueues;

import java.util.EmptyStackException;

//use a single array to implement three stacks
public class Question3_1 {
	static int size = 100;
	static int[] storage = new int[size * 3];

	// pointers to top of each stack
	static int[] ptr = { -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		push(0, 0);
		push(1, 0);
		push(2, 0);
		System.out.println(printStacks());
		// pop(0); // exception
		System.out.println(printStacks());
		push(0, 1);
		push(1, 1);
		push(2, 1);
		System.out.println(printStacks());
		pop(0);
		pop(1);
		System.out.println(printStacks());
		push(2, 2);
		System.out.println(printStacks());
		pop(2);
		System.out.println(printStacks());
	}

	public static void push(int stack, int data) throws Exception {
		if (ptr[stack] + 1 >= size) {
			// stack has no space left
			throw new Exception("Out of space");
		}

		// update ptr and elem
		ptr[stack]++;
		storage[storagePos(stack)] = data;
	}

	// get index of stack inside storage
	public static int storagePos(int stack) {
		return stack * size + ptr[stack];
	}

	public static int pop(int stack) {
		if (isEmpty(stack)) {
			throw new EmptyStackException();
		}

		int value = storage[storagePos(stack)]; // get top
		storage[storagePos(stack)] = 0; // reset index
		ptr[stack]--;

		return value;
	}

	public static boolean isEmpty(int stackNum) {
		return ptr[stackNum] == -1;
	}

	public static int peek(int stack) {
		if (isEmpty(stack)) {
			throw new EmptyStackException();
		}
		return storage[storagePos(stack)];
	}

	public static String printStacks() {
		String out = "Stack\tTop\n";
		for (int i = 0; i < 3; i++) {
			out += i + "\t" + peek(i) + "\n";
		}
		return out;
	}

}
