
// GFG -> Find The Sum Of Last N Nodes Of The Linked List ->

class Node {
    int data;
    Node next;

    // Constructor to create a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Solution class to find the sum of the last N nodes
public class FindTheSumOfLastN_NodesOfTheLinkedList {

    public static int sumOfLastN_Nodes(Node head, int n) {
        // Step 1: Find the length of the linked list
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Calculate the starting position of the last N nodes
        int start = length - n;
        current = head;
        int count = 0;
        int sum = 0;

        // Step 3: Traverse the list and sum up the last N nodes
        while (current != null) {
            if (count >= start) {
                sum += current.data;
            }
            count++;
            current = current.next;
        }

        return sum;
    }

    public static void main(String[] args) {
        // Creating a linked list: 10 -> 20 -> 30 -> 40 -> 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        int n = 3;
        int result = sumOfLastN_Nodes(head, n);

        System.out.println("Sum of last " + n + " nodes is: " + result);
        // Output will be -> Sum of last 3 nodes is: 120
    }
}
