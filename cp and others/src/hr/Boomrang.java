package hr;

import java.util.*;
import java.util.Scanner;

public class Boomrang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			List<Integer> al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				al.add(i+1);
			}
			int i =0;
			while(true){
				if(al.size() ==1){
					System.out.println(al.get(0));
					break;
				}
				if(al.size()%2==0){
					//System.out.println(al.get(((al.size()/2)+i)%al.size()));
					int j =i+1;
					if((al.size()/2+i)%al.size() < i){
						j=i;
					}
					al.remove((al.size()/2+i)%al.size());
					i=j;
				}else{
					//System.out.println(al.get(i));
					al.remove(i);
				}
				if(i>= al.size()) i=0;
			}
		}
	}

}
