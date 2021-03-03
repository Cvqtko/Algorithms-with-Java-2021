import java.util.Arrays;
import java.util.Scanner;

public class Exercise_05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		int k = Integer.parseInt(scanner.nextLine());
		char[] combinations = new char[k];

		combinations(0, 0, elements,combinations);
	}

	public static void combinations(int index,int start, char[] elements, char[] combinations) {
		if (index == combinations.length) {
			print(combinations);
		} else {
			for (int i = start; i < elements.length; i++) {
				combinations[index] = elements[i];
				combinations(index + 1,i+1, elements, combinations);

			}
		}
	}

	private static void print(char[] perm) {
		System.out.println(new String(perm));

	}

}
