//Passing for sample input. TLE in spoj
//Calling convex hull untill number of points left is less then 3.

package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class VMILI {

	/**
	 * @param args
	 */

	static public Point p0;
	static Stack<Point> hull = new Stack<>();
	static Point pts[];

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			int orient = orientation(p0, this, o);
			if (orient == 0) {
				return (distSq(p0, o) >= distSq(p0, this)) ? -1 : 1;
			}
			return (orient == 2) ? -1 : 1;
		}

		public static int orientation(Point p, Point q, Point r) {

			int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
			if (val == 0)
				return 0;
			return (val > 0) ? 1 : 2;

		}

		public static int distSq(Point p1, Point p2) {
			return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
					* (p1.y - p2.y);
		}
	}

	public static ArrayList<Point> convexhull() {
		hull.clear();
		int n = pts.length;
		if (n <= 3) {
			ArrayList<Point> pl = new ArrayList<>();
			for (int i = 0; i < pts.length; i++) {
				pl.add(pts[i]);
			}
			return pl;
		}
		// return pts;

		int ymin = pts[0].y;
		int min = 0;
		for (int i = 1; i < pts.length; i++) {
			if (ymin > pts[i].y || (ymin == pts[i].y && pts[i].x < pts[min].x)) {
				ymin = pts[i].y;
				min = i;
			}
		}

		Point temp = pts[0];
		pts[0] = pts[min];
		pts[min] = temp;

		p0 = pts[0];

		Arrays.sort(pts, 1, n);
		int m = 1;

		for (int i = 1; i < n; i++) {
			while (i < n - 1 && Point.orientation(p0, pts[i], pts[i + 1]) == 0)
				i++;
			pts[m] = pts[i];
			m++;
		}

		if (m <= 3) {

			ArrayList<Point> pl = new ArrayList<>();
			for (int i = 0; i < pts.length; i++) {
				pl.add(pts[i]);
			}
			return pl;

		}
		// return Arrays.copyOfRange(pts, 0, m); // returns range of array,
		// exclusive m.

		hull.push(pts[0]);
		hull.push(pts[1]);
		hull.push(pts[2]);
		for (int i = 3; i < m; i++) {
			while (Point.orientation(nextToTop(), hull.peek(), pts[i]) != 2) {
				hull.pop();
			}
			hull.push(pts[i]);
		}

		// while (!hull.isEmpty()) {
		// Point p = hull.pop();
		// System.out.println(p.x + " " + p.y);
		// }

		// Point[] hullPoints = new Point[hull.size()];
		// return hull.toArray(hullPoints);
		ArrayList<Point> res = new ArrayList<>();
		for (int i = 0; i < hull.size(); i++) {
			res.add(hull.get(i));
		}
		return res;
	}

	public static Point nextToTop() {
		Point p = hull.pop();
		Point res = hull.peek();
		hull.push(p);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner s = new MyScanner();
		int n = s.nextInt();
		ArrayList<Point> pList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			Point p = new Point(x, y);
			pList.add(p);
		}
		int count = 0;
		while (!pList.isEmpty()) {
			if (pList.size() <= 2) {
				break;
			}

			pts = new Point[pList.size()];
			pList.toArray(pts);
			ArrayList<Point> polyPoints = convexhull();
			if (polyPoints.size() > 2)
				count++;
			pList.removeAll(polyPoints);
		}
		System.out.println(count);
	}

	static class MyScanner {
		static BufferedReader br;
		static StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

}
