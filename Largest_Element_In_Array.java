

// GFG: LARGEST ELEMENT IN ARRAY:


public class Largest_Element_In_Array {
    public static int largest(int[] arr) {
        // Initialize the variable to store the maximum element
        int max = arr[0]; // Start with the first element
        
        // Traverse the array to find the maximum element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if current element is larger
            }
        }
        
        return max; // Return the largest element
    }

    // Main method to run the solution
    public static void main(String[] args) {
        int[] array = {10, 20, 4, 45, 99};
        int result = largest(array);
        System.out.println("Largest element: " + result);
        //Output will be -> Largest element: 99
    }
}
