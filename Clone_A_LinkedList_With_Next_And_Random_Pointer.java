
// GFG: CLONE A LINKEDLIST WITH NEXT AND RANDOM POINTER:-

import java.util.HashMap;

class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}

public class Clone_A_LinkedList_With_Next_And_Random_Pointer {
    // Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        // Map to store the mapping between original nodes and their clones
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;

        // First pass: Create a clone of each node and store it in the map
        while (temp != null) {
            map.put(temp, new Node(temp.data));
            temp = temp.next;
        }

        // Second pass: Assign next and random pointers for each cloned node
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        // Return the head of the cloned list
        return map.get(head);
    }

    // Main method to test the cloning function
    public static void main(String[] args) {
        // Create a linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Assigning random pointers
        head.random = head.next.next; // 1's random points to 3
        head.next.random = head; // 2's random points to 1
        head.next.next.random = head.next; // 3's random points to 2

        // Create an instance of Clone_A_LinkedList_With_Next_And_Random_Pointer
        Clone_A_LinkedList_With_Next_And_Random_Pointer solution = new Clone_A_LinkedList_With_Next_And_Random_Pointer();

        // Clone the list
        Node clonedHead = solution.copyList(head);

        // Output the cloned list
        Node temp = clonedHead;
        while (temp != null) {
            System.out.println("Data: " + temp.data + ", Random: " + (temp.random != null ? temp.random.data : "null"));
            temp = temp.next;
        }

        // Output will be ->
        // Data: 1, Random: 3
        // Data: 2, Random: 1
        // Data: 3, Random: 2
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)