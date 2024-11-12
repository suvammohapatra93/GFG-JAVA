
//GFG -> Intersection points with Y shaped LinkedLists

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

// Linked List class
class LinkedList {
    Node head; // head of list

    // Method to add a new node at the end of the linked list
    public void append(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }
}

// Class containing the intersectPoint method to find intersection point in
// Y-shaped Linked Lists
class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        Node temp = head1;

        // Mark nodes of the first list by adding a large constant to their data value
        while (temp != null) {
            temp.data += 21000;
            temp = temp.next;
        }

        // Traverse the second list and look for the first node with marked data
        temp = head2;
        while (temp != null) {
            if (temp.data >= 21000) {
                return temp.data - 21000;
            }
            temp = temp.next;
        }

        // Restore the original data in the first list before returning -1 if no
        // intersection
        temp = head1;
        while (temp != null) {
            temp.data -= 21000;
            temp = temp.next;
        }

        return -1;
    }
}

public class Intersection_Points_In_Y_Shaped_LinkedLists {
    public static void main(String[] args) {
        // Creating two linked lists with a Y-shaped intersection
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        // Nodes for the first linked list
        list1.append(3);
        list1.append(6);
        list1.append(9);

        // Nodes for the second linked list
        list2.append(10);

        // Creating intersection point
        Node intersection = new Node(15);
        list1.head.next.next.next = intersection;
        list2.head.next = intersection;

        // Extending the intersection node in both lists
        intersection.next = new Node(30);

        // Create an instance of Intersect class
        Intersect intersect = new Intersect();

        // Find and print the intersection point
        int result = intersect.intersectPoint(list1.head, list2.head);
        if (result != -1) {
            System.out.println("The intersection point is: " + result);
        } else {
            System.out.println("No intersection point found.");
        }

        //  Output -> 15
    }
}

// ! Time Complexity = O(m+n)
// ! Space Complexity = O(1)