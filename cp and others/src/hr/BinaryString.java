package hr;

import java.util.Scanner;

public class BinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		int interval = s.nextInt();
		int ops = s.nextInt();
		
		s.nextLine();
		String str = s.nextLine();
		char[] charArray = str.toCharArray();
		
		int count =0;
		
			
			for (int i = 0; i < charArray.length; i++) {
				if(charArray[i] == '1' && (i-interval) >=0 && count != ops) {
					int j =i;
					while((j-interval) >=0 && count != ops){
						char t= charArray[j];
						charArray[j] = charArray[j-interval];
						charArray[j-interval] = t;
						count++;
						j = (j-interval);
					}
				}
				if(count == ops){
					break;
				}
			}
			
		System.out.println(charArray);
	}

}
