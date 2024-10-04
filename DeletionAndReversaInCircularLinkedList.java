
// GFG -> Deletion and Reversal in Circular Linked List

public class DeletionAndReversaInCircularLinkedList {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        if (head == null || head.next == head)
            return head;

        Node prev = null, curr = head, next = null, tail = head;
        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != head);

        tail.next = prev;
        return prev;
    }

    // Function to delete a node with the specified key from a circular linked list
    Node deleteNode(Node head, int key) {
        if (head == null)
            return null;

        if (head.data == key) {
            if (head.next == head)
                return null;

            Node tail = head;
            while (tail.next != head)
                tail = tail.next;

            head = head.next;
            tail.next = head;
            return head;
        }

        Node temp = head;
        while (temp.next != head) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        DeletionAndReversaInCircularLinkedList sc = new DeletionAndReversaInCircularLinkedList();
        // Create a sample circular linked list: 1 -> 2 -> 3 -> 4 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;

        // Reverse the circular linked list
        head = sc.reverse(head);

        // Delete a node with value 3 from the reversed circular linked list
        head = sc.deleteNode(head, 3);

        // Print the modified circular linked list
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)