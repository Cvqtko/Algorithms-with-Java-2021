
public class Recursion {
	static int count = 0;

	public static void main(String[] args) {
		recursionOne();
		recursionTwo(0);
	}

	static void recursionOne() {
		count++;
		if (count == 5) {
			return;
		} else {
			System.out.println("hello " + count);
			recursionOne();
		}
	}

	static void recursionTwo(int count) {
		if (count == 5) {
			return;
		} else {
			System.out.println("hello " + count);
			count++;
			recursionTwo(count);
		}
	}
}