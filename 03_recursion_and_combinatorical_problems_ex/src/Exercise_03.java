import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_03 {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int k = Integer.parseInt(reader.readLine());
		arr = new int[k];

		combinations(n, 0, 1);
	}

	private static void combinations(int n, int index, int start) {
		if (index == arr.length) {
			print(arr);
		} else {
			for (int i = start; i <= n; i++) {
				arr[index] = i;
				combinations(n, index + 1, i);
			}
		}

	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
