import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Exercise_02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	}
	
	public static List<String> topSort(Map<String,List<String>> graph){
		Map<String,Integer> dependenciesCount = getDependenciesCount(graph);
		List<String> sorted = new ArrayList<>();
		
		while(graph.isEmpty()) {
			String key = graph.keySet().stream().filter(k->dependenciesCount.get(0)==0).findFirst().orElse(null);
			
			if(key==null) {
				break;
			}
			
			for(String child: graph.get(key)) {
				dependenciesCount.put(child, dependenciesCount.get(child)-1);
			}
			
		
			sorted.add(key);
			graph.remove(key);
		}
		if(!graph.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return sorted;
	}

	private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
		Map<String,Integer> dependenciesCount = new LinkedHashMap<>();
		
		for(Entry<String, List<String>> node : graph.entrySet()) {
			dependenciesCount.putIfAbsent(node.getKey(), 0);
			
			for(String child : node.getValue()) {
				dependenciesCount.putIfAbsent(child, 0);
				dependenciesCount.put(child,dependenciesCount.get(child)+1);
			}
		}
		return dependenciesCount;
	}
}
