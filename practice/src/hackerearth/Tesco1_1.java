package hackerearth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Tesco1_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int m = Integer.parseInt(in.next());
		String str = in.next();
		ArrayList<Character> stack = new ArrayList<Character>();
		//char[] carr = str.toCharArray();
		int j=m;
		int i =0;
		for(i=0; i< str.length() && j>0; ){
			if(stack.isEmpty()){
				stack.add(str.charAt(i));
				i++;
				continue;
			}
			char cc = stack.get(stack.size()-1);
			int diff = (int)(str.charAt(i)-cc);
			if(diff >0){
				stack.remove(stack.size()-1);
				j--;
			}else{
				stack.add(str.charAt(i));
				i++;
			}
		}
		StringBuilder res = new StringBuilder();
		if(j >0){
			//System.out.println("here1");
			for(int k=0; k<stack.size()-j; k++){
				res.append(stack.get(k));
			}
			System.out.println(res);
		}else{
			//System.out.println("here2");
			for(int k=0; k<stack.size(); k++){
				res.append(stack.get(k));
			}
			res.append(str.substring(i));
			System.out.println(res);
		}

	}

}
