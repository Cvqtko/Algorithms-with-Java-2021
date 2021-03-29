import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String nextLine = scanner.nextLine();
			if (nextLine.trim().equals("")) {
				graph.add(new ArrayList<>());
				continue;
			}
			List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+")).map(Integer::parseInt)
					.collect(Collectors.toList());

			graph.add(nextNodes);
		}
		List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

		for (Deque<Integer> connectedComponent : connectedComponents) {
			System.out.print("Connected component: ");
			for (int component : connectedComponent) {
				System.out.print(component + " ");
			}
			System.out.println();
		}
	}

	public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
		boolean[] visited = new boolean[graph.size()];
		List<Deque<Integer>> components = new ArrayList<Deque<Integer>>();

		for (int start = 0; start < graph.size(); start++) {
			if (!visited[start]) {
				components.add(new ArrayDeque<Integer>());
				dfs(start, components, graph, visited);
				System.out.println();
			}

		}

		return components;
	}

	private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
		if (!visited[node]) {
			visited[node] = true;
			for (int child : graph.get(node)) {
				dfs(child, components, graph, visited);
			}
			components.get(components.size() - 1).offer(node);
			// printing the components
			// System.out.print(node + " ");
		}

	}

}
