package hr;

import java.util.Arrays;
import java.util.Scanner;

public class RoadReform {

	/**
	 * @param args
	 */
	
	final static int inf = 999999;
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m= s.nextInt();
		
		int[][] graph = new int[n][n];
		
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], inf);
		}
		for (int i = 0; i < graph.length; i++) {
			int x= s.nextInt();
			int y = s.nextInt();
			int z = s.nextInt();
			
			graph[x-1][y-1] = graph[y-1][x-1] = z;
		}
		
		int[][] graph2 = new int[n][n];
		copyArray(graph, graph2);
		
		int acost = fwarshall(graph2);
		copyArray(graph, graph2);
//		System.out.println(acost);
//		for (int i = 0; i < graph.length; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
		
		int count =0;
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = i; j < graph.length; j++) {
				if(graph[i][j]!=inf){
					int t = graph[i][j];
					while(t!=1){
						graph2[i][j] = graph2[j][i] = --t;
						int cost = fwarshall(graph2);
						//System.out.println("i="+i+" j="+j+" t="+t+" total cost="+cost);
						//System.out.println(acost);
						if(cost<acost) {
							//System.out.println("i="+i+" j="+j+" t="+t+" total cost="+cost);
							count += t;
							copyArray(graph, graph2);
							break;
						}
						copyArray(graph, graph2);
					}
				}
			}
		}
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = i; j < graph.length; j++) {
				if(graph[i][j]==inf && i!=j){
					int t = acost;
					while(t!=1){
						graph2[i][j] = graph2[j][i] = --t;
						int cost = fwarshall(graph2);
						//System.out.println("i="+i+" j="+j+" t="+t+" total cost="+cost);
						//System.out.println(acost);
						if(cost<acost) {
							//System.out.println("i="+i+" j="+j+" t="+t+" total cost="+cost);
							count += t;
							copyArray(graph, graph2);
							break;
						}
						copyArray(graph, graph2);
					}
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static void copyArray(int[][] src, int[][] dest){
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src.length; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	
	public static int fwarshall(int[][] graph){
		
		for (int k = 0; k < graph.length; k++) {
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph.length; j++) {
					graph[i][j] = graph[i][j] > (graph[i][k] + graph[k][j]) ? graph[i][k] + graph[k][j] : graph[i][j];
				}
			}
		}
		
		//System.out.println(graph[0][graph.length-1]+"-----");
		return graph[0][graph.length-1];
		
	}

}
