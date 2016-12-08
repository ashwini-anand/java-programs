package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class CodegrndMM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		Integer[] arr = new Integer[n];
		ArrayList<Integer> list = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			arr[i] = a;
			list.add(a);
			hs.add(b);
		}
		for (int i = 0; i < arr.length; i++) {
			if (hs.contains(arr[i])) {
				list.remove(arr[i]);
				hs.remove(arr[i]);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (list.size() <= 1)
				break;
			if (!list.contains(arr[i]))
				continue;
			for (int j = i + 1; j < arr.length; j++) {
				if (hs.contains(arr[i] + arr[j])) {
					list.remove(arr[i]);
					list.remove(arr[j]);
					hs.remove(arr[i] + arr[j]);
					// list.remove(new Integer(37));
					break;
				}
			}
		}

		Collections.sort(list);
		if (!list.isEmpty()) {
			System.out.println(list.get(0));
		}

	}

}
