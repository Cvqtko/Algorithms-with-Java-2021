import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_02 {

	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		arr = new int[n];

		permute(0);
	}

	private static void permute(int index) {
		if (index == arr.length) {
			print(arr);
		} else {
			for (int i = 1; i <= arr.length; i++) {
				arr[index] = i;
				permute(index + 1);
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
