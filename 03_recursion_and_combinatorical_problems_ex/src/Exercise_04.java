import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_04 {

	public static StringBuilder out = new StringBuilder();
	public static Deque<Integer> source = new ArrayDeque<Integer>();
	public static Deque<Integer> spare = new ArrayDeque<Integer>();
	public static Deque<Integer> destination = new ArrayDeque<Integer>();
	public static int steps = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int disc = Integer.parseInt(reader.readLine());

		for (int i = disc; i > 0; i--) {
			source.push(i);
		}

		printRods();
		solve(disc, source, destination, spare);
		System.out.println(out);
	}

	private static void solve(int disc, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
		if (disc == 1) {
			destination.push(source.pop());
			out.append("Step #")
				.append(steps++)
				.append(": Moved disk")
				.append(System.lineSeparator());
			printRods();
		} else {
			solve(disc - 1, source, spare, destination);
			solve(1, source, destination, spare);
			solve(disc - 1, spare, destination, source);
		}

	}

	private static void printRods() {
		out.append(String.format("Source: %s\r\nDestination: %s\r\nSpare: %s\r\n",
				formatRod(source), formatRod(destination), formatRod(spare))).append(System.lineSeparator());
	}

	private static String formatRod(Deque<Integer> stack) {

		return stack.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(", "));
	}
}
