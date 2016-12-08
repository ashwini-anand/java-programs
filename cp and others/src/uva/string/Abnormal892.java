package uva.string;

import java.util.*;

public class Abnormal892 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- >0){
            String s = in.next();
            if(s.length()==1){
                System.out.println("palindrome");
                continue;
            }
            String s2 = s+s;
            String rev = new StringBuilder(s).reverse().toString();
            int idx = s2.indexOf(rev,1);
            if(idx != -1 && idx != (s2.length()/2)){
            	System.out.println("alindrome"); 
                continue;
            }
            char[] sarr = s.toCharArray();
            if(isPalindrome(sarr)){
                System.out.println("palindrome"); 
            }else{
                System.out.println("simple"); 
            }
            
        }
        in.close();
        
	}
    
    public static boolean isPalindrome(char[] arr){
        
        if(arr.length == 1) return true;
        int steps = arr.length /2;
        for(int i =0 ; i<steps;i++){
            if(arr[i] != arr[arr.length-i-1]) return false;
        }
        return true;
        
    }

}