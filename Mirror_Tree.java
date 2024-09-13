
/* MIRROR TREE -> */

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Mirror_Tree {

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void mirror(Node node) {
        // Base case: if the node is null, return
        if (node == null) {
            return;
        }

        // Recursive case: swap the left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively call mirror on the left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Print the original tree (in-order)
        System.out.println("Original tree (in-order traversal):");
        inOrder(root);
        System.out.println();

        // Mirror the tree
        mirror(root);

        // Print the mirrored tree (in-order)
        System.out.println("Mirrored tree (in-order traversal):");
        inOrder(root);

        // Output will be ->
        /*
         * Original tree (in-order traversal):
         * 4 2 5 1 3
         * Mirrored tree (in-order traversal):
         * 3 1 5 2 4
         */
    }
}