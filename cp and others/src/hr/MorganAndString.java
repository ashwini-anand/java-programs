package hr;

import java.util.Scanner;

public class MorganAndString {

	public static int charToint(char c) {
		return (int) c;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t > 0) {
			t--;
			String s1 = s.next();
			String s2 = s.next();
			String s3 = "";
			int[] arr1 = new int[s1.length()];
			int[] arr2 = new int[s2.length()];
			arr1[arr1.length - 1] = charToint(s1.charAt(arr1.length - 1));
			arr2[arr2.length - 1] = charToint(s2.charAt(arr2.length - 1));
			for (int i = s1.length() - 2; i >= 0; i--) {
				arr1[i] = charToint(s1.charAt(i)) + charToint(s1.charAt(i + 1));
			}

			for (int i = s2.length() - 2; i >= 0; i--) {
				arr2[i] = charToint(s2.charAt(i)) + charToint(s2.charAt(i + 1));
			}

			int i = 0, j = 0;
			while (i < s1.length() && j < s2.length()) {
				if (s1.charAt(i) < s2.charAt(j)) {
					s3 += s1.charAt(i);
					i++;
				} else if (s1.charAt(i) > s2.charAt(j)) {
					s3 += s2.charAt(j);
					j++;
				} else {
					int k = i, l = j;
					while (k < s1.length() && l < s2.length()) {
						if (s1.charAt(k) == s2.charAt(l)) {
							k++;
							l++;
						} else {
							break;
						}
					}

					if (k == s1.length() || l == s2.length()) {
//						if (k == s1.length()) {
//							s3 += s2.substring(j, l);
//							j = l;
//						}
//						if (l == s2.length()) {
//							s3 += s1.substring(i, k);
//							i = k;
//						}
					} else {
						if (s1.charAt(k) < s2.charAt(l)) {
							s3 += s1.charAt(i);
							i++;
						} else {
							s3 += s2.charAt(j);
							j++;
						}
					}
					// if(arr1[i] < arr2[j]){
					// s3 += s1.charAt(i);
					// i++;
					// }else if(arr1[i] > arr2[j]){
					// s3 += s2.charAt(j);
					// j++;
					// }else{
					// if(i<s1.length()-1 && j<s2.length()-1){
					// if(s1.charAt(i+1) < s2.charAt(j+1)){
					// s3 += s1.charAt(i);
					// i++;
					// }else{
					// s3 += s2.charAt(j);
					// j++;
					// }
					// }else{
					// s3 += s2.charAt(j);
					// j++;
					// }
					// }

				}
			}
			if (i >= s1.length() && j < s2.length()) {
				s3 += s2.substring(j);
			} else if (j >= s2.length() && i < s1.length()) {
				s3 += s1.substring(i);
			}
			System.out.println(s3);
		}
	}
}
