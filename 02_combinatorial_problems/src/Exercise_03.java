import java.util.Arrays;
import java.util.Scanner;

public class Exercise_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		int k = Integer.parseInt(scanner.nextLine());
		char[] variations = new char[k];
		boolean[] used = new boolean[elements.length];

		variations(0, elements, variations, used);
	}

	public static void variations(int index, char[] elements, char[] variations, boolean[] used) {
		if (index == variations.length) {
			print(variations);
			return;
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!used[i]) {
					used[i] = true;
					variations[index] = elements[i];
					variations(index + 1, elements, variations, used);
					used[i] = false;
				}
			}
		}
	}

	private static void print(char[] perm) {
		System.out.println(new String(perm));

	}

}
