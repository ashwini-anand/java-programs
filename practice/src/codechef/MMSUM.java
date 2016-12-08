package codechef;

/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
public class MMSUM {
	public static int arr[];

	public static void main(String[] args) throws java.lang.Exception {
		MyScanner in = new MyScanner();
		int t = in.nextInt();

		while (t-- > 0) {

			int n = in.nextInt();
			arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}

			long global_max = kadane();
			long tmpGlobal = global_max;

			int count = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] < 0) {
					count++;
				}
			}
			if (count == arr.length) {
				System.out.println(tmpGlobal);
				continue;
			}

			for (int i = 0; i < arr.length; i++) {

				if (arr[i] < 0) {
					// count++;
					int temp = arr[i];
					arr[i] = 0;
					long temp_max = kadane();
					global_max = global_max > temp_max ? global_max : temp_max;
					arr[i] = temp;
				}

			}

			System.out.println(global_max);
		}

	}

	public static long kadane() {
		long cur_max = arr[0];
		long max_so_far = arr[0];
		for (int i = 1; i < arr.length; i++) {
			// cur_max = Math.max(arr[i],arr[i]+cur_max);
			cur_max = arr[i] > arr[i] + cur_max ? arr[i] : arr[i] + cur_max;
			// max_so_far = Math.max(max_so_far,cur_max);
			max_so_far = max_so_far > cur_max ? max_so_far : cur_max;
		}

		return max_so_far;

	}
	
	
	static class MyScanner {
		static BufferedReader br;
		static StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
}
