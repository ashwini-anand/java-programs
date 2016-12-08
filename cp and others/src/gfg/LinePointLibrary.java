package gfg;

//import gfg.LineLibrary.Point;

/** round-a-double-to-2-decimal-places
double value = 200.3456;
System.out.printf("Value: %.2f", value);
or
String result = String.format("%.2f", value);
or
DecimalFormat df = new DecimalFormat("####0.00");
System.out.println("Value: " + df.format(value));
or
round(200.3456, 2);

* Array of arraylist
ArrayList<Integer>[] varr = (ArrayList<Integer>[]) new ArrayList[n+1];*/

public class LinePointLibrary {
	
	static class Geometry {
		double distBetPointLine(Line line, Point point) {
			Point p1 = new Point(line.x1, line.y1);
			Point p2 = new Point(line.x2, line.y2);
			Vector v1 = new Vector(p1, p2);
			Vector v2 = new Vector(p1, point);
			double projection = Math.abs(Vector.dotProduct(v1, v2))
					/ Vector.magnitude(v1);
			double hypotenuse = distBetTwoPoints(p1, point);
			double vertDist = Math.sqrt(Math.abs(hypotenuse * hypotenuse
					- projection * projection));
			return vertDist;
		}

		double distBetPointLineSeg(Line line, Point point) {
			Point p1 = new Point(line.x1, line.y1);
			Point p2 = new Point(line.x2, line.y2);
			Vector v1 = new Vector(p1, p2);
			Vector v2 = new Vector(p1, point);

			Vector v3 = new Vector(p2, p1);
			Vector v4 = new Vector(p2, point);

			double projection1 = Math.abs(Vector.dotProduct(v1, v2))
					/ Vector.magnitude(v1);
			double projection2 = Math.abs(Vector.dotProduct(v3, v4))
					/ Vector.magnitude(v3);

			double segmentDist = distBetTwoPoints(p1, p2);
			if (projection1 >= segmentDist || projection2 >= segmentDist) {
				double dist1 = distBetTwoPoints(p1, point);
				double dist2 = distBetTwoPoints(p2, point);
				return Math.min(dist1, dist2);
			} else {
				double hypotenuse = distBetTwoPoints(p1, point);
				double vertDist = Math.sqrt(hypotenuse * hypotenuse
						- projection1 * projection1);
				return vertDist;
			}

		}

		double distBetTwoPoints(Point p1, Point p2) {
			double dist = Math.sqrt((p2.x - p1.x) * (p2.x - p1.x)
					+ (p2.y - p1.y) * (p2.y - p1.y));
			return dist;
		}

		boolean checkLineLineInt(Line line1, Line line2) {
			double accuracy = 0.0000001;
			double det = line1.A * line2.B - line1.B * line2.A;
			if (det < accuracy) {
				return false;
			} else {
				return true;
			}
		}

		boolean checkLineLineSegmentInt(Line line, Line linesegment) {
			if (checkLineLineInt(line, linesegment)) {
				Point p = lineLineIntPoint(line, linesegment);
				if (checkIfLiesBetween(linesegment, p.x, p.y)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		boolean checkLineSegmentLineSegmentInt(Line linesegment1,
				Line linesegment2) {
			if (checkLineLineSegmentInt(linesegment1, linesegment2)
					&& checkLineLineSegmentInt(linesegment2, linesegment1)) {
				return true;
			} else {
				return false;
			}
		}

		// Same function can be used to obtain line-line, line-lineseg,
		// lineseg-lineseg intersection points. (NOTE: ONLY AFTER TESTING THE
		// INT
		// COND)
		Point lineLineIntPoint(Line line1, Line line2) {
			double accuracy = 0.0000000000000000001;
			double A1 = line1.A;
			double A2 = line2.A;
			double B1 = line1.B;
			double B2 = line2.B;
			double C1 = line1.C;
			double C2 = line2.C;

			double det = A1 * B2 - B1 * A2;

			double x = (C2 * B1 - C1 * B2) / (A1 * B2 - B1 * A2);
			double y = (A1 * C2 - C1 * A2) / (B1 * A2 - A1 * B2);
			Point p = new Point(x, y);
			return p;
		}

		boolean checkIfLiesBetween(Line line, double x, double y) {
			double maxX, maxY, minX, minY;
			double x1 = line.x1;
			double x2 = line.x2;
			double y1 = line.y1;
			double y2 = line.y2;
			maxX = Math.max(x1, x2);
			maxY = Math.max(y1, y2);
			minX = Math.min(x1, x2);
			minY = Math.min(y1, y2);

			if (x <= maxX && x >= minX) {
				if (y <= maxY && y >= minY) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}

	static class Line {
		double A;
		double B;
		double C;
		double x1;
		double x2;
		double y1;
		double y2;

		Line(double x1, double y1, double x2, double y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.A = y2 - y1;
			this.B = x1 - x2;
			this.C = y1 * x2 - x1 * y2;
		}
	}

	static class Point {
		double x;
		double y;

		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Vector {
		double x;
		double y;

		Vector(Point p1, Point p2) {
			x = p2.x - p1.x;
			y = p2.y - p1.y;
		}

		static double dotProduct(Vector v1, Vector v2) {
			double result = (v1.x * v2.x) + (v1.y * v2.y);
			return result;
		}

		static double crossProduct(Vector v1, Vector v2) {
			double det = (v1.x * v2.y) - (v2.x * v1.y);
			return det;
		}

		static double magnitude(Vector v) {
			return Math.sqrt(v.x * v.x + v.y * v.y);
		}
	}

	public static void main(String args[]) {

		Line line1 = new Line(-10, 0, 10, 0);
		Point p = new Point(15, 5);
		Geometry g = new Geometry();
		double dist = g.distBetPointLine(line1, p);
		System.out.println("Dist is " + dist);
	}
}
