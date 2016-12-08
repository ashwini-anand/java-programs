package hr;

import java.util.Scanner;

public class Test1 {

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
	    combinationUtil(data, 0, n-1, 0, r,l);
	}
	
	public static void combinationUtil(int[] data, int start, int end, int index, int r,int l){
		
		if (index == r)
	    {
			double pdt =1;
        	boolean[] boolarr = new boolean[arr.length];
	        for (int j=0; j<r; j++){
				boolarr[data[j]] = true;
	        }
	        for (int i = 0; i < boolarr.length; i++) {
				if(boolarr[i]){
					pdt = pdt*inp[i];
				}else{
					pdt = pdt*(1-inp[i]);
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
	 
	    for (int i=start; i<=end && end-i+1 >= r-index; i++)
	    {
	        data[index] = arr[i];
	        combinationUtil(data, i+1, end, index+1, r,l);
	    }
	}
	 

}
