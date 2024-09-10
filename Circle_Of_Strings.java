
/* Circle_Of_Strings
 * 
 * Given an array arr of lowercase strings, determine if the strings can be chained together to form a circle.
A string X can be chained together with another string Y if the last character of X is the same as the first character of Y. If every string of the array can be chained with exactly two strings of the array(one with the first character and the second with the last character of the string), it will form a circle.
For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"
Examples
Input: arr[] = ["abc", "bcd", "cdf"]
Output: 0
Explaination: These strings can't form a circle because no string has 'd'at the starting index.
Input: arr[] = ["ab" , "bc", "cd", "da"]
Output: 1
Explaination: These strings can form a circle of strings.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
Constraints: 
1 ≤ length of strings ≤ 20
*/

import java.util.*;

public class Circle_Of_Strings {

    private void dfs(int node, boolean visited[], List<List<Integer>> adj) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei, visited, adj);
            }
        }
    }

    public int isCircle(String arr[]) {
        List<List<Integer>> adj = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        int in[] = new int[26];
        int out[] = new int[26];

        for (String str : arr) {
            int chS = str.charAt(0) - 'a';
            int chE = str.charAt(str.length() - 1) - 'a';

            adj.get(chS).add(chE); // Using .get() instead of accessing array
            in[chE]++;
            out[chS]++;
        }

        for (int i = 0; i < 26; i++) {
            if (in[i] != out[i]) {
                return 0;
            }
        }

        int src = 0;

        for (int i = 0; i < 26; i++) {
            if (out[i] != 0) {
                src = i;
                break;
            }
        }

        boolean visited[] = new boolean[26];
        dfs(src, visited, adj);

        for (int i = 0; i < 26; i++) {
            if (!visited[i] && out[i] > 0) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Circle_Of_Strings cos = new Circle_Of_Strings();

        // Using try-with-resources to ensure Scanner is closed automatically
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of strings:");
            int n = sc.nextInt();
            sc.nextLine(); 

            String[] arr = new String[n];
            System.out.println("Enter the strings:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine();
            }

            int result = cos.isCircle(arr);

            if (result == 1) {
                System.out.println("The strings can form a circle.");
            } else {
                System.out.println("The strings cannot form a circle.");
            }
        } 
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)