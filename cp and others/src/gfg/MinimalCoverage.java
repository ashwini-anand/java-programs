package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MinimalCoverage {

	/**
	 * @param args
	 */
	static class Lines implements Comparable<Lines> {

		int l;
		int r;

		public Lines(int le, int ri) {
			l = le;
			r = ri;
		}

		@Override
		public int compareTo(Lines o) {
			if(this.r > o.r){
				return 1;
			}else if(this.r < o.r){
				return -1;
			}else{
				return this.l-o.l;
			}
		}

	}
	
	static class Lines1 implements Comparable<Lines1> {

		int l;
		int r;

		public Lines1(int le, int ri) {
			l = le;
			r = ri;
		}

		@Override
		public int compareTo(Lines1 o) {
			if(this.l > o.l){
				return 1;
			}else if(this.l < o.l){
				return -1;
			}else{
				return this.r-o.r;
			}
		}

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {
			t--;
			int m = s.nextInt();
			int l = -1, r = -1;
			ArrayList<Lines> al = new ArrayList<>();
			while (true) {
				l = s.nextInt();
				r = s.nextInt();
				if (l == 0 && r == 0) {
					// System.out.println(l+" "+r);
					break;
				}
				Lines line = new Lines(l, r);
				al.add(line);
			}

			Collections.sort(al);
			int k = m;
			if (m > al.get(al.size() - 1).r || 0 < al.get(0).l) {
				// System.out.println(al.get(al.size()-1).r+" "+al.get(0).l);
				System.out.println(0);
				System.out.println(); // print line after every o/p
				continue;
			}
			ArrayList<Lines> result = new ArrayList<>();
			int flag = 0;
			for (int i = al.size() - 1; i >= 0; i--) {
				if (k == al.get(i).r) {
					if((i != 0) && al.get(i-1).r == al.get(i).r){
						continue;
					}
					Lines line1 = new Lines(al.get(i).l, al.get(i).r);
					result.add(line1);
					if ((i != 0) && al.get(i).l > al.get(i-1).r) {
						flag = 1;
						System.out.println(0);
						//System.out.println();
						break;
					}
					if (al.get(i).l > 0) {
						k = al.get(i).l;
					} else {
						break;
					}
				}
				if (k > al.get(i).r) {
					Lines line1 = new Lines(al.get(i + 1).l, al.get(i + 1).r);
					result.add(line1);
					if (al.get(i + 1).l > al.get(i).r) {
						flag = 1;
						System.out.println(0);
						//System.out.println();
						break;
					}
					if (al.get(i + 1).l > 0) {
						k = al.get(i + 1).l;
					} else {
						break;
					}
				}
			}

			if (flag == 1) {
				continue;
			}
			
			
			
			
			
			flag = 0;
			
			ArrayList<Lines1> al1 = new ArrayList<>();
			for (int i = 0; i < al.size(); i++) {
				al1.add(new Lines1(al.get(i).l,al.get(i).r));
			}
			
			
			Collections.sort(al1);
			
			ArrayList<Lines1> result1 = new ArrayList<>();
			
			k=0;
			for (int i = 0; i < al1.size(); i++) {
				if (k == al1.get(i).l) {
					if((i != al1.size()-1) && al1.get(i+1).l == al1.get(i).l){
						continue;
					}
					Lines1 line2 = new Lines1(al1.get(i).l, al1.get(i).r);
					result1.add(line2);
					if ((i != al1.size()-1) && al1.get(i).r < al1.get(i+1).l) {
						flag = 1;
						System.out.println(0);
						//System.out.println();
						break;
					}
					if (al1.get(i).r < m) {
						k = al1.get(i).r;
					} else {
						break;
					}
				}
				if (k < al1.get(i).l) {
					Lines1 line2 = new Lines1(al1.get(i - 1).l, al1.get(i - 1).r);
					result1.add(line2);
					if ((i!=0) && al1.get(i - 1).r < al1.get(i).l) {
						flag = 1;
						System.out.println(0);
						//System.out.println();
						break;
					}
					if (al1.get(i - 1).r < m) {
						k = al1.get(i - 1).r;
					} else {
						break;
					}
				}
				if(i==al1.size()-1 && k>al1.get(i).l){
					Lines1 line2 = new Lines1(al1.get(i).l, al1.get(i).r);
					result1.add(line2);
				}
			}

			if (flag == 1) {
				continue;
			}
			
//			System.out.println(result.toString());;
//			System.out.println(result1.toString());;
			
//			for (int i = 0; i < result1.size(); i++) {
//				System.out.println(result1.get(i).l + " " + result1.get(i).r);
//			}
			
//			Collections.sort(result);
//			System.out.println(result.size());
//			for (int i = 0; i < result.size(); i++) {
//				System.out.println(result.get(i).l + " " + result.get(i).r);
//			}
			
			if(result1.size() <= result.size()){
				System.out.println(result1.size());
				Collections.sort(result1);
				for (int i = 0; i < result1.size(); i++) {
					System.out.println(result1.get(i).l + " " + result1.get(i).r);
				}
			}else{
				System.out.println(result.size());
				ArrayList<Lines1> ll1 = new ArrayList<>();
				for (int i = 0; i < result.size(); i++) {
					ll1.add(new Lines1(result.get(i).l,result.get(i).r));
				}
				
				Collections.sort(ll1);
				for (int i = 0; i < ll1.size(); i++) {
					System.out.println(ll1.get(i).l + " " + ll1.get(i).r);
				}
			}
			
			System.out.println();
			
		}
	}

}
