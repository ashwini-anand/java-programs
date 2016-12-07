package apac;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class StoreCredit {

	/**
	 * @param args
	 */
	static class Pair implements Comparable<Pair>{
		int val;
		int idx;
		
		Pair(int v, int i){
			val = v;
			idx =i;
		}
		
		public int compareTo(Pair p){
			return this.val - p.val;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int t =0;
		PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\anu\\Desktop\\to be deleted\\apac test cases\\A_Large2.txt"));
		System.setOut(out);
		while(n-- >0){
			t++;
			int c = in.nextInt();
			int len = in.nextInt();
			Pair[] arr = new Pair[len];
			for(int i=0; i<len; i++){
				int p = in.nextInt();
				arr[i] = new Pair(p,i);
			}
			Arrays.sort(arr);
			int start = 0;
			int end = len-1;
			while(start < end){
				if(arr[start].val + arr[end].val == c){
					break;
				}
				else if(arr[start].val + arr[end].val > c){
					end--;
				}else{
					start++;
				}
			}
			int s =arr[start].idx;
			int e =arr[end].idx;
			
			if(s > e){
				int tmp = s;
				s =e;
				e =tmp;
			}
			System.out.println("Case #"+t+": "+(s+1)+" "+(e+1));
			
		}

	}

}
