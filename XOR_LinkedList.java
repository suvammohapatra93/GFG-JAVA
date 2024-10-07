
//GFG->XOR LINKEDLIST

import java.util.*;

// Node class to represent each node in the XOR Linked List
class Node {
    int data;
    Node npx; // XOR of next and previous node

    Node(int x) {
        data = x;
        npx = null;
    }
}

public class XOR_LinkedList {
    // XOR function to calculate XOR of two Node addresses
    static Node xor(Node a, Node b) {
        return (a == null ? b : b == null ? a : new Node((a.hashCode() ^ b.hashCode())));
    }

    // Function to insert data at the front of the list
    static Node insert(Node head, int data) {
        Node new_node = new Node(data); // Create a new node

        // If head is null, make new_node as head
        if (head == null) {
            return new_node;
        }

        // XOR of new_node's npx will be the current head
        new_node.npx = xor(head, null);

        // Modify the head's npx to point to the new_node
        head.npx = xor(new_node, xor(head.npx, null));

        return new_node; // New node becomes the new head
    }

    // Function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = head; // Start from head
        Node prev = null;
        Node next;

        // Traverse the linked list until the end
        while (curr != null) {
            list.add(curr.data); // Add data to the list

            // Next node is XOR of current node's npx and previous node
            next = xor(prev, curr.npx);

            // Move to the next node
            prev = curr;
            curr = next;
        }

        return list; // Return the list of values
    }

    public static void main(String[] args) {
        Node head = null; // Initialize an empty XOR Linked List

        // Insert elements into the XOR Linked List
        head = insert(head, 10);
        head = insert(head, 20);
        head = insert(head, 30);
        head = insert(head, 40);

        // Print the list
        ArrayList<Integer> result = getList(head);
        System.out.println("Elements in the XOR Linked List: " + result);
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)