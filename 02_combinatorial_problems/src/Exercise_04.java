import java.util.Arrays;
import java.util.Scanner;

public class Exercise_04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		int k = Integer.parseInt(scanner.nextLine());
		char[] variations = new char[k];

		variations(0, elements, variations);
	}

	public static void variations(int index, char[] elements, char[] variations) {
		if (index == variations.length) {
			print(variations);
		} else {
			for (int i = 0; i < elements.length; i++) {

				variations[index] = elements[i];
				variations(index + 1, elements, variations);

			}
		}
	}

	private static void print(char[] perm) {
		System.out.println(new String(perm));

	}

}
