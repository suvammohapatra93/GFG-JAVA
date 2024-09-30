

// GFG -> Merge Two BST'S


// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Merge_Two_BSTS {
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root1, sortedList);
        inOrderTraversal(root2, sortedList);
        sortedList.sort(Integer::compareTo);
        return sortedList;
    }
    
    private void inOrderTraversal(Node root, List<Integer> sortedList) {
        if (root == null) return;
        inOrderTraversal(root.left, sortedList);
        sortedList.add(root.data);
        inOrderTraversal(root.right, sortedList);
    }
}