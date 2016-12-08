package gfg;

import java.util.Scanner;
import java.util.TreeSet;

public class CodegrndDS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		int c = s.nextInt();
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < c; i++) {
			String str = s.next();
			if (str.equals("PUT")) {
				int a = s.nextInt();
				//System.out.println(a + "in");
				if (!ts.contains(a)) {
					if (ts.size() >= k) {
						ts.pollFirst();
					}
					ts.add(a);
				}
			} else {
				//System.out.println(ts.last());
				ts.pollLast();
			}
		}
		System.out.print(ts.size());
		for (Integer element : ts) {
			System.out.print(" " + element);
		}
	}

}
