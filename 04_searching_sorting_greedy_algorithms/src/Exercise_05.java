import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercise_05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] universeInput = scanner.nextLine().substring(10).split(", ");
		System.out.println();

		List<Integer> universe = new ArrayList<Integer>();

		for (String uni : universeInput) {
			universe.add(Integer.parseInt(uni));
		}

		int numberOfSets = Integer.parseInt(scanner.nextLine().substring(16));
		List<int[]> sets = new ArrayList<int[]>();
		while (numberOfSets-- > 0) {
			int[] currentSet = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
			sets.add(currentSet);
		}
		List<int[]> chosenSets = chooseSets(sets, universe);
		System.out.printf("Sets to take (%d):\n",chosenSets.size());
		for (int[] chosen : chosenSets) {
			System.out.print("{ ");
			for (int i = 0; i < chosen.length - 2; i++) {
				System.out.print(chosen[i] + ", ");
			}
			System.out.println(chosen[chosen.length - 1] + " }");
		}
	}

	public static List<int[]> chooseSets(List<int[]> sets, List<Integer> universe) {

		List<int[]> selectedSets = new ArrayList<>();

		Set<Integer> universeSet = new HashSet<>();

		for (int element : universe) {
			universeSet.add(element);
		}

		while (!universeSet.isEmpty()) {
			int notChosenCount = 0;

			int[] chosenSet = sets.get(0);

			for (int[] set : sets) {

				int count = 0;

				for (int elem : set) {

					if (universeSet.contains(elem)) {

						count++;

					}

				}

				if (notChosenCount < count) {

					notChosenCount = count;

					chosenSet = set;

				}

			}

			selectedSets.add(chosenSet);

			for (int elem : chosenSet) {

				universeSet.remove(elem);

			}

		}

		return selectedSets;

	}
}
