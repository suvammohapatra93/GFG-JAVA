
//GFG -> Delete Alternate Nodes ->

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Delete_Alternate_Nodes {
    public static void deleteAlt(Node head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null)
            return;

        Node curr = head;

        // Traverse the list and delete alternate nodes
        while (curr != null && curr.next != null) {
            Node temp = curr.next.next; // Skip the next node
            curr.next = temp; // Link current node to the node after next
            curr = temp; // Move to the next alternate node
        }
    }

    // Utility method to print the linked list
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        printList(head);

        // Deleting alternate nodes
        deleteAlt(head);

        System.out.println("List after deleting alternate nodes:");
        printList(head);
        /*
         * Output will be -> Original list: 1 2 3 4 5
         * List after deleting alternate nodes: 1 3 5
         */
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)