package gfg;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sticks {

	/**
	 * @param args
	 */

	static class Point {
		double x;
		double y;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class Line {
		int idx;
		Point p1;
		Point p2;

		public Line() {
			// TODO Auto-generated constructor stub
		}

		public Line(int idx, Point p1, Point p2) {
			this.idx = idx;
			this.p1 = p1;
			this.p2 = p2;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		while (true) {
			int n = s.nextInt();
			if (n == 0)
				break;
			int t = 1;
			List<Line> lineList = new ArrayList<>();
			while (t <= n) {
				double x1 = s.nextDouble();
				double y1 = s.nextDouble();
				double x2 = s.nextDouble();
				double y2 = s.nextDouble();
				Point p1 = new Point(x1, y1);
				Point p2 = new Point(x2, y2);
				Line l = new Line(t, p1, p2);
				if (t == 0) {
					lineList.add(l);
				} else {
					boolean added = false;
					for (int i = 0; i < lineList.size(); i++) {
						Line l1 = lineList.get(i);
						// if (isIntersecting(l1.p1, l1.p2, l.p1, l.p2)) {
						Line2D line1 = new Line2D.Float((float)l1.p1.x, (float)l1.p1.y, (float)l1.p2.x, (float)l1.p2.y);
						Line2D line2 = new Line2D.Float((float)l.p1.x, (float)l.p1.y,(float) l.p2.x, (float)l.p2.y);
//						if (Line2D.linesIntersect(l1.p1.x, l1.p1.y, l1.p2.x,
//								l1.p2.y, l.p1.x, l.p1.y, l.p2.x, l.p2.y)) {
						if (line2.intersectsLine(line1)) {
							lineList.remove(i);
							lineList.add(l);
							added = true;
							break;
						}
					}
					if (!added) {
						lineList.add(l);
					}

				}
				t++;
			}
			System.out.print("Top sticks: ");
			for (int i = 0; i < lineList.size() - 1; i++) {
				System.out.print(lineList.get(i).idx + ", ");
			}
			System.out.println(lineList.get(lineList.size() - 1).idx + ".");
		}

	}

	public static boolean isIntersecting(Point p1, Point q1, Point p2, Point q2) {
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		if (o1 != o2 && o3 != o4)
			return true;

		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;

		return false;

	}

	public static int orientation(Point p, Point q, Point r) {

		double val = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);
		if (Math.abs(val - 0) < 1e-8)
			return 0;
		return (val > 0) ? 1 : 2;

	}

	public static boolean onSegment(Point p, Point q, Point r) {

		if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x)
				&& q.y <= Math.max(p.y, r.y) && q.y >= Math.max(p.y, r.y)) {
			return true;
		}
		return false;
	}
}
