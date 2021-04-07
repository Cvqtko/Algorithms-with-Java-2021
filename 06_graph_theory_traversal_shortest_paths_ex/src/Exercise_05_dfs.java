import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise_05_dfs {

	public static Map<String, List<String>> graph = new HashMap<>();
	public static Set<String> edgesToRemove = new HashSet<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String source = null;

		String line = scanner.nextLine();
		while (!line.equals("")) {

			String[] tokens = line.split(" -> ");

			if (source == null) {
				source = tokens[0];
			}

			String[] edges = tokens[1].split(" ");
			graph.putIfAbsent(tokens[0], new ArrayList<>());
			for (String edge : edges) {
				graph.get(tokens[0]).add(edge);
			}
			line = scanner.nextLine();
		}

		Set<String> visited = new HashSet<>();
		Set<String> cycles = new HashSet<>();

		for (String edge : graph.keySet()) {
			dfs(graph, edge, visited, cycles);
		}
		edgesToRemove.stream().forEach(e -> System.out.println(e));
	}

	private static void dfs(Map<String, List<String>> graph, String source, Set<String> visited, Set<String> cycles) {
		if (cycles.contains(source)) {
			edgesToRemove.add(source + " - " + graph.get(source).get(0));

			String dest = graph.get(source).get(0);
			if (graph.get(dest).contains(source)) {
				graph.get(dest).remove(source);
			}
			if (graph.get(source).contains(dest)) {
				graph.get(source).remove(dest);
			}
			return;

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

		for (String child : children) {

			dfs(graph, child, visited, cycles);

		}
		cycles.remove(source);
	}
}
