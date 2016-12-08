package gfg;

public class HeapSort {

	public static void buildHeap(int[] arr) {
		int n = arr.length;
		for (int i = n / 2; i >= 0; i--) {
			minHeapify(arr, i);
		}
	}

	public static void minHeapify(int[] arr, int idx) {
		int n = arr.length;
		int smallest = arr[idx];
		if (2 * idx + 1 <= size && arr[2 * idx + 1] < smallest) {
			smallest = arr[2 * idx + 1];
		}
		if (2 * idx + 2 <= size && arr[2 * idx + 2] < smallest) {
			smallest = arr[2 * idx + 2];
		}

		if (smallest == arr[idx]) {
			return;
		} else if (smallest == arr[2 * idx + 1]) {
			swap(arr, idx, 2 * idx + 1);
			// System.out.println("2*idx+1"+(2*idx+1));
			minHeapify(arr, 2 * idx + 1);
		} else {
			swap(arr, idx, 2 * idx + 2);
			// System.out.println("2*idx+2"+(2*idx+2));
			minHeapify(arr, 2 * idx + 2);
		}
	}

	public static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	public static void heapSort(int[] arr) {

		while (size >= 0) {
			swap(arr, 0, size);
			System.out.println(arr[size]);
			size--;
			minHeapify(arr, 0);
		}

	}

	public static int size;

	public static void main(String[] args) {
		int[] arr = { 4, 2, 6, 8, 9, 12, 5, 6, 13 };
		size = arr.length - 1;
		buildHeap(arr);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.print(arr[i] + " ");
		// }
		heapSort(arr);
	}
}