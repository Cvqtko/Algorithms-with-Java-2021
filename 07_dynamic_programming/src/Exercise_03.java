import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());

		int[][] elements = new int[rows][cols];
		int[][] dp = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			elements[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}

		dp[0][0] = elements[0][0];

		for (int col = 1; col < cols; col++) {
			dp[0][col] = dp[0][col - 1] + elements[0][col];
		}

		for (int row = 1; row < rows; row++) {
			dp[row][0] = dp[row - 1][0] + elements[row][0];
		}
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + elements[row][col];
			}
		}
		int row = rows - 1;
		int col = cols - 1;

		List<String> path = new ArrayList<>();
		path.add(formatOutput(row, col));

		while (row >= 0 && col >= 0) {
			if (row == 0 && col == 0)
				break;
			int top = -1;
			int left = -1;

			if (row > 0) {
				top = dp[row - 1][col];
			}
			if (col > 0) {
				left = dp[row][col - 1];
			}

			if (top > left) {
				row--;
			} else {
				col--;
			}

			path.add(formatOutput(row, col));
		}
		Collections.reverse(path);
		System.out.println(String.join(" ", path));
	}

	private static String formatOutput(int row, int col) {
		// TODO Auto-generated method stub
		return "[" + row + ", " + col + " ]";
	}
}
