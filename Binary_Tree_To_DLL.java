
/*GFG : Binary Tree To DLL */

class Node {
    Node left, right;
    int data;

    Node(int d) {
        data = d;
        left = right = null;
    }

}

public class Binary_Tree_To_DLL {
    Node prev = null; // Keeps track of the previous node in DLL
    Node head = null; // Points to the head of the DLL

    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root) {
        if (root == null)
            return null;

        // Convert the left subtree and link it
        bToDLL(root.left);

        // Convert the current node
        if (prev == null) {
            head = root; // The leftmost node becomes the head of DLL
        } else {
            prev.right = root; // Link the previous node to the current node
            root.left = prev; // Link the current node to the previous node
        }
        prev = root; // Update the previous node

        // Convert the right subtree and link it
        bToDLL(root.right);

        return head; // Return the head of the DLL
    }

    public static void main(String[] args) {
        // Example usage:
        Binary_Tree_To_DLL solution = new Binary_Tree_To_DLL();

        // Create a binary tree for demonstration
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(25);

        // Convert the binary tree to DLL
        Node head = solution.bToDLL(root);

        // Print the doubly linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        // Output should be in sorted order: 1 5 8 10 20 25
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(h)