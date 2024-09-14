
// GFG:ALTERNATIVE POSITIVE AND NEGATIVE NUMBER:

import java.util.ArrayList;

public class Alternative_Positive_And_Negative_Number {
    public static void rearrange(ArrayList<Integer> arr) {
        // Separate positive and negative numbers
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();

        for (int num : arr) {
            if (num >= 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        // Indexes for positive and negative lists
        int posIndex = 0, negIndex = 0;
        boolean placePositive = true;

        // ArrayList to store the result
        ArrayList<Integer> result = new ArrayList<>();

        // Rearrange numbers alternatively
        while (posIndex < positives.size() && negIndex < negatives.size()) {
            if (placePositive) {
                result.add(positives.get(posIndex++));
            } else {
                result.add(negatives.get(negIndex++));
            }
            placePositive = !placePositive; // Toggle between positive and negative
        }

        // Add remaining positives, if any
        while (posIndex < positives.size()) {
            result.add(positives.get(posIndex++));
        }

        // Add remaining negatives, if any
        while (negIndex < negatives.size()) {
            result.add(negatives.get(negIndex++));
        }

        // Copy the result back to the original array
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, result.get(i));
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-2);
        arr.add(3);
        arr.add(-4);
        arr.add(5);
        arr.add(-6);

        Alternative_Positive_And_Negative_Number.rearrange(arr);

        System.out.println("Rearranged array: " + arr);
        // Output will be -> Rearranged array: [1, -2, 3, -4, 5, -6]
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)