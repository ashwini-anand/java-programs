//O(nlogn)+O(kn) algorithm. nlogn comes because of sorting of lines on y-axis.

package gfg;

import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.Scanner;

public class WaterFall {

	/**
	 * @param args
	 */

	static class Point {
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

	}

	static class Line implements Comparable<Line> {
		Point p1;
		Point p2;

		public Line() {
			// TODO Auto-generated constructor stub
		}

		public Line(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
		}

		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			return o.p2.y - this.p2.y;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {
			t--;
			int np = s.nextInt();
			Line arrLine[] = new Line[np];
			int linecount = 0;
			while (np > 0) {
				np--;
				int x1 = s.nextInt();
				int y1 = s.nextInt();
				int x2 = s.nextInt();
				int y2 = s.nextInt();
				Point p1, p2;
				if (y1 > y2) {
					p1 = new Point(x1, y1);
					p2 = new Point(x2, y2);
				} else {
					p1 = new Point(x2, y2);
					p2 = new Point(x1, y1);
				}
				Line line = new Line(p1, p2);
				arrLine[linecount++] = line;
			}

			Arrays.sort(arrLine);

			int ns = s.nextInt();
			while (ns > 0) {
				ns--;
				int xp = s.nextInt();
				int yp = s.nextInt();
				for (int i = 0; i < arrLine.length; i++) {
					Line l = arrLine[i];
					if (yp < l.p2.y)
						continue;
					if (Line2D.linesIntersect(xp, yp, xp, 0, l.p1.x, l.p1.y,
							l.p2.x, l.p2.y)) {
						xp = l.p2.x;
						yp = l.p2.y;
					}
				}
				System.out.println(xp);
			}

			if (t != 0)
				System.out.println();
		}

	}

}
