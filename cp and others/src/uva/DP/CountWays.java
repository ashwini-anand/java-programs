package uva.DP;
import java.util.*;

public class CountWays {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] arr = { 1, 5, 10, 25, 50 };
		while (in.hasNextInt()) {
			int n = in.nextInt();
			// System.out.println(n);
			long table[] = new long[n + 1];
			table[0] = 1;
			for (int i = 0; i < 5; i++) {
				for (int j = arr[i]; j <= n; j++) {
					table[j] = table[j] + table[j - arr[i]];
				}
			}
			if (table[n] == 1) {
				System.out.println("There is only 1 way to produce " + n
						+ " cents change.");
			} else {
				System.out.println("There are " + table[n]
						+ " ways to produce " + n + " cents change.");
			}
		}

	}
}
