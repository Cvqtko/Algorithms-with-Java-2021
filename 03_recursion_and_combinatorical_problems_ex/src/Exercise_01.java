import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_01 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] elements = reader.readLine().split("\\s+");

		printReversed(elements, elements.length - 1);
	}

	private static void printReversed(String[] elements, int index) {
		if (index < 0) {
			return;
		}
		System.out.print(elements[index] + " ");
		printReversed(elements, index - 1);

	}
}
