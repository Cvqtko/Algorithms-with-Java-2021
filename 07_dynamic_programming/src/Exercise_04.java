import java.util.Arrays;
import java.util.Scanner;

public class Exercise_04 {

	public static int[] bestPrises;
	public static int[] prevIndex;
	public static int[] prices;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		prices = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int length = Integer.parseInt(scanner.nextLine());

		bestPrises = new int[length + 1];
		prevIndex = new int[length + 1];

		int maxProfit = cutRope(length);

		System.out.println(maxProfit);
		reconstructSolution(length);
	}

	private static int cutRope(int length) {
		if (length == 0) {
			return 0;
		}
		if (bestPrises[length] != 0) {
			return bestPrises[length];
		}
		int currentBest = bestPrises[length];

		for (int i = 1; i <= length; i++) {
			currentBest = Math.max(currentBest, prices[i] + cutRope(length - i));
			if (currentBest > bestPrises[length]) {
				bestPrises[length] = currentBest;
				prevIndex[length] = i;
			}
		}

		return bestPrises[length];

	}

	private static void reconstructSolution(int length) {
		while (length - prevIndex[length] != 0) {
			System.out.print(prevIndex[length] + " ");
			length = length - prevIndex[length];
		}
		System.out.println(prevIndex[length]);
	}
}
