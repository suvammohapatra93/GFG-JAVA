
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Multiply_Two_LinkedLists {
    public static long multiplyTwoLists(Node first, Node second) {
        long n1 = 0, n2 = 0;
        int MOD = 1000000007;

        // Calculate number represented by first linked list
        Node cur1 = first;
        while (cur1 != null) {
            n1 = (n1 * 10 + cur1.data) % MOD;
            cur1 = cur1.next;
        }

        // Calculate number represented by second linked list
        Node cur2 = second;
        while (cur2 != null) {
            n2 = (n2 * 10 + cur2.data) % MOD;
            cur2 = cur2.next;
        }

        // Return the multiplication result modulo MOD
        return (n1 * n2) % MOD;
    }

    public static void main(String[] args) {
        // Create first linked list: 123
        Node first = new Node(1);
        first.next = new Node(2);
        first.next.next = new Node(3);

        // Create second linked list: 456
        Node second = new Node(4);
        second.next = new Node(5);
        second.next.next = new Node(6);

        long result = multiplyTwoLists(first, second);
        System.out.println("Product of the two linked lists: " + result);

        // Output will be -> Product of the two linked lists: 56088
    }
}

// ! Time Complexity = O(n+m)
// ! Space Complexity = O(1)