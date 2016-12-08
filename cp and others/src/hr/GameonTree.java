package hr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Node {
	int index;
	long token;

	public Node(int i, int t) {
		index = i;
		token = t;
	}
}

public class GameonTree {

	/**
	 * @param args
	 */
	final static int inf = 9999;
	static int[][] graph;
	static boolean visited[];
	static long maxsum = 0;
	static long tempsum = 0;
	static int maxsumindex = -1;
	static Node[] nodes;
	static Stack<Integer> st = new Stack<Integer>();
	static List<Integer> maxsumnodes = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		graph = new int[n][n];
		visited = new boolean[n];
		nodes=new Node[n];
		
		for (int i = 0; i < nodes.length; i++) {
			int x = s.nextInt();
			nodes[i] = new Node(i,x);
		}
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], inf);
		}
		for (int i = 0; i < n-1; i++) {
			int in = s.nextInt();
			int out = s.nextInt();
			graph[in-1][out-1]= graph[out-1][in-1] = 1;
		}
		dfs(0);
		//System.out.println(maxsumindex+" "+maxsum);
		maxsum =0;
		int i=maxsumindex;
		Arrays.fill(visited, false);
		dfsutil2(i);
		//System.out.println(maxsumnodes.toString());
		long sum =0;
		for (int j = 0; j < maxsumnodes.size(); j++) {
			sum+=nodes[maxsumnodes.get(j)].token;
		}
		long total =sum;
		//System.out.println(total);
		//long half = sum%2 ==0? sum/2: (sum/2)+1;
		long half = (sum/2)+1;
		sum=0;
		int j =0;
		for (j = 0; j < maxsumnodes.size(); j++) {
			sum+=nodes[maxsumnodes.get(j)].token;
			if(sum >= half) break;
		}
		long res =  sum > (total-sum+nodes[maxsumnodes.get(j)].token)?(total-sum+nodes[maxsumnodes.get(j)].token):sum;
		System.out.println(res);
	}

	public static void dfs(int v) {
		int count = 0;
		for (int i = v; count < visited.length; i = (i + 1) % visited.length) {
			count++;
			if (!visited[i]) {
				dfsutil(i);
			}
		}
	}

	public static void dfsutil(int i) {
		visited[i] = true;
		// System.out.println(i+" ");
        tempsum = tempsum+nodes[i].token;
        if(tempsum > maxsum) {
        	maxsum = tempsum;
        	maxsumindex = i;
        }
		for (int j = 0; j < visited.length; j++) {
			if (!visited[j] && graph[i][j] != inf) {

				// System.out.println(i+" "+j+" "+graph[i][j]);
				// System.out.println(j+" ");
				dfsutil(j);
			}
		}
		tempsum = tempsum-nodes[i].token;
	}
	
	public static void dfsutil2(int i) {
		visited[i] = true;
		// System.out.println(i+" ");
		st.push(i);
        tempsum = tempsum+nodes[i].token;
        //System.out.println(tempsum+" "+maxsum);
        if(tempsum > maxsum) {
        	maxsum = tempsum;
        	maxsumindex = i;
        	maxsumnodes.clear();
        	//System.out.println(st.toString());
        	maxsumnodes.addAll(st);
        }
		for (int j = 0; j < visited.length; j++) {
			if (!visited[j] && graph[i][j] != inf) {

				// System.out.println(i+" "+j+" "+graph[i][j]);
				// System.out.println(j+" ");
				dfsutil2(j);
			}
		}
		tempsum = tempsum-nodes[i].token;
		st.pop();
	}
}
