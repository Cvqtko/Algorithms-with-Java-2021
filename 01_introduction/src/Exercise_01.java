import java.util.Arrays;
import java.util.Scanner;

public class Exercise_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();

		
		sumRecursion(arr, 0);

		System.out.println("Iteration sum: " + sumIterative(arr));
		System.out.println("Recursion sum: " + sumRecursion(arr, 0));
	}

	public static int sumRecursion(int[] numbers, int index) {
		if (index >= numbers.length) {
			return 0;
		}
		return numbers[index] + sumRecursion(numbers, index + 1);

	}

	private static int sumIterative(int[] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}
}
