
// GFG -> Split LinkedList Alternatingley ->

class Node {
    int data;
    Node next;

    // Constructor
    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    // Function to split a linked list into two alternating lists.
    Node[] alternatingSplitList(Node head) {
        // Creating dummy nodes for both lists.
        Node first = new Node(-1); // For the odd-positioned elements.
        Node second = new Node(-1); // For the even-positioned elements.

        // Pointers to traverse and build the new lists.
        Node t1 = first, t2 = second;

        // Traverse the original list.
        while (head != null) {
            // Add the current node to the first list (odd position).
            t1.next = new Node(head.data);
            t1 = t1.next;

            // Move to the next node.
            head = head.next;

            // If there's another node, add it to the second list (even position).
            if (head != null) {
                t2.next = new Node(head.data);
                t2 = t2.next;

                // Move to the next node again.
                head = head.next;
            }
        }

        // Return the heads of the two new lists (without the dummy nodes).
        return new Node[] { first.next, second.next };
    }
}

public class SplitLinkedListAlternatingley {
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    // Main method to run and test the solution.
    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.println("Original List:");
        printList(head);

        // Create a solution object.
        Solution solution = new Solution();

        // Split the list alternatingly.
        Node[] result = solution.alternatingSplitList(head);

        System.out.println("First List (Odd positions):");
        printList(result[0]);

        System.out.println("Second List (Even positions):");
        printList(result[1]);

        // Out[put will be ->
        /*
         * Original List:
         * 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
         * First List (Odd positions):
         * 1 -> 3 -> 5 -> null
         * Second List (Even positions):
         * 2 -> 4 -> 6 -> null
         * 
         */
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)