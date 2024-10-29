
// GFG -> QUICK SORT ON LINKEDLIST

import java.util.ArrayList;
import java.util.Collections;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Quick_Sort_On_LinkedList {

    public static Node quickSort(Node node) {
        if (node == null || node.next == null)
            return node;

        ArrayList<Integer> li = new ArrayList<>();
        Node cur = node;
        while (cur != null) {
            li.add(cur.data);
            cur = cur.next;
        }

        Collections.sort(li);
        cur = node;
        for (int i = 0; i < li.size(); i++) {
            cur.data = li.get(i);
            cur = cur.next;
        }

        return node;
    }

    public static void main(String[] args) {
        // Creating a linked list: 3 -> 1 -> 4 -> 2 -> null
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);

        // Sort the linked list
        head = quickSort(head);

        // Print the sorted linked list
        System.out.print("Sorted linked list: ");
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        // output -> 1 2 3 4
    }
}

// ! Time Complexity = O(N log N)
// ! Space Complexity = O(N)