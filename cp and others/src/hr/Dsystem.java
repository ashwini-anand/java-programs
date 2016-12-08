package hr;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


class nodes2{
	int[] dist;
	public nodes2(){
	}
}
public class Dsystem {

	/**
	 * @param args
	 */
	public static nodes2[] ndarr;
	public static int[] arr;
	static int[] recstack;
	static int count;
	static boolean[] visited;
	static List<Integer> llist= new ArrayList<Integer>();
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		ndarr = new nodes2[n];
		arr = new int[k];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt()-1;
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			ndarr[i] = new nodes2();
			ndarr[i].dist = new int[n];
		}
		for (int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			ndarr[a-1].dist[b-1] = 1;
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(ndarr[i].dist));
//		}
		
		for (int i = 0; i < n; i++) {
			bfs(i);
		}
		recstack=new int[n];
		Arrays.fill(recstack,-1);
		visited = new boolean[n];
		
//		for (int i = 0; i < arr.length; i++) {
//			boolean bl = printResult(i);
//			if(bl==true) break;
//		}
		printResult();
//		for (int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(ndarr[i].dist));
//		}
		
		
		
	}
	
	public static void printResult(){
		for (int i = 0; i < arr.length; i++) {
			visited[arr[i]] = true; 
			if(&& ndarr[arr[x]].dist[arr[i+1]]!=0 && visited[arr[i]] == false){
				System.out.println("arr[x]="+arr[x]+" arr[i]="+arr[i]+" "+ndarr[arr[x]].dist[arr[i]]);
				printResult(i);
			}
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
					ndarr[v].dist[i] = ndarr[v].dist[s] + ndarr[s].dist[i];
					queue.add(i);
				}
			}
		}
		//System.out.println("v="+v+"  "+Arrays.toString(ndarr[v].dist1));
	}

}
