package gfg;
import java.util.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class MinPlatforms {
    
    static class Schedule implements Comparable<Schedule>{
        int time;
        boolean isArrival;
        
        public Schedule(int t, boolean b){
            time = t;
            isArrival = b;
        }

		@Override
		public int compareTo(Schedule arg0) {
			return this.time - arg0.time;
		}
        
    }
    
	public static void main (String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			int n = in.nextInt();
			Schedule sarr[] = new Schedule[2*n];
			for(int i=0; i<n; i++){
				sarr[i] = new Schedule(in.nextInt(), true);
			}
			for(int i=n; i<2*n;i++){
				sarr[i] = new Schedule(in.nextInt(), false);
			}
			
			Arrays.sort(sarr);
			
			int count =0;
			int max = count;
			
			for(int i=0; i<2*n;i++){
				if(sarr[i].isArrival){
					count++;
					if(max < count){
						max = count;
					}
				}else{
					count--;
				}
			}
			
			System.out.println(max);
			
		}
	}
}
