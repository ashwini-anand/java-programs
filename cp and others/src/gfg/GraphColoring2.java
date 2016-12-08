package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GraphColoring2 {

	/**
	 * @param args
	 */
	static ArrayList<Integer> vertal;
	static ArrayList<Integer>[] varr;
	static ArrayList<Integer> result;

	static ArrayList<Integer> giveResult(ArrayList<Integer> al) {
		if (al.size() == 0) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> altmp = new ArrayList<>();
		for (int i = 0; i < al.size(); i++) {
			ArrayList<Integer> al1 = new ArrayList<>();
			al1.addAll(al);
			al1.removeAll(varr[al.get(i)]);
			ArrayList<Integer> altmp2 = giveResult(al1);
			altmp2.add(al.get(i));
			if (altmp.size() < altmp2.size()) {
				altmp.clear();
				// altmp.add(i);
				altmp.addAll(altmp2);
			}
		}
		return altmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();

		while (m > 0) {
			m--;
			int n = s.nextInt();
			int k = s.nextInt();
			vertal = new ArrayList<>();
			result = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				vertal.add(i + 1);
			}

			varr = (ArrayList<Integer>[]) new ArrayList[n + 1];

			for (int i = 0; i <= n; i++) {
				varr[i] = new ArrayList<>();
				varr[i].add(i);
			}

			for (int i = 0; i < k; i++) {
				int e1 = s.nextInt();
				int e2 = s.nextInt();
				varr[e1].add(e2);
				varr[e2].add(e1);
			}

			result = new ArrayList<>();
			result = giveResult(vertal);

			System.out.println(result.size());
			Collections.sort(result);
			for (int i = 0; i < result.size() - 1; i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println(result.get(result.size() - 1));

		}

	}

}
