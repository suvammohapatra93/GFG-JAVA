
// GFG:MAJORITY ELEMENT:

public class Majority_Element {
    public static int majorityElement(int arr[]) {
        int count = 0, candidate = 0;

        // Phase 1: Find a candidate for majority element
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify the candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }

        // Assuming the input always has a majority element
        if (count > arr.length / 2) {
            return candidate;
        }

        return -1; // Just in case there is no majority element (depends on the problem's
                   // constraints)
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3 };
        System.out.println(majorityElement(arr)); // Output: 3
    }
}

// ! Time Complexity = O(n)
// ! Time Complexity = O(1)
