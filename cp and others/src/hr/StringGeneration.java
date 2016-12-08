package hr;

import java.util.Arrays;
import java.util.Scanner;

public class StringGeneration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner s  = new Scanner(System.in);
		
		int t= s.nextInt();
		
		while(t>0){
			t--;
			int n= s.nextInt();
			int k = s.nextInt();
			char[] str = new char[n];
			int i =0;
			k = k > 26 ? 26:k;
			if(k%2==0){
				if(n<(k+k/2)){
					System.out.println("No such string.");
					continue;
				}
			}else{
				int o=k/2;
				int e = k-o;
				if(n<(2*o+e)){
					System.out.println("No such string.");
					continue;
				}
				
			}
			
		//	k = k > n ? n :k;
			int count = 0;
			boolean flag = false;
			for (i = 0; i < n; ) {
				if(count%2==0){
					str[i] = (char) ('a' + count);
					i++;
				}else{
					str[i] = (char) ('a' + count);
					i++;
					if(!(i<n)){
						flag = true;
						break;
					}
					str[i] = (char) ('a' + count);
					i++;
				}
				count++;
				//System.out.println(count);
				if(!(count < k)) break;
				//System.out.println(str[i]);
			}
			
			if(flag) {
				System.out.println("No such string.");
				continue;
			}
			if((n-i)%2==0){
				for (; i < str.length; i++) {
					str[i] = 'a';
				}
			}else{
				System.out.println("No such string.");
				continue;
			}
			
			Arrays.sort(str);
			System.out.println(str);
		
	 }

	}

}
