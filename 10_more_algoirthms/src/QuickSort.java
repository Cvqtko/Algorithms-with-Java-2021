import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] array = { 3, 2, 1, 6, 4, 5 };
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}

	static int partition(int[] array, int begin, int end) {
		int pivot = end;

		int counter = begin;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[pivot]) {
				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[counter];
		array[counter] = temp;

		return counter;
	}

	public static void quickSort(int[] array, int begin, int end) {
		if (end <= begin)
			return;
		int pivot = partition(array, begin, end);
		quickSort(array, begin, pivot - 1);
		quickSort(array, pivot + 1, end);
	}
}
