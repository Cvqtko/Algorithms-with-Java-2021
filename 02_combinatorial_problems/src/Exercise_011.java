import java.util.Arrays;
import java.util.Scanner;

public class Exercise_011 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();

		permute(0, elements);
	}

	public static void permute(int index, char[] elements) {
		if (index == elements.length) {
			print(elements);
			return;
		} else {
			permute(index + 1, elements);
			for (int i = index + 1; i < elements.length; i++) {
				swap(index, i, elements);
				permute(index + 1, elements);
				swap(index, i, elements);
			}
		}
	}

	private static void swap(int first, int second, char[] elements) {
		char temp = elements[first];
		elements[first] = elements[second];
		elements[second] = temp;
	}

	private static void print(char[] perm) {
		System.out.println(new String(perm));

	}

}
