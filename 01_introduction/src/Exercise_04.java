import java.util.Scanner;

public class Exercise_04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		System.out.println(calculateFactorial(number));
	}

	public static long calculateFactorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * calculateFactorial(n - 1);
	}
}
