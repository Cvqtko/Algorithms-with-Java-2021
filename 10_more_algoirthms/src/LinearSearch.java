
public class LinearSearch {
	public static int search(int arr[], int x) {
	
		// Traverse array arr[]
		for (int i = 0; i < arr.length; i++) {

			// If element found then
			// return that index
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	// Driver Code
	public static void main(String args[]) {
		// Given arr[]
		int arr[] = { 2, 3, 4, 10, 40 };

		// Element to search
		int x = 10;

		// Function Call
		int result = search(arr, x);
		if (result == -1)
			System.out.print("Element is not present in array");
		else
			System.out.print("Element is present" + " at index " + result);
	}
}
