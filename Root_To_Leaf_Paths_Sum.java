
//GFG -> Root To Left Paths Sum

class Node {
    int data;
    Node left, right;

    // Constructor for creating a new node with given data
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Root_To_Leaf_Paths_Sum {
    // Helper method that performs a recursive traversal of the tree and computes
    // the sum of all root-to-leaf paths
    static int helper(Node root, int val) {
        // If this is a leaf node, return the path value calculated so far, including
        // this node
        if (root.left == null && root.right == null) {
            return val * 10 + root.data;
        }

        // Variable to accumulate the sum of paths
        int sum = 0;

        // Recur for the left subtree if it exists
        if (root.left != null) {
            sum += helper(root.left, val * 10 + root.data);
        }

        // Recur for the right subtree if it exists
        if (root.right != null) {
            sum += helper(root.right, val * 10 + root.data);
        }

        // Return the accumulated sum of paths
        return sum;
    }

    // Public method to be called for calculating the sum of all root-to-leaf path
    // sums
    public static int treePathsSum(Node root) {
        return helper(root, 0);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Sum of all root-to-leaf paths: " + treePathsSum(root));
        // Output -> 522
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(H)