package AlgoAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ClassRoompgm {

	/**
	 * @param args
	 */
	// static int count=0;
	static List<Integer> alist = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
//		int[] a = new int[100000];
//		int[] b = new int[1000];
		int[] a = new int[n];
		int[] b = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = s.nextInt();
		}

		findRank(a, b, 0, a.length - 1, 0, b.length - 1, 0);

	}

	public static void findRank(int[] a, int[] b,int i, int j, int l,int r, int c){
		if ((l <= r) ) {
			Random rand = new Random();
			//System.out.println("j="+j+" i="+i);
			int randpos = rand.nextInt((j - i) + 1) + i;
			swap(a, j, randpos);
			int pos = partition(a, i, j);
			int idx = binarySearch(b,(j - pos + 1)+c,l,r);
			if(b[idx] == (j - pos + 1)+c){
				alist.add(1);
				System.out.println("Element="+a[pos]+" Rank="+(j - pos + 1+c));
				if(alist.size()==b.length) return;
				
				findRank(a,b,pos+1,j,l,idx-1,c);
				if(pos<=0){
					return;
				}else{
					findRank(a,b,i,pos-1,idx+1,r,j-pos+1);
				}
			}else{
				
				findRank(a,b,pos+1,j,l,idx-1,c);
				if(pos<=0){
					return;
				}else{
					findRank(a,b,i,pos-1,idx,r,j-pos+1);
				}
				
			}
		}
	}

	public static int partition(int[] inparr, int start, int end) {
		long x = inparr[end];
		int i = start - 1;

		for (int j = start; j <= end - 1; j++) {
			if (inparr[j] <= x) {
				i++;
				swap(inparr, i, j);
			}
		}
		swap(inparr, i + 1, end);
		return (i + 1);
	}

	public static void swap(int[] inparr, int pos1, int pos2) {
		int temp = inparr[pos2];
		inparr[pos2] = inparr[pos1];
		inparr[pos1] = temp;
	}

	public static int binarySearch(int[] inputArr, int key, int start, int end) {

		// int start = 0;
		// int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		// System.out.println("start=" + start + " end=" + end);
		return start;
	}
}
