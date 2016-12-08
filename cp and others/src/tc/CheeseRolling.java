package tc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheeseRolling {

	/**
	 * @param args
	 */
	
	static List<int []> ilist = new ArrayList<int []>();
	static List<String> slist = new ArrayList<String>();
	public static void main(String[] args) {
		String[] wins = {"NYNYNYNY",
				 "NNYNYNYY",
				 "YNNNNNNN",
				 "NYYNNYNY",
				 "YNYYNYYY",
				 "NYYNNNNN",
				 "YNYYNYNN",
				 "NNYNNYYN"};
		waysToWin(wins);

	}
	
	public static void swap(int[] a, int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void permute(int v[], int n, int i){
		
		int	j;
		int[] a = new int[v.length];
		if (i == n) {
			for (j=0; j<n; j++){
				a[j] = v[j];
			}
			//ilist.add(a);
		}else{
			for (j=i; j<n; j++) {
				swap (v, i, j);
				permute (v, n, i+1);
				swap (v, i, j);
			}
		}
	}
	
	public static long[] waysToWin(String[] wins){
		int[] arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		permute(arr,arr.length,0);
		
		for (int i = 0; i < ilist.size(); i++) {
			System.out.println(Arrays.toString((ilist.get(i))));
		}
		System.out.println("done");
		return null;
		
	}

}
