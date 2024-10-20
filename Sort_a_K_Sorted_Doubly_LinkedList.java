
//GFG -> Sort a k sorted linkedlist ->

import java.util.PriorityQueue;

// Node definition for doubly linked list
class DLLNode {
    int data;
    DLLNode next, prev;

    // Constructor
    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Sort_a_K_Sorted_Doubly_LinkedList {
    // Method to sort a k-sorted doubly linked list
    public static DLLNode sortAKSortedDLL(DLLNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // Min-heap to store at most 'k' nodes at a time
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        // Push first k+1 elements to the heap
        while (count <= k) {
            count++;
            pq.add(head.data);
            head = head.next;

            if (head == null) {
                // Create the sorted list with nodes from the heap
                DLLNode sortedHead = new DLLNode(pq.poll());
                DLLNode temp = sortedHead;

                while (!pq.isEmpty()) {
                    DLLNode newNode = new DLLNode(pq.poll());
                    temp.next = newNode;
                    newNode.prev = temp;
                    temp = temp.next;
                }
                return sortedHead;
            }
        }

        // Create the sorted list with nodes from the heap
        DLLNode sortedHead = new DLLNode(pq.poll());
        DLLNode temp = sortedHead;

        // Continue adding elements to the heap while processing the list
        while (head != null) {
            pq.add(head.data); // Add current node data to the heap
            DLLNode newNode = new DLLNode(pq.poll()); // Get the smallest element from heap
            temp.next = newNode; // Add to sorted list
            newNode.prev = temp;
            temp = temp.next;
            head = head.next; // Move to the next node in the original list
        }

        // Process remaining elements in the heap
        while (!pq.isEmpty()) {
            DLLNode newNode = new DLLNode(pq.poll());
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next;
        }

        return sortedHead; // Return the new sorted list head
    }

    // Utility function to print the doubly linked list
    public static void printList(DLLNode head) {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility function to insert a node at the end of the doubly linked list
    public static DLLNode insertNode(DLLNode head, int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            return newNode;
        }
        DLLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    public static void main(String[] args) {
        // Example: Create a k-sorted doubly linked list
        DLLNode head = null;

        head = insertNode(head, 3);
        head = insertNode(head, 6);
        head = insertNode(head, 2);
        head = insertNode(head, 12);
        head = insertNode(head, 56);
        head = insertNode(head, 8);

        int k = 2;

        System.out.println("Original k-sorted doubly linked list:");
        printList(head);

        // Sort the k-sorted doubly linked list
        DLLNode sortedHead = sortAKSortedDLL(head, k);

        System.out.println("Sorted doubly linked list:");
        printList(sortedHead);
        /*
         * Output will be -> Original k-sorted doubly linked list:
         * 3 6 2 12 56 8
         * Sorted doubly linked list:
         * 2 3 6 8 12 56
         */
    }
}

// ! Time Complexity = O(n log k)
// ! Space Complexity = O(k)