package hackerearth;

import java.util.*;
public class Tesco1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int m = Integer.parseInt(in.next());
		String str = in.next();
		LinkedList<Character> stack = new LinkedList<Character>();
		char[] carr = str.toCharArray();
		int j=m;
		int i =0;
		for(i=0; i< carr.length && j>0; ){
			if(stack.isEmpty()){
				stack.addLast(carr[i]);
				i++;
				continue;
			}
			char cc = stack.getLast();
			int diff = (int)(carr[i]-cc);
			if(diff >0){
				stack.removeLast();
				j--;
			}else{
				stack.addLast(carr[i]);
				i++;
			}
		}
		String res = "";
		if(j >0){
			//System.out.println("here1");
			for(int k=stack.size()-1; k>=0; k--){
				if(j>0){
					j--;
				}else{
					res = stack.get(k) + res;
				}
			}
			System.out.println(res);
		}else{
			//System.out.println("here2");
			for(int k=0; k<stack.size(); k++){
				res = res+stack.get(k);
			}
			for( ; i<carr.length; i++){
				res = res + carr[i];
			}
			System.out.println(res);
		}

	}

}
