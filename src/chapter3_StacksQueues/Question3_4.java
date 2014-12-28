package chapter3_StacksQueues;

import java.util.Stack;

//towers of hanoi
public class Question3_4 {
	public static final int NUMBER_TOWERS = 3;
	public static final int NUMBER_PLATES = 10;

	public static void main(String[] args) throws Exception {
		Tower[] towers = new Tower[NUMBER_TOWERS];

		for (int i = 0; i < NUMBER_TOWERS; i++) {
			towers[i] = new Tower(i);
		}

		for (int i = NUMBER_PLATES - 1; i >= 0; i--) {
			towers[0].add(i);
		}

		towers[0].move(NUMBER_PLATES, towers[1], towers[2]);

		towers[0].print();
		towers[1].print();
		towers[2].print();
	}
}

class Tower {
	private Stack<Integer> plates;
	private int index;

	public Tower(int i) {
		plates = new Stack<Integer>();
		index = i;
	}

	public void add(int newPlate) throws Exception {
		if (!plates.isEmpty() && plates.peek() <= newPlate) {
			throw new Exception("Bad order");
		} else {
			plates.push(newPlate);
		}
	}

	public void move(int from, Tower to, Tower hold) throws Exception {

		if (from > 0) {
			// move top n-1 plates from "from" to "hold"
			// "to" is used like a buffer
			move(from - 1, hold, to);

			// move the top from "from" to "to"
			int top = plates.pop();
			to.add(top);

			// move top n-1 plates from hold to "to"
			// now, "from" is used like a buffer
			hold.move(from - 1, to, this);
		}

		// base case, return
	}

	public void print() {
		System.out.println("Tower\t" + index + "\t" + plates.toString());
	}
}