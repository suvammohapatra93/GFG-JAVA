
/*GFG:MIN AND MAX IN AN ARRAY: */

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

public class Min_And_Max_In_An_Array {
    // Function to find the minimum and maximum values in an array
    public Pair<Long, Long> getMinMax(int[] arr) {
        // Initialize min and max as the first element of the array
        long min = arr[0];
        long max = arr[0];

        // Loop through the array to find the actual min and max
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // Return the result as a Pair of min and max
        return new Pair<>(min, max);
    }

    // Main method
    public static void main(String[] args) {
        Min_And_Max_In_An_Array sc = new Min_And_Max_In_An_Array();

        // Example input array
        int[] arr = { 3, 5, 1, 8, -3, 9, 0 };

        // Get the min and max using the getMinMax function
        Pair<Long, Long> result = sc.getMinMax(arr);

        System.out.println("Minimum and Maximum values: " + result);
        //Output will be -> Minimum and Maximum values: (-3, 9)
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)