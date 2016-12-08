package gfg;
//http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
//Java program for maximum contiguous circular sum problem
import java.io.*;
import java.util.*;

class MaxCircularSum {
	// The function returns maximum circular contiguous sum
	// in a[]
	static int maxCircularSum(int a[]) {
		int n = a.length;

		// Case 1: get the maximum sum using standard kadane'
		// s algorithm
		int max_kadane = kadane(a);

		// Case 2: Now find the maximum sum that includes
		// corner elements.
		int max_wrap = 0;
		for (int i = 0; i < n; i++) {
			max_wrap += a[i]; // Calculate array-sum
			a[i] = -a[i]; // invert the array (change sign)
		}

		// max sum with corner elements will be:
		// array-sum - (-max subarray sum of inverted array)
		max_wrap = max_wrap + kadane(a);

		// The maximum circular sum will be maximum of two sums
		return (max_wrap > max_kadane) ? max_wrap : max_kadane;
	}

	// Standard Kadane's algorithm to find maximum subarray sum
	// See http://www.geeksforgeeks.org/archives/576 for details
	static int kadane(int a[]) {
		int n = a.length;
		int max_so_far = 0, max_ending_here = 0;
		for (int i = 0; i < n; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	public static int kadane1(int[] arr) {
		int maxGlobal = arr[0];

		for (int i = 0; i < arr.length; i++) {
			int maxCurrent = arr[i];
			for (int j = (i + 1) % arr.length, j2 = 0; j2 < arr.length-1; j2++, j = (j + 1)
					% arr.length) {
				maxCurrent = Math.max(arr[j], maxCurrent + arr[j]);
				maxGlobal = Math.max(maxGlobal, maxCurrent);
			}
		}
		return maxGlobal;
	}

	public static void main(String[] args) {
		// int a[] = {-11, -10, -20, -5, -3, -5, -8, -13, -10};
		int a[] = { 8, -8, 9, -9, 10, -11, 12 };
		 System.out.println("Maximum circular sum is " +
		 maxCircularSum(a));
		//System.out.println("Maximum circular sum is " + kadane1(a));
	}
} /* This code is contributed by Devesh Agrawal */
