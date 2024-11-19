
//GFG -> Majority Element ||

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Majority_Element2 {
    public static List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        List<Integer> majorityVotes = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequencies of elements in the array
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // Check for elements with frequency greater than n/3
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > n / 3) {
                majorityVotes.add(entry.getKey());
            }
        }

        return majorityVotes;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 1, 2, 2 };

        List<Integer> result = findMajority(nums);

        System.out.println("Majority elements are: " + result);
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(N)