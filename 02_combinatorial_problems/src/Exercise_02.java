import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		HashSet<String> swapped = new HashSet<>();
		permute(0, elements, swapped);
		print(swapped);
	}

	public static void permute(int index, char[] elements, HashSet<String> swapped) {
		if (index == elements.length) {
			swapped.add(new String(elements));
		} else {
			permute(index + 1, elements, swapped);
			for (int i = index + 1; i < elements.length; i++) {
				swap(index, i, elements);
				permute(index + 1, elements, swapped);
				swap(index, i, elements);
			}
		}
	}

	private static void swap(int first, int second, char[] elements) {
		char temp = elements[first];
		elements[first] = elements[second];
		elements[second] = temp;
	}

	private static void print( HashSet<String> swapped) {
		System.out.println(String.join("\n", swapped));

	}

}
