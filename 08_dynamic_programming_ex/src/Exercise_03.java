import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int sum = Arrays.stream(numbers).sum();
		int totalHalf = (int) Math.floor(((double) sum) / 2);

		int rows = numbers.length;
		int cols = totalHalf;

		int[][] matrix = new int[rows + 1][cols + 1];
		boolean[][] usedMatrix = new boolean[rows][cols];

		for (int i = 1; i < rows + 1; i++) {
			for (int j = 1; j < cols + 1; j++) {
				int include = -1;
				if (numbers[i - 1] <= j) {
					include = numbers[i - 1] + matrix[i - 1][j - numbers[i - 1]];
				}
				int exclude = matrix[i - 1][j];

				if (include > exclude) {
					// include the number
					matrix[i][j] = include;
					usedMatrix[i - 1][j - 1] = true;
				} else {
					// exclude the number
					matrix[i][j] = exclude;
				}
			}
		}
		List<Integer> result = new LinkedList<>();
		int currentRow = rows - 1;
		int currentCol = cols - 1;
		while (currentRow >= 0 && currentCol >= 0) {
			if (usedMatrix[currentRow][currentCol]) {
				result.add(numbers[currentRow]);
				currentCol -= numbers[currentRow];
			}
			currentRow--;
		}
		int alanSum = result.stream().mapToInt(a -> a).sum();
		int bobSum = sum - alanSum;

		System.out.println("Difference: " + Math.abs(alanSum - bobSum));
		System.out.printf("Alan:%d Bob:%d\n", alanSum, bobSum);
		System.out.println("Alan takes: " + result.stream().map(String::valueOf)
			    .collect(Collectors.joining(" ")));
		System.out.println("Bob takes the rest.");
	}
}