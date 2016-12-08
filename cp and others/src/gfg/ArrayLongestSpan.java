package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayLongestSpan { public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner s= new Scanner(System.in);
    int n = s.nextInt();
    int arr1[] = new int[n];
    int arr2[] = new int[n];
    
    for(int i=0;i<n;i++){
        arr1[i] = s.nextInt();
    }
    for(int i=0;i<n;i++){
        arr2[i] = s.nextInt();
    }
    
    int[] diff = new int[2*n+1];
    Arrays.fill(diff,-1);
    int presum1 = 0;
    int presum2 = 0;
    int maxlen =0;
    int difference = -5;
    int diffIndex = 0;
    int len =0;
    for(int i=0;i<n;i++){
        presum1 += arr1[i];
        presum2 += arr2[i];
        difference = presum1-presum2;
        if(difference==0){
            maxlen = i;
        }
        
        else{
            diffIndex = n+difference;
            if(diff[diffIndex] == -1){
                diff[diffIndex] = i;
            }else{
                len = i-diff[diffIndex];
                if(maxlen<len) maxlen = len;
            }
        }
    }
    System.out.println(maxlen);
}
}
