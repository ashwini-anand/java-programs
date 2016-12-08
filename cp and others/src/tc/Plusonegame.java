package tc;

import java.util.ArrayList;
import java.util.Collections;

public class Plusonegame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getorder("1++"));
//		System.out.println(getorder("549"));
//		System.out.println(getorder("++++++"));
//		System.out.println(getorder("+++++2+"));
//		System.out.println(getorder("++++4++++200++2++1+6++++++"));
//		System.out.println(getorder("++11199999"));
//		System.out.println(getorder("10"));
//		System.out.println(getorder("0+11119"));

	}
	
	public static  String getorder(String s){
		
		ArrayList<Integer> al = new ArrayList<>();
		int plusCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='+'){
				plusCount++;
			}else{
//				al.add(Integer.parseInt(s.substring(i, i+1)));
				al.add(s.charAt(i)-'0');
			}
		}
		
		Collections.sort(al);
		String res = "";
		//System.out.println(al.toString());
		int currentCount =0;
		
		for (int i = 0; i < al.size(); i++) {
			if(currentCount==plusCount){
				for (int j = i; j < al.size(); j++) {
					res = res + al.get(j);
				}
				break;
			}
			if(al.get(i)==currentCount){
				res = res + al.get(i);
			}else if(al.get(i)>currentCount){
				int k =currentCount;
				String temp ="";
				for (int j = 0; j < al.get(i)-k; j++) {
					temp = temp + "+";
					currentCount++;
					if(currentCount == plusCount){
						break;
					}
					
				}
				res = res + temp + al.get(i);
			}
		}
		//System.out.println(currentCount);
		if(currentCount < plusCount){
			String temp = "";
			for (int i = 0; i < plusCount-currentCount; i++) {
				temp = temp + "+";
			}
			res = res + temp;
			
		}
		
		
		return res;
		
	}

}
