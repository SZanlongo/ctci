package chapter_2_Linked_Lists;

import commonLibrary.LinkedListNode;

public class Question_2_8 {
    public static void main(String[] args) {
        //Linked List
        LinkedListNode first = new LinkedListNode(null, null, 0);
        LinkedListNode head = first;
        LinkedListNode second = first;

        //Build Linked List
        for (int i = 1; i < 5; i++) {
            second = new LinkedListNode(null, null, i);
            first.setNext(second);
            second.setPrev(first);
            first = second;
        }
        System.out.println(head.printForward());

        //Create cycle
        first.setNext(head.next.next);

        System.out.println(findCycle(head).data);
    }

    public static LinkedListNode findCycle(LinkedListNode head) {
        //Use Floyd's Cycle detection
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        //Check if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        //If no cycle, return
        if (fast == null || fast.next == null) {
            return null;
        }


        //reset slow to head
        slow = head;
        //slow and fast pointers are each n jumps from cycle start
        //Advancing at same "speed", they will converge at start of cycle
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        //Now at start of loop
        return slow;


    }
}
