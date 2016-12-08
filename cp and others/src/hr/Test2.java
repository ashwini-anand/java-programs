package hr;

import java.util.Scanner;

public class Test2 {

	/**
	 * @param args
	 */
	static int[] arr;
	static double[] inp;
	static double sum=0;
	public static void main(String[] args) {
    	
    	Scanner s = new Scanner(System.in);
    	int t  = s.nextInt();
    	int l =1;
    	while(l<=t){
    		sum= 0;
    		int n = s.nextInt();
    		int r = s.nextInt();
    		arr = new int[n];
    		inp = new double[n];
    		for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
    		
    		for (int i = 0; i < n; i++) {
    			inp[i] = s.nextDouble();
			}
    		printCombination(n,r,l);
    		System.out.println("Case "+l+": "+(Math.round(sum * 100.0) / 100.0));
    		l++;
    	}
    	
        
    }
	
	public static void printCombination( int n, int r,int l)
	{
	    
	    int data[] = new int[r];
	    combinationUtil(n, r, 0, data, 0);
	}
	
	public static void combinationUtil(int n, int r, int index, int data[], int i){
		
		if (index == r)
	    {
			double pdt =1;
        	boolean[] boolarr = new boolean[arr.length];
	        for (int j=0; j<r; j++){
				boolarr[data[j]] = true;
	        }
	        for (int k = 0; k < boolarr.length; k++) {
				if(boolarr[k]){
					pdt = pdt*inp[k];
				}else{
					pdt = pdt*(1-inp[k]);
				}
			}
        	sum = sum + pdt;
//        	if(r!=0){
//            done = getNext(res, n, r);
//        	}
//        	if(r==0){
//        		done = true;
//        	}
	       // System.out.println();
	        return;
	    }
	 
		if (i >= n)
	        return;
	 
	    
	    data[index] = arr[i];
	    combinationUtil(n, r, index+1, data, i+1);
	 
	   
	    combinationUtil(n, r, index, data, i+1);
	}
	 

}
