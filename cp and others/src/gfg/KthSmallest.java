package gfg;

import java.util.Scanner;

public class KthSmallest {

	/**
	 * @param args
	 */
	public static int kthsmallest(int arr[], int l, int r, int k) {
		if (k > 0 && k <= r - l + 1) {
			int pos = partition(arr, l, r);
			if (pos - l == k-1) return arr[pos];
			if(pos-l > k-1) return kthsmallest(	arr, l, pos-1, k);
			else
				return kthsmallest(arr, pos+1, r, k-(pos-l+1));
		}
		return Integer.MAX_VALUE;

	}

	public static int partition(int arr[], int l, int r) {
		int x= arr[r];
		int i =l;
		for (int j = l; j <= r-1; j++) {
			if(arr[j] <= x){
				swap(arr,j,i);
				i++;
			}
		}
		swap(arr,i,r);
		return i;

	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a[] = { 12, 3, 5, 7, 4, 19, 26 };
		int n = a.length;
		int k = s.nextInt();
		int x = kthsmallest(a, 0, n - 1, k);
		System.out.println(k+"thsmallest is " + x);
	}

}
