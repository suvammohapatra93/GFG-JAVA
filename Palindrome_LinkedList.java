
//GFG: PALINDROME LINKEDLIST -:

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Palindrome_LinkedList {
    // Function to check whether the list is palindrome.
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;
        // Move slow to middle, and fast to end of the list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of the list
        Node curr = slow;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare the two halves
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        // Check if the list is a palindrome
        boolean result = isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result);
        // Output will be -> Is the linked list a palindrome? true
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)