package hr;

import java.util.Scanner;

public class FlatlandSpaceSt {

	/**
	 * @param args
	 */
//	static class City{
//		
//	}
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		boolean spst[] = new boolean[n];
		int dist[] = new int[n];
		
		for (int i = 0; i < m; i++) {
			spst[s.nextInt()] = true;
		}
		
		int distance = 100002;
		for (int i = 0; i < dist.length; i++) {
			if(spst[i]){
				distance = 0;
				dist[i] = distance;
			}else{
				distance = distance + 1;
				dist[i] = distance;
			}
		}
		
		distance = 100002;
		for (int i = dist.length-1; i >=0; i--) {
			if(spst[i]){
				distance = 0;
				dist[i] = distance;
			}else{
				distance = distance + 1;
				if(distance < dist[i]){
					dist[i] = distance;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < dist.length; i++) {
			if(max < dist[i]){
				max = dist[i];
			}
		}
		System.out.println(max);

	}

}
