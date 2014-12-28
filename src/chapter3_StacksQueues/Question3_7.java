package chapter3_StacksQueues;

import java.util.LinkedList;

//FIFO shelter
//adopt either: oldest animal
//or choice: oldest cat/dog
public class Question3_7 {
	public static LinkedList<Integer> dog = new LinkedList<Integer>();
	public static LinkedList<Integer> cat = new LinkedList<Integer>();

	public static void main(String[] args) throws Exception {
		// populate lists
		for (int i = 0; i < 10; i++) {// i is a timestamp
			if (Math.random() < 0.5) {
				dog.addLast(i);
			} else {
				cat.addLast(i);
			}
		}

		for (int i = 0; i < 10; i++) {// i is a timestamp
			System.out.println("Dogs\t" + dog.toString());
			System.out.println("Cats\t" + cat.toString());

			int choice = (int) (Math.random() * 3);
			if (choice == 0) {// pick any
				System.out.println("any\t" + getAny());
			} else if (choice == 1 && dog.size() > 0) {// pick dog
				System.out.println("dog\t" + getDog());
			} else if (cat.size() > 0) {// pick cat
				System.out.println("cat\t" + getCat());
			}
			System.out.println();
		}
	}

	public static int getAny() {
		if (dog.size() == 0) {
			return cat.poll();
		} else if (cat.size() == 0) {
			return dog.poll();
		}

		if (dog.peek() > cat.peek()) {
			return dog.poll();
		} else {
			return cat.poll();
		}
	}

	public static int getDog() throws Exception {
		if (dog.size() > 0) {
			return dog.poll();
		}
		throw new Exception("No dogs. Maybe get a cat instead?");
	}

	public static int getCat() throws Exception {
		if (cat.size() > 0) {
			return cat.poll();
		}
		throw new Exception("No cats. Maybe get a dog instead?");
	}

}
