
//GFG -> Is Linked List Length Even

public class Is_LinkedList_Length_Even {

    // Node class representing each element in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to check if the linked list length is even
    public static boolean isLengthEven(Node head) {
        if (head == null)
            return true; // Empty list case (even length)

        Node fast = head;

        // Move 'fast' pointer two steps at a time
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
        }

        // If fast ends on null, list has even length
        return fast == null;
    }

    // Helper method to create a linked list from an array
    public static Node createLinkedList(int[] values) {
        if (values.length == 0)
            return null;

        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] values1 = { 1, 2, 3, 4 }; // Even length list
        int[] values2 = { 1, 2, 3 }; // Odd length list

        Node head1 = createLinkedList(values1);
        Node head2 = createLinkedList(values2);

        System.out.println("Is length of list 1 even? " + isLengthEven(head1));
        System.out.println("Is length of list 2 even? " + isLengthEven(head2));
    }
}

// ! Time Complexity: O(N)
// ! Space Complexity: O(1)