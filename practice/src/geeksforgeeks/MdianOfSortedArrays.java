// its wrong

package geeksforgeeks;

import java.util.*;

public class MdianOfSortedArrays {
	// DO NOT MODIFY BOTH THE LISTS
	public static List<Integer> arrL1;
	public static List<Integer> arrL2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			a.add(in.nextInt());
		}
		n = in.nextInt();
		for (int i = 0; i < n; i++) {
			b.add(in.nextInt());
		}
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(final List<Integer> a,
			final List<Integer> b) {
		arrL1 = a;
		arrL2 = b;
//		a.addAll(b);
//		Collections.sort(a);
//		if(a.size()%2==0){
//			double a1 = a.get(a.size()/2);
//			double b1 = a.get(a.size()/2 -1);
//			return (a1+b1)/2.0;
//		}else{
//			return a.get(a.size()/2);
//		}
		if (b.isEmpty()) {
			if (a.size() % 2 == 0) {
				int a1 = a.get(a.size() / 2);
				int b1 = a.get(a.size() / 2 - 1);
				return (a1 + b1) / 2;
			} else {
				return a.get((a.size() - 1) / 2);
			}
		}

		if (a.isEmpty()) {
			if (b.size() % 2 == 0) {
				int a1 = b.get(b.size() / 2);
				int b1 = b.get(b.size() / 2 - 1);
				return (a1 + b1) / 2;
			} else {
				return b.get((b.size() - 1) / 2);
			}
		}

		double res = findMedian(0, a.size() - 1, 0, b.size() - 1);
		return res;

	}

	public static double findMedian(int i, int j, int k, int l) {
		try {
			int diff1 = j - i + 1;
			int diff2 = l - k + 1;

			
			if (diff1 <= 2 && diff2 <= 2) {

				if (diff1 == 2 && diff2 == 2) {
					double tmp = (Math.max(arrL1.get(i), arrL2.get(k)) + Math
							.min(arrL1.get(j), arrL2.get(l)));
					return tmp / 2;
				}
				if (diff1 == 1 && diff2 == 1) {
					double tmp = (arrL1.get(i) + arrL2.get(k));
					return tmp / 2;
				}
				 if(diff1 == 1 && diff2==2){
					 int[] arr1 = new int[3];
					 arr1[0] = arrL1.get(i);
					 arr1[1] = arrL2.get(k);
					 arr1[2] = arrL2.get(l);
					 Arrays.sort(arr1);
					 return arr1[1];
				 }
				 if(diff1 == 2 && diff2==1){
					 int[] arr1 = new int[3];
					 arr1[0] = arrL1.get(i);
					 arr1[1] = arrL1.get(j);
					 arr1[2] = arrL2.get(l);
					 Arrays.sort(arr1);
					 return arr1[1];
				 }
			}
			int idx1 = -1;
			int idx2 = -1;
			// int idx3 = -1;
			// int idx4 = -1;
			double m1 = -1;
			double m2 = -1;

			if (diff1 % 2 == 0) {
				double a1 = arrL1.get((i + j) / 2);
				double b1 = arrL1.get((i + j) / 2 + 1);
				m1 = (a1 + b1) / 2;
				idx1 = (i + j) / 2;
			} else {
				m1 = arrL1.get((i + j) / 2);
				idx1 = (i + j) / 2;
			}

			if (diff2 % 2 == 0) {
				double a1 = arrL2.get((k + l) / 2);
				double b1 = arrL2.get((k + l) / 2 + 1);
				m2 = (a1 + b1) / 2;
				idx2 = (k + l) / 2;
			} else {
				m2 = arrL2.get((k + l) / 2);
				idx2 = (k + l) / 2;
			}

			//System.out.println(i+" "+j+" "+k+" "+l);
			//System.out.println(idx1+" "+idx2);
			if (m1 == m2) {
				return m1;
			} else if (m1 > m2) {
				//System.out.println("here1");
				if(diff1 % 2==0) idx1++;
				//else idx1--;
				//System.out.println(idx1+" "+idx2);
				return findMedian(i, idx1, idx2, l);
			} else {
				//System.out.println("here2");
				
				if(diff2 % 2==0) idx2++;
				//else idx2--;
				//System.out.println(idx1+" "+idx2);
				return findMedian(idx1, j, k, idx2);
			}

		} catch (StackOverflowError se) {
			System.out.println("StackOverflowError occurred");
			return -1;
		}
	}
}
