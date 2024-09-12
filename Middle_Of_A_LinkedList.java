
/*GFG:MIDDLE OF A LINKEDLIST: */

// Defining a custom Node class for the linked list
class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Middle_Of_A_LinkedList {
    public static int getMiddle(Node head) {
        if (head == null) {
            // List is empty
            return -1; // or some other indication of an empty list
        }

        Node slow = head;
        Node fast = head;

        // Traverse the list with fast and slow pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return the data of the middle node
        return slow.data;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Call the method to get the middle element
        int middle = getMiddle(head);
        System.out.println("The middle element is: " + middle); // Output: 3
    }
}


//! Time Complexity = O(n)
//! Space Complexity = O(1)