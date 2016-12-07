package spoj;

import java.util.*;

public class Horrible {

	/**
	 * @param args
	 */
	static int maxValue = 999999;
	static long segmentTree[];
    static long lazy[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			int n = in.nextInt();
			int c = in.nextInt();

			long input[] = new long[n];
			Arrays.fill(input, 0);
			createSegmentTree(input);
			lazy = new long[segmentTree.length];
			
			while(c-- >0){
				int op = in.nextInt();
				int p = in.nextInt()-1;
				int q = in.nextInt()-1;
				if(op == 0){
					int v = in.nextInt();
					updateSegmentTreeLazy(p,q,v,0,input.length-1,0);
//					System.out.println("seg tree"+Arrays.toString(segmentTree));
//					System.out.println("lazy tree"+ Arrays.toString(lazy));
				}else{
//					System.out.println("seg tree"+Arrays.toString(segmentTree));
//					System.out.println("lazy tree"+ Arrays.toString(lazy));
					long res = rangeMinQueryLazy(p,q,0,input.length-1,0);
					System.out.println(res);
				}
			}
		}
	}

	private static long rangeMinQueryLazy(int qlow, int qhigh, int low, int high, int pos) {
		if(low > high){
			return 0;
		}
		if(lazy[pos] !=0){
			segmentTree[pos] += (long)(high-low+1)*lazy[pos];
			if(low != high){
				lazy[2*pos+1] += lazy[pos];
				lazy[pos*2 + 2] += lazy[pos];
			}
			lazy[pos] =0;
		}
		if(qlow > high || qhigh <low){
			return 0;
		}
		if(qlow <= low && qhigh >= high){
			return segmentTree[pos];
		}
		int mid = (low+high)/2;
		
		long res = rangeMinQueryLazy(qlow, qhigh, low, mid, 2*pos + 1) + rangeMinQueryLazy(qlow, qhigh, mid+1, high, 2*pos+2);
		return res;
	}

	private static void updateSegmentTreeLazy(int startRange, int endRange, int delta, int low, int high, int pos) {
		// TODO Auto-generated method stub
		if(low > high){
			return;
		}
		if(lazy[pos] !=0){
			segmentTree[pos] += (long)(high-low+1)*lazy[pos];
			if(low != high){
				lazy[2*pos+1] += lazy[pos];
				lazy[pos*2 + 2] += lazy[pos];
			}
			lazy[pos] =0;
			
		}
		if(startRange > high || endRange <low){
			return;
		}
		if(startRange <=low && endRange >= high){
			segmentTree[pos] += (long)(high-low+1)*delta;
			if(low != high){
				lazy[2*pos +1] += delta;
				lazy[2*pos + 2] += delta;
			}
			return;
		}
		int mid = (low+high)/2;
		updateSegmentTreeLazy(startRange, endRange, delta, low, mid, 2*pos+1);
		updateSegmentTreeLazy(startRange, endRange, delta, mid+1, high, 2*pos+2);
		segmentTree[pos] = (long)(segmentTree[2*pos+1] + segmentTree[2*pos+2]);
	}

	static void createSegmentTree(long[] input) {
		// TODO Auto-generated method stub
		int nextPowerof2 = getNextPowerof2(input.length);
		segmentTree = new long[nextPowerof2 * 2 - 1];
		Arrays.fill(segmentTree, maxValue);
		constructSegmentTree(input,0,input.length-1,0);

	}

	private static void constructSegmentTree(long[] input, int low, int high, int pos) {
		if(low==high){
			segmentTree[pos] = input[low];
			return;
		}
		int mid = (low+high)/2;
		constructSegmentTree(input, low, mid, 2*pos+1);
		constructSegmentTree(input, mid+1, high, 2*pos+2);
		segmentTree[pos] = segmentTree[2*pos+1] + segmentTree[2*pos+2];
		
	}

	private static int getNextPowerof2(int num) {
		if (num == 0) {
			return 1;
		}
		if (num > 0 && (num & (num - 1)) == 0) {
			return num;
		}
		while ((num & (num - 1)) > 0) {
			num = num & (num - 1);
		}
		return num << 1;
	}

}
