package hr;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

class nodes1{
	int[] dist;
	int[] dist1;
	public nodes1(){
	}
}


public class Wccity {

	/**
	 * @param args
	 */
	public static nodes1[] ndarr;
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int t = s.nextInt();
		ndarr = new nodes1[n];
		for (int i = 0; i < n; i++) {
			ndarr[i] = new nodes1();
			ndarr[i].dist = new int[n];
			ndarr[i].dist1 = new int[n];
		}
		
		for (int i = 0; i < n-1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int c= s.nextInt();
			ndarr[a-1].dist[b-1] = c;
			ndarr[b-1].dist[a-1] = c;
			ndarr[a-1].dist1[b-1] = c;
			ndarr[b-1].dist1[a-1] = c;
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(ndarr[i].dist));
//		}
		
		for (int i = 0; i < n; i++) {
			bfs(i);
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(ndarr[i].dist));
//		}
		
		for (int i = 0; i < t; i++) {
			int k = s.nextInt();
			int arr[] = new int[k];
			for (int j = 0; j < k; j++) {
				arr[j]=s.nextInt()-1;
			}
			//System.out.println(Arrays.toString(arr));
			BigInteger sum= BigInteger.valueOf(0);;
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = j+1; j2 < arr.length; j2++) {
					//System.out.println(ndarr[arr[j]].dist[arr[j2]]);
					sum = sum.add(BigInteger.valueOf(ndarr[arr[j]].dist1[arr[j2]]));
				}
			}
			System.out.println(sum);
		}
	}
	
	public static void bfs(int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited=new boolean[ndarr.length];
		int n = ndarr.length;
		queue.add(v);
		visited[v] = true;
       // System.out.println("here1-----");
		while (queue.isEmpty() == false) {
			int s = queue.poll();
			//System.out.println("here2-----");
			for (int i = 0; i < n; i++) {
				//System.out.println("here3-----");
				if (!visited[i] && ndarr[s].dist[i]!=0) {
					//System.out.println("here4-----");
					visited[i] = true;
					ndarr[v].dist1[i] = ndarr[v].dist1[s] + ndarr[s].dist1[i];
					queue.add(i);
				}
			}
		}
		//System.out.println("v="+v+"  "+Arrays.toString(ndarr[v].dist1));
	}

}
