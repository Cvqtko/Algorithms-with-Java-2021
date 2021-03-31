import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise_03 {

	public static Map<String, List<String>> graph = new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String source = null;

		String line = scanner.nextLine();
		while (!line.equals("End")) {

			String[] tokens = line.split("-");

			if (source == null) {
				source = tokens[0];
			}

			graph.putIfAbsent(tokens[0], new ArrayList<>());

			graph.get(tokens[0]).add(tokens[1]);

			line = scanner.nextLine();
		}

		Set<String> visited = new HashSet<>();
		Set<String> cycles = new HashSet<>();

		try {
			dfs(source, visited, cycles);
			System.out.println("Acyclic: Yes");
		} catch (IllegalStateException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void dfs(String source, Set<String> visited, Set<String> cycles) {
		if (cycles.contains(source)) {
			throw new IllegalStateException("Acyclic: No");
		}
		if (visited.contains(source)) {
			return;
		}

		cycles.add(source);
		visited.add(source);

		List<String> children = graph.get(source);

		if (children == null) {
			return;
		}
		
		System.out.println();
		
		for (String child : graph.get(source)) {

			dfs(child, visited, cycles);

		}
		cycles.remove(source);
	}
}
