package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FACUP {

	/**
	 * @param args
	 */
	static class ProbObject implements Comparable<ProbObject> {
		int idx;
		double prob;

		public ProbObject(int i, double p) {
			idx = i;
			prob = p;
		}

		@Override
		public int compareTo(ProbObject o) {
			if (this.prob > o.prob)
				return -1;
			else if (this.prob < o.prob)
				return 1;
			else {
				if (this.idx > o.idx)
					return 1;
				else
					return -1;
			}
		}

	}

	public static void main(String[] args) {

		MyScanner s = new MyScanner();
		int n = s.nextInt();
		int totalTeams = (int) Math.pow(2, n);
		double probArr[] = new double[totalTeams];
		double probArr2[] = new double[totalTeams];

		for (int i = 0; i < probArr.length; i++) {
			probArr[i] = 0;
			probArr2[i] = 1;
		}

		double[][] probMatrix = new double[totalTeams][totalTeams];

		for (int i = 0; i < totalTeams; i++) {
			for (int j = 0; j < totalTeams; j++) {
				double a = s.nextDouble();
				probMatrix[i][j] = (a / 100);
			}
		}

		ArrayList<Integer> teamInSteps[] = (ArrayList<Integer>[]) new ArrayList[totalTeams];

		for (int i = 0; i < teamInSteps.length; i++) {
			ArrayList<Integer> al = new ArrayList<>();
			al.add(i);
			teamInSteps[i] = al;
		}

		int end = totalTeams;

		int p = n;
		while (p > 0) {
			p--;
			for (int i = 0; i < end; i++) {
				if (i % 2 == 0) {
					for (int j = 0; j < teamInSteps[i].size(); j++) {
						int idx1 = teamInSteps[i].get(j);
						for (int j2 = 0; j2 < teamInSteps[i + 1].size(); j2++) {
							int idx2 = teamInSteps[i + 1].get(j2);
							probArr[idx1] += probArr2[idx1] * probArr2[idx2]
									* probMatrix[idx1][idx2];
						}
					}

				} else {

					for (int j = 0; j < teamInSteps[i].size(); j++) {
						int idx1 = teamInSteps[i].get(j);
						for (int j2 = 0; j2 < teamInSteps[i - 1].size(); j2++) {
							// System.out.println(idx1+" ");
							int idx2 = teamInSteps[i - 1].get(j2);
							probArr[idx1] += probArr2[idx1] * probArr2[idx2]
									* probMatrix[idx1][idx2];
						}
					}

				}
				if (i % 2 != 0) {
					teamInSteps[i - 1].addAll(teamInSteps[i]);
				}
			}
			// System.out.println();
			for (int i = 0; i < totalTeams; i++) {
				// System.out.print(probArr[i]+" ");
				probArr2[i] = probArr[i];
				probArr[i] = 0;
			}
			if (end > 1) {
				for (int i = 0; i < end / 2; i++) {
					teamInSteps[i] = teamInSteps[2 * i];
				}
			}

			end = end / 2;
		}

		ProbObject[] arr = new ProbObject[totalTeams];

		for (int i = 0; i < totalTeams; i++) {
			// System.out.println(probArr2[i]);
			ProbObject po = new ProbObject(i, probArr2[i]);
			arr[i] = po;
		}

		Arrays.sort(arr);

		for (int i = 0; i < totalTeams; i++) {
			// System.out.println(probArr2[i]);
			System.out.println(arr[i].idx + 1);
		}
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
