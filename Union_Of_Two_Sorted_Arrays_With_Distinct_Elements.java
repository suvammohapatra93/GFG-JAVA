
// GFG -> Union of two sorted arrays with distinct elements

import java.util.ArrayList;

public class Union_Of_Two_Sorted_Arrays_With_Distinct_Elements {

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        int lastone = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || lastone != a[i]) {
                    union.add(a[i]);
                    lastone = a[i];
                }
                i++;
            } else if (b[j] <= a[i]) {
                if (union.size() == 0 || lastone != b[j]) {
                    union.add(b[j]);
                    lastone = b[j];
                }
                j++;
            }
        }

        while (j < b.length) {
            if (lastone != b[j]) {
                union.add(b[j]);
                lastone = b[j];
            }
            j++;
        }

        while (i < a.length) {
            if (lastone != a[i]) {
                union.add(a[i]);
                lastone = a[i];
            }
            i++;
        }

        return union;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 5, 6 };
        int[] b = { 2, 3, 5, 7 };

        ArrayList<Integer> result = findUnion(a, b);

        System.out.println("Union of the two sorted arrays is:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

// ! Time Complexity = O(m+n)
// ! Space Complexity = O(m+n)