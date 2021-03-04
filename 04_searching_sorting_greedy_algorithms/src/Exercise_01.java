import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_01 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int key = Integer.parseInt(reader.readLine());

		System.out.println(binarySearch(arr, key, 0, arr.length));
	}

	static int binarySearch(int arr[], int key, int start, int end) {
		while (end >= start) {
			int mid = (start + end) / 2;
			if (arr[mid] < key)
				start = mid + 1;
			else if (arr[mid] > key)
				end = mid - 1;
			else
				return mid;
		}
		return -1;
	}

}
