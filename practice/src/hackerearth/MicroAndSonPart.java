package hackerearth;

import java.util.HashSet;

public class MicroAndSonPart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> hset = new HashSet<>();
		hset.add(0);
		
		int count =0;
		for(int i=1; i<2360; i++){
			count++;
			if(count==60){
				count =0;
				i = i+40;
			}
			//System.out.print(i+" ");
			String str = String.valueOf(i);
			if(str.length() == 1){
				str = "000"+str;
			}else if(str.length() == 2){
				str = "00"+str;
			}else if(str.length() == 3){
				str = "0"+str;
			}
			if(isPalindrome(str)){
				hset.add(i);
			}
		}
		
		System.out.print("{");
		for(Integer i : hset){
			System.out.print(i+", ");
		}
		System.out.print("}");

	}

	static boolean isPalindrome(String str) {
		if(str.length() == 1){
			return true;
		}
		if((str.charAt(0) == str.charAt(3)) &&(str.charAt(1) == str.charAt(2))){
			return true;
		}
		return false;
	}

}
