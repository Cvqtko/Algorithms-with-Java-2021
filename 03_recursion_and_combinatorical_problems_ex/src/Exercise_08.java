import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise_08 {
	public static List<String> words;
	public static List<String> combined;
	public static String target;

	public static Set<String> out = new TreeSet<>();

	public static Map<Integer, List<String>> table;
	public static Map<String, Integer> occurrences;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		words = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
		target = reader.readLine();
		table = new HashMap<>();
		occurrences = new HashMap<>();
		combined = new ArrayList<>();
		words.removeIf(next -> !target.contains(next));

		for (String substr : words) {
			occurrences.putIfAbsent(substr, 0);
			occurrences.put(substr, occurrences.get(substr) + 1);
			int index = target.indexOf(substr);

			while (index != -1) {
				table.putIfAbsent(index, new ArrayList<>());
				table.get(index).add(substr);
				index = target.indexOf(substr, index + 1);
			}
		}

		permute(0);

		for (String str : out) {
			System.out.println(str);
		}
	}

	private static void permute(int index) {
		if (index == target.length()) {
			print();
		} else if (table.containsKey(index)) {
			List<String> strings = table.get(index);
			for (String str : strings) {
				if (occurrences.get(str) > 0) {
					occurrences.put(str, occurrences.get(str) - 1);
					combined.add(str);
					permute(index + str.length());
					combined.remove(combined.size() - 1);
					occurrences.put(str, occurrences.get(str) + 1);
				}
			}
		}
	}

	private static void print() {
		String actual = String.join("", combined);
		if (actual.contains(target)) {
			out.add(String.join(" ", combined));
		}

	}

}
