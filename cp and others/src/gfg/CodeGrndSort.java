package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CodeGrndSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> oddPos = new ArrayList<>();
		ArrayList<Integer> evenPos = new ArrayList<>();
		ArrayList<Integer> oddNum = new ArrayList<>();
		ArrayList<Integer> evenNum = new ArrayList<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			if(a%2==0){
				evenPos.add(i);
				evenNum.add(a);
			}else{
				oddPos.add(i);
				oddNum.add(a);
			}
		}
		Collections.sort(evenNum);
		Collections.sort(oddNum);
		Collections.reverse(evenNum);
		
		for (int i = 0; i < evenNum.size(); i++) {
			arr[evenPos.get(i)] = evenNum.get(i);
		}
		
		for (int i = 0; i < oddNum.size(); i++) {
			arr[oddPos.get(i)] = oddNum.get(i);
		}
		
		System.out.print(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}

}
