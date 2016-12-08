package hr;


import java.util.Comparator;
import java.util.Scanner;

class Test5{
	
}

public class Test extends Test1 implements Comparable<Test> , Comparator<Test>{

	static double[] arr;
    public static void main(final String[] args) {
    	
    	Scanner s = new Scanner(System.in);
    	int t  = s.nextInt();
    	
    	while(t>0){
    		int n = s.nextInt();
    		int r = s.nextInt();
    		arr = new double[n];
    		for (int i = 0; i < n; i++) {
				arr[i] = s.nextDouble();
			}
    		print_nCr(n, r,t);
    		t--;
    	}
    	
        
    }

    public static final void print_nCr(final int n, final int r,int t) {
        int[] res = new int[r];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        boolean done = false;
        double sum =0;
        while (!done) {
            //System.out.println(Arrays.toString(res));
        	double pdt =1;
        	boolean[] boolarr = new boolean[n];
        	for (int i = 0; i < res.length; i++) {
				boolarr[res[i]-1] = true;
			}
        	for (int i = 0; i < boolarr.length; i++) {
				if(boolarr[i]){
					pdt = pdt*arr[i];
				}else{
					pdt = pdt*(1-arr[i]);
				}
			}
        	sum = sum + pdt;
        	if(r!=0){
            done = getNext(res, n, r);
        	}
        	if(r==0){
        		done = true;
        	}
        }
        
        System.out.println("Case "+t+": "+(Math.round(sum * 100.0) / 100.0));
    }

    public static final boolean getNext(final int[] num, final int n, final int r) {
        int target = r - 1;
        num[target]++;
        if (num[target] > ((n - (r - target)) + 1)) {
            // Carry the One
            while (num[target] > ((n - (r - target)))) {
                target--;
                if (target < 0) {
                    break;
                }
            }
            if (target < 0) {
                return true;
            }
            num[target]++;
            for (int i = target + 1; i < num.length; i++) {
                num[i] = num[i - 1] + 1;
            }
        }
        return false;
    }

	@Override
	public int compare(Test o1, Test o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Test o) {
		// TODO Auto-generated method stub
		return 0;
	}
}