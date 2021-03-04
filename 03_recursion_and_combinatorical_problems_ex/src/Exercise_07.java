import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise_07 {

	public static String[] seats;
	public static String[] combinations;
	public static boolean[] used;
	public static List<String> people;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		people = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
		seats = new String[people.size()];

		String line = reader.readLine();

		while (!line.equals("generate")) {

			String[] tokens = line.split(" - ");
			String name = tokens[0];
			int position = Integer.parseInt(tokens[1]) - 1;

			seats[position] = name;

			people.remove(name);

			line = reader.readLine();
		}

		combinations = new String[people.size()];
		used = new boolean[people.size()];
		permute(0);

	}

	private static void permute(int index) {
		if (index == combinations.length) {
			print();
		} else {
			for (int i = 0; i < people.size(); i++) {
				if (!used[i]) {
					used[i] = true;
					combinations[index] = people.get(i);
					permute(index + 1);
					used[i] = false;
				}
			}
		}
	}

	private static void print() {
		int indexCombinations = 0;
		StringBuilder finalSeats = new StringBuilder();
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] != null) {
				finalSeats.append(seats[i] + " ");
			} else {
				finalSeats.append(combinations[indexCombinations++] + " ");
			}
		}
		System.out.println(finalSeats.toString().trim());
	}
}
