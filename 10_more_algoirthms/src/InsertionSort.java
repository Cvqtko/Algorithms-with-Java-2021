import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = {3,2,1,6,4,5};
		insertionSort(array);
		System.out.println(Arrays.toString(array));

	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int current = array[i];
			int j = i - 1;
			while (j >= 0 && current < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			// at this point we've exited, so j is either -1
			// or it's at the first element where current >= a[j]
			array[j + 1] = current;
		}
	}
}
