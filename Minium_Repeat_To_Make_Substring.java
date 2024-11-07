
//GFG -> Minimum Repeat To Make Substring

public class Minium_Repeat_To_Make_Substring {
    public static int minRepeats(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        int count = 1;

        // Keep appending s1 to itself and check if s2 is a substring
        while (sb.indexOf(s2) == -1) {
            count++;
            sb.append(s1);

            // If length of repeated s1 exceeds twice the length of s2 without finding s2
            if (sb.length() > 2 * s2.length() && sb.indexOf(s2) == -1) {
                return -1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";

        int result = minRepeats(s1, s2);
        System.out.println("Minimum repeats needed: " + result);
    }
}

// ! Time Complexity = O(n*m)
// ! Space Complexity = O(n*m)