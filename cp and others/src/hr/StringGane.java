package hr;

import java.util.Scanner;

public class StringGane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		s.nextLine();
		while(t>0){
			t--;
			String ss = s.nextLine();
			char[] charArray = ss.toCharArray();
			int count =0;
			boolean flag = true;
			while(flag){
				flag = false;
				for (int i = 0; i < ss.length(); i++) {
					if(charArray[i]!='a'){
						charArray[i] = (char) (charArray[i] - 1);
						count++;
						flag = true;
					}
				}
			
			}
			
			if(count%2==0) System.out.println("Bob");
			else System.out.println("Alice");
		}

	}

}
