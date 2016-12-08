package hr;

import java.util.ArrayList;
import java.util.Scanner;

public class EmaComputer {

	/**
	 * @param args
	 */
	static class Plus {
		int ci;
		int cj;
		int len;

		public Plus() {
			// TODO Auto-generated constructor stub
		}

		public Plus(int ci, int cj, int len) {
			super();
			this.ci = ci;
			this.cj = cj;
			this.len = len;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		char[][] matrix = new char[n][m];

		for (int i = 0; i < n; i++) {
			String ss = s.next();
			char[] sarr = ss.toCharArray();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sarr[j];
			}
		}

		ArrayList<Plus> pluslist = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 'G') {
					int len = 1;
					int vertB = i, horL = j;
					int vertA = i, horR = j;
					while (true) {
						vertB = vertB + 1;
						vertA = vertA - 1;
						horL = horL - 1;
						horR = horR + 1;
						if (vertB < n && vertA >= 0 && horL >= 0 && horR < m
								&& matrix[i][horL] == 'G'
								&& matrix[i][horR] == 'G'
								&& matrix[vertA][j] == 'G'
								&& matrix[vertB][j] == 'G') {
							len = len + 2;

						} else {
							break;
						}
					}

					Plus pl = new Plus(i, j, len);
					pluslist.add(pl);
				}
			}

		}
		
		if(pluslist.size() < 2){
			System.out.println(0);
			return;
		}

//		for (int i = 0; i < pluslist.size(); i++) {
//			System.out.println(pluslist.get(i).ci+" "+pluslist.get(i).cj+" "+pluslist.get(i).len);
//		}
		
		ArrayList<Integer> arealist = new ArrayList<>();
		for (int i = 0; i < pluslist.size(); i++) {
			Plus p1 = pluslist.get(i);
			for (int j = i + 1; j < pluslist.size(); j++) {
				Plus p2 = pluslist.get(j);
				if (p1.ci == p2.ci) {
					if (Math.abs(p1.cj - p2.cj) > (p1.len/2 + p2.len/2)) {
						int area = (p1.len + p1.len - 1)
								* (p2.len + p2.len - 1);
						//System.out.println(area+"p1= "+p1.cj+" "+p1.len+" p2= "+p2.cj+" "+p2.len);
						arealist.add(area);
					}else{
						    int tmpl = Math.abs(p1.cj-p2.cj)-1;
							int len1 = tmpl/2;
							int len2 = tmpl-len1;
							int area1 = 4*len1+1;
							int area2 = 4*len2+1;
							int area = area1*area2;
							//System.out.println("area="+area);
							arealist.add(area);
					}
				} else if (p1.cj == p2.cj) {
					if (Math.abs(p1.ci - p2.ci) > (p1.len/2 + p2.len/2)) {
						int area = (p1.len + p1.len - 1)
								* (p2.len + p2.len - 1);
						//System.out.println(area+" "+p1.len+" "+p2.len);
						arealist.add(area);
					}else{
						int tmpl = Math.abs(p1.ci-p2.ci)-1;
						int len1 = tmpl/2;
						int len2 = tmpl-len1;
						int area1 = 4*len1+1;
						int area2 = 4*len2+1;
						int area = area1*area2;
						//System.out.println("area="+area);
						arealist.add(area);
					}
				} else {
					//System.out.println("p1= "+p1.ci+" "+p1.cj+" p2= "+p2.ci+" "+p2.cj);
					if ((p2.cj - p2.len/2 <= p1.cj || p1.cj + p1.len/2 >= p2.cj)
							|| (p1.cj - p1.len/2 <= p2.cj || p2.cj + p2.len/2 >= p1.cj)) {

					} else if ((p2.ci - p2.len/2 <= p1.ci || p1.ci + p1.len/2 >= p2.ci)
							|| (p1.ci - p1.len/2 <= p2.ci || p2.ci + p2.len/2 >= p1.ci)) {

					}else{
						int area = (p1.len + p1.len - 1)
								* (p2.len + p2.len - 1);
						//System.out.println(area+" "+p1.len+" "+p2.len);
						arealist.add(area);
					}

				}
			}
		}
		
		if(arealist.size()==0){
			System.out.println(0);
			return;
		}
		int max = arealist.get(0);
		for (int i = 1; i < arealist.size(); i++) {
			if(max < arealist.get(i)){
				max = arealist.get(i);
			}
		}
		
		System.out.println(max);

	}

}
