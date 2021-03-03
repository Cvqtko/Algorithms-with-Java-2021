import java.util.Arrays;
import java.util.Scanner;

public class Exercise_01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] elements = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
		char[] permutes = new char[elements.length];
		boolean[] used = new boolean[elements.length];
		
		permute(0,elements,permutes,used);
	}

	public static void permute(int index, char[] elements, char[] perm, boolean[] used) {
		if (index == elements.length) {
			print(perm);
		} else {
			for (int i = 0; i < elements.length; i++) {
				if (!used[i]) {
					used[i] = true;
					perm[index] = elements[i];
					permute(index + 1, elements, perm, used);
					used[i] = false;
				}
			}
		}
	}

	private static void print(char[] perm) {
		System.out.println(new String(perm));

	}

}
