import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_01 {

	public static int n;
	public static int[] expression;
	public static int solutions;
	public static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		expression = new int[n];
		solutions = 0;
		combinationsWithoutRep(0, 1);
		builder.append("Total Solutions: " + solutions);
		System.out.println(builder.toString());
	}

	private static void combinationsWithoutRep(int index, int start) {
		if (index >= n) {
			printSolution();
		} else {

			for (int i = start; i <= n; i++) {
				expression[index] = i;
				combinationsWithoutRep(index + 1, i + 1);
				expression[index] = -i;
				combinationsWithoutRep(index + 1, i + 1);
			}
		}

	}

	private static void printSolution() {
		int sum = Arrays.stream(expression).sum();
		if (sum == 0) {
			solutions++;
			for (int i = 0; i < expression.length; i++) {
				int value = expression[i];

				if (value > 0) {
					builder.append("+" + value + " ");
				} else {
					builder.append(value + " ");
				}
			}
			builder.append(System.lineSeparator());
		}
	}
}
