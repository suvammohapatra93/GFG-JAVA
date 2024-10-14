
// GFG -> Count Linkedlist Nodes ->

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

public class CountLinkedListNodes {
    public static int getCount(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Count of nodes is: " + getCount(head));
        // Output -> Count of nodes is: 5
    }
}

// ! Time Complexityu = O(n)
// ! Space Complexityu = O(1)