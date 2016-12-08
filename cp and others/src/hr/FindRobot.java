package hr;

import java.util.Scanner;

public class FindRobot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		while(t>0){
			t--;
			int m = s.nextInt();
			
			if(m%4==0){
				System.out.println(-(m/2)+" "+(-(m/2)));
			}else{
				int temp =m;
				while(temp%4 != 0) temp--;
				if(m-temp == 1) System.out.println(((temp/2)+1)+" "+(-(temp/2)));
				else if(m-temp == 2) System.out.println(((temp/2)+1)+" "+((temp/2)+2));
				else if(m-temp == 3) System.out.println(-((temp/2)+2)+" "+((temp/2)+2));
			}
		}
	}

}
