package uva.string;

import java.util.*;

public class Abnormal89 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- >0){
            String s = in.next();
            if(s.length()==1){
                System.out.println("palindrome");
                continue;
            }
            char[] sarr = s.toCharArray();
            boolean flag = false;
            for(int i = 1; i<sarr.length;i++){
                if(isPalindrome(Arrays.copyOfRange(sarr,0,i)) && isPalindrome(Arrays.copyOfRange(sarr,i,sarr.length))){
                    flag = true;
                    break;
                }
            }
            if(flag){
               System.out.println("alindrome"); 
               continue;
            }
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