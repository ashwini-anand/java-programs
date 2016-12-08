package geeksforgeeks;

import java.util.*;

public class RotatedSearch {

	public static int[] arr;
	public static int key;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();

		}
		
//		ArrayList<Integer> al = new ArrayList<>();
//		Integer[] aa = new Integer[al.size()];
//		
//		al.toArray(aa);
//		
//		for (int i = 0; i < aa.length; i++) {
//			aa[i] = al.get(i);
//		}
		
		
		key = in.nextInt();
		int res = -1;
		int pivot = -1;
		if (n == 1) {
			if (key == arr[0])
				res = 0;
		} else if (n == 2) {
			if (key == arr[0])
				res = 0;
			else if (key == arr[1])
				res = 1;
			else
				res = -1;
		} else if (arr[0] < arr[n - 1]) {
			res = binarySearch1(0, n - 1);
		} else {
			pivot = findPivot(0, n - 1);
			if (key < arr[n - 1])
				res = binarySearch1(pivot, n - 1);
			else {
				// System.out.println(arr[0]);
				// System.out.println(arr[pivot-1]);
				res = binarySearch1(0, pivot - 1);
			}

		}
		// System.out.println(pivot);
		System.out.println(res);
	}

	public static int findPivot(int l, int m) {
		int mid = (l + m) / 2;
		int n = arr.length;
		if (l == m)
			return l;
		if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid])
			return mid;
		if (arr[mid] >= arr[n - 1]) {
			return findPivot(mid + 1, m);
		} else {
			return findPivot(l, mid - 1);
		}

	}

	public static int binarySearch1(int l, int m) {

		if (l <= m) {
			int mid = (l + m) / 2;
			//System.out.println(arr[mid]);
			if (arr[mid] == key) {
				//System.out.println(arr[mid]);
				//System.out.println(mid);
				return mid;
			} else if (arr[mid] < key) {
				return binarySearch1(mid + 1, m);
			} else {
				return binarySearch1(l, mid - 1);
			}

		}

		else return -1;

	}

	public static int binarySearch2(int l, int m) {

		if (l <= m) {
			int mid = (l + m) / 2;
			if (arr[mid] == key)
				return mid;
			else if (arr[mid] < key) {
				return binarySearch2(l, mid - 1);
			} else {
				return binarySearch2(mid + 1, m);
			}

		}

		return -1;

	}

}