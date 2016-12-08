package hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GreatestInt2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		boolean alleven = true;
		for (int i = 0; i < n; i++) {
			int ele = in.nextInt();
			if(ele%2!=0) alleven = false;
			al.add(ele);
		}
		Collections.sort(al);
		if(!alleven) System.out.println(al.get(al.size()-1)-1);
		else{
			int seclast = al.size() > 2 ?al.get((al.size()-2)):-1;
			int candi = al.get(al.size()-1)-2;
			if(seclast > candi) System.out.println(seclast);
			else System.out.println(candi);
		}
	}

}
