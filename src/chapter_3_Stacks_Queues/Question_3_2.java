package chapter_3_Stacks_Queues;

import commonLibrary.CommonMethods;

import java.util.Stack;

//design stack that can return min
public class Question_3_2 {
    /*
     * Observation Cannot store a min int works great when pushing popping
     * requires a search, breaks O(1)
     *
     * If interviewer allows can track by extending nodes to include data +
     * current min
     */

    public static void main(String[] args) {
        MinStack s1 = new MinStack();
        MinStack s2 = new MinStack();

        for (int i = 0; i < 10; i++) {
            int value = CommonMethods.randomIntInRange(0, 10);
            s1.push(value);
            s2.push(value);
            System.out.print(value + "\t");
        }

        System.out.println('\n');

        for (int i = 0; i < 10; i++) {
            System.out.println("Pop:\t" + s1.pop().data + "\t" + s2.pop().data);
            System.out.println("Min:\t" + s1.min() + "\t" + s2.min());
        }

    }

}

class MinStack extends Stack<MinNode> {
    public void push(int data) {
        int currMin = Math.min(data, min()); // update current min
        super.push(new MinNode(data, currMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE; // error, large value
        }
        return peek().min;
    }
}

class MinNode {
    public int data;
    public int min;

    public MinNode(int data, int min) {
        this.data = data;
        this.min = min;
    }
}
