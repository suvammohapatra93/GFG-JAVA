
// GFG:TOP VIEW OF BINARY TREE:

import java.util.*;

// Class representing a binary tree node
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Top_View_Of_A_Binary_Tree {
    // Function to return the top view of the binary tree
    static class Pair {
        Node node;
        int hd; // Horizontal distance

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        // TreeMap to store the first node at each horizontal distance (sorted)
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        // Queue for level order traversal (stores node and its horizontal distance)
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        // Perform BFS
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            Node node = temp.node;
            int hd = temp.hd;

            // Add to top view map if this is the first node at that horizontal distance
            if (!topViewMap.containsKey(hd)) {
                topViewMap.put(hd, node.data);
            }

            // Move to the left and right child, adjusting the horizontal distance
            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        // Add all values from the topViewMap to the result list
        result.addAll(topViewMap.values());
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Constructing a binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        ArrayList<Integer> topView = topView(root);
        System.out.println(topView); 
        // Output: [2, 1, 3, 6]
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)