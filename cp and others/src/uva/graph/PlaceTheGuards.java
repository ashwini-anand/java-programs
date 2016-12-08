package uva.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class PlaceTheGuards {

	/**
	 * @param args
	 */
	static class Graph {
		int index;
		int color = -1;
		ArrayList<Integer> neighbours = new ArrayList<>();
	}

	static boolean visited[];
	static Graph gph[];
	static int v;
	static int e;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			v = in.nextInt();
			e = in.nextInt();

			visited = new boolean[v];
			gph = new Graph[v];
			for (int i = 0; i < v; i++) {
				Graph g = new Graph();
				g.index = i;
				gph[i] = g;
			}
			for (int i = 0; i < e; i++) {
				int f = in.nextInt();
				int tt = in.nextInt();
				gph[f].neighbours.add(tt);
				gph[tt].neighbours.add(f);

			}

			LinkedList<Integer> queue = new LinkedList<>();
			boolean isPossible = true;
			int count = 0;
			for (int i1 = 0; i1 < v; i1++) {
				if (gph[i1].color == -1) {
					int total = 0;
					int count1 = 0;
					queue.add(i1);
					gph[i1].color = 1;
					while (!queue.isEmpty()) {
						total++;
						int k = queue.poll();
						if (gph[k].color == 1)
							count1++;
						for (int i = 0; i < gph[k].neighbours.size(); i++) {
							int j = gph[k].neighbours.get(i);
							if (gph[j].color == gph[k].color) {
								isPossible = false;
								break;
							} else {
								if (gph[j].color == -1) {
									gph[j].color = 1 - gph[k].color;
									queue.offer(j);
								}
							}
						}
						if (isPossible == false) {
							break;
						}
					}
					if (isPossible == false) {
						break;
					}
					if (total == 1) {
						count++;
					} else {
						count += Math.min(count1, total - count1);
					}
				}
			}
			if (isPossible == false) {
				System.out.println(-1);
			} else {
				System.out.println(count);
			}
		}
		in.close();

	}

}
