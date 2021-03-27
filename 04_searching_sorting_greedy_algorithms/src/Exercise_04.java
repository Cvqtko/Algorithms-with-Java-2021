import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Exercise_04 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] elements = scanner.nextLine().substring(7).split(", ");
		int[] coins = new int[elements.length];

		for (int i = 0; i < elements.length; i++) {
			coins[i] = Integer.parseInt(elements[i]);
		}
		int targetSum = Integer.parseInt(scanner.nextLine().substring(5));

		Map<Integer, Integer> usedCoins;
		try {
			usedCoins = chooseCoins(coins, targetSum);
			for (Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
				System.out.println(usedCoin.getKey() + "->" + usedCoin.getValue());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}


	}

	private static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) throws Exception {
		Map<Integer, Integer> usedCoins = new LinkedHashMap<Integer, Integer>();
		int index = coins.length - 1;
		while (targetSum != 0) {
			if(index<0) {
				throw new IllegalArgumentException("Error");
			}
			int coinsToTake = targetSum / coins[index];
			if (coinsToTake != 0) {
				usedCoins.put(coins[index], coinsToTake);
			}
			targetSum %= coins[index];
			index--;
			
		}
		return usedCoins;
	}
}
