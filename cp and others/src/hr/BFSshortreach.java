package hr;

import java.io.*;
import java.util.*;
import java.util.List;

public class BFSshortreach {

	/**
	 * @param args
	 */

	static class nodes {
		int index = -1;
		nodes parent = null;
		int distance = Integer.MAX_VALUE;
		List<nodes> adj = new LinkedList<nodes>();
	}

	static class graph {
		nodes[] nodes;

		graph(int n) {
			nodes = new nodes[n];
		}
	}

	public static PrintWriter out;
	public static void main(String[] args) {

		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = s.nextInt();
		while (t > 0) {
			t--;
			int numOfnodes = s.nextInt();
			graph g = new graph(numOfnodes);

			for (int i = 0; i < numOfnodes; i++) {
				g.nodes[i] = new nodes();
				g.nodes[i].index = i;
			}

			int numOfEdges = s.nextInt();

			for (int i = 0; i < numOfEdges; i++) {
				int u = s.nextInt();
				int v = s.nextInt();
				g.nodes[u - 1].adj.add(g.nodes[v - 1]);
				g.nodes[v - 1].adj.add(g.nodes[u - 1]);
			}

			int start = s.nextInt();
			bfs(g, g.nodes[start - 1]);

			for (int i = 0; i < numOfnodes; i++) {
				if (i != start - 1) {
					if (g.nodes[i].distance != Integer.MAX_VALUE) {
						out.print(g.nodes[i].distance
								* 6 + " ");
					} else {
						out.print(-1+" ");
					}
				}
			}
			out.println();
		}

		out.close();
	}

	public static void bfs(graph g, nodes n) {
		LinkedList<nodes> queue = new LinkedList<nodes>();
		boolean[] visited = new boolean[g.nodes.length];

		queue.add(n);
		n.distance = 0;
		visited[n.index] = true;

		while (queue.isEmpty() == false) {
			nodes s = queue.poll();
			// System.out.print(s.index + " ");
			for (int i = 0; i < s.adj.size(); i++) {
				if (!visited[s.adj.get(i).index]) {
					visited[s.adj.get(i).index] = true;
					s.adj.get(i).parent = s;
					s.adj.get(i).distance = s.distance + 1;
					queue.add(s.adj.get(i));
				}
			}
		}
	}

	static class MyScanner {
		   static BufferedReader br;
		   static StringTokenizer st;

		   public MyScanner() {
		      br = new BufferedReader(new InputStreamReader(System.in));
		   }

		    String  next() {
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

		    String nextLine(){
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
