
//GFG -> Occurance Of An Integer In A LinkedList

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Occcurance_Of_An_Integer_In_A_LinkedList {

    public static int count(Node head, int key) {
        int count = 0;
        Node current = head;

        // Traverse through the linked list
        while (current != null) {
            // If the node's data matches the key, increment count
            if (current.data == key) {
                count++;
            }
            // Move to the next node
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);

        int key = 1;

        int result = count(head, key);

        System.out.println("The integer " + key + " appears " + result + " times in the linked list.");
        // Output -> The integer 1 appears 3 times in the linked list.
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)