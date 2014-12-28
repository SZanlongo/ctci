package chapter3_StacksQueues;

import java.util.Stack;
import commonLibrary.CommonMethods;

//sort stack with biggest items on top
//can only use 1 extra stack
public class Question3_6 {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < 10; i++) {
			stack.push(CommonMethods.randomIntInRange(1, 100));
		}

		stack = sort(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static Stack<Integer> sort(Stack<Integer> stack) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty()) {
			int top = stack.pop();
			while (!temp.isEmpty() && temp.peek() > top) {
				stack.push(temp.pop());
			}
			temp.push(top);
		}
		return temp;
	}

}
