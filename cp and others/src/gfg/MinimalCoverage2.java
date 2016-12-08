package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimalCoverage2 {

	/**
	 * @param args
	 */
	static class Lines implements Comparable<Lines> {

		int l;
		int r;

		public Lines(int le, int ri) {
			l = le;
			r = ri;
		}

		@Override
		public int compareTo(Lines o) {
			if (this.l > o.l) {
				return 1;
			} else if (this.l < o.l) {
				return -1;
			} else {
				return o.r - this.r;
			}
		}

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {
			t--;
			int m = s.nextInt();
			int l = -1, r = -1, max = 0;
			ArrayList<Lines> al = new ArrayList<>();
			while (true) {
				l = s.nextInt();
				r = s.nextInt();
				if (r > max) {
					max = r;
				}
				if (l == 0 && r == 0) {
					// System.out.println(l+" "+r);
					break;
				}
				Lines line = new Lines(l, r);
				al.add(line);
			}

			Collections.sort(al);
			if (m > max || 0 < al.get(0).l) {
				// System.out.println(al.get(al.size()-1).r+" "+al.get(0).l);
				System.out.println(0);
				System.out.println(); // print line after every o/p
				continue;
			}

			// for (int i = 0; i < al.size(); i++) {
			// System.out.println(al.get(i).l+" "+al.get(i).r);
			// }

			int flag = 0;
			ArrayList<Lines> re = new ArrayList<>();
			int k = 0;
			int startValue = al.get(0).l;
			int endValue = al.get(0).r;
			if (endValue >= m) {
				System.out.println(1);
				System.out.println(startValue + " " + endValue);
				System.out.println();
				continue;
			}

			int count = 0;
			for (int i = 0; i < al.size(); i++, count++) {

				if (al.get(i).l <= k && al.get(i).r > endValue) {
					endValue = al.get(i).r;
					startValue = al.get(i).l;
					if (endValue >= m) {
						Lines ll = new Lines(startValue, endValue);
						re.add(ll);
						break;
					}
				}

				if (((i != al.size() - 1) && al.get(i + 1).l > k)) {
					Lines ll = new Lines(startValue, endValue);
					re.add(ll);
					k = endValue;
					if (endValue >= m)
						break;
					if (al.get(i + 1).l > k) {
						flag = 1;
						// System.out.println(al.get(i+1).l+" "+k+"here "+i);
						System.out.println(0);
						System.out.println();
						break;
					}
				}

			}

			// if(count==al.size()-1 && re.get(re.size()-1).r < m){
			// re.add(new Lines(startValue,endValue));
			// }

			if (flag == 1) {
				continue;
			}

			System.out.println(re.size());

			for (int i = 0; i < re.size(); i++) {
				System.out.println(re.get(i).l + " " + re.get(i).r);
			}

			System.out.println();

		}
	}

}
