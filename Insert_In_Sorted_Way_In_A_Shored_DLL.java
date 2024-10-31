
//GFG -> INSERT IN SORTED WAY IN A SHORTED DLL

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Insert_In_Sorted_Way_In_A_Shored_DLL {
    public Node sortedInsert(Node head, int x) {
        Node insert = new Node(x);

        // Case 1: Insert at the beginning or empty list
        if (head == null || head.data >= x) {
            insert.next = head;
            if (head != null) {
                head.prev = insert;
            }
            return insert;
        }

        // Case 2: Insert in the middle or end
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        // Insert the new node
        insert.next = current.next;
        if (current.next != null) {
            current.next.prev = insert;
        }
        current.next = insert;
        insert.prev = current;

        return head;
    }

    // Helper function to print the list for testing
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Insert_In_Sorted_Way_In_A_Shored_DLL solution = new Insert_In_Sorted_Way_In_A_Shored_DLL();

        // Create a sorted DLL
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;

        System.out.print("Original List: ");
        printList(head);

        // Insert in sorted order
        head = solution.sortedInsert(head, 25);
        System.out.print("After inserting 25: ");
        printList(head);

        head = solution.sortedInsert(head, 5);
        System.out.print("After inserting 5: ");
        printList(head);

        head = solution.sortedInsert(head, 35);
        System.out.print("After inserting 35: ");
        printList(head);
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)