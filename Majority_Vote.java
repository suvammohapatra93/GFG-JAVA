import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Majority_Vote {
    // Function to find the majority elements in the array
    public static List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        int n = nums.size();
        if (n == 0)
            return new ArrayList<>(); // Empty array

        // Step 1: Find potential candidates
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3)
            result.add(candidate1);
        if (count2 > n / 3)
            result.add(candidate2);
        if (result.isEmpty())
            result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 2, 3, 1, 1, 1);
        System.out.println(findMajority(nums)); // Output: [1]
    }
}