package gfg; //uva

import java.util.ArrayList;
import java.util.Scanner;

public class SumItUp {

	/**
	 * @param args
	 */
	static ArrayList<String> result = new ArrayList<>();
	static int arr[];

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (true) {
			int t = s.nextInt();
			int n = s.nextInt();
			if (n == 0)
				break;
			arr = new int[n];
			result.clear();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}

			for (int i = 0; i < arr.length; i++) {
				generateResults(arr[i], t, i, "" + arr[i]);
			}

			System.out.println("Sums of " + t + ":");
			if (result.isEmpty()) {
				System.out.println("NONE");
			} else {
				for (int i = 0; i < result.size(); i++) {
					System.out.println(result.get(i));
				}
			}
		}
	}

	public static void generateResults(int sum, int t, int index, String res) {
		if (sum == t) {
			if (!result.contains(res)) {
				result.add(res);
			}
		}

		else if (sum > t)
			return;

		else {
			for (int i = index + 1; i < arr.length; i++) {
				generateResults(sum + arr[i], t, i, res + "+" + arr[i]);
			}
		}

	}

}
