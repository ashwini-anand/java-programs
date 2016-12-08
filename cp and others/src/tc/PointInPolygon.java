package tc;

import java.awt.Polygon;
import java.awt.geom.Line2D;

public class PointInPolygon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] vertices={"0 0",
//				 "0 10",
//				 "10 10",
//				 "10 0"};
//		int testPointX = 5;
//		int testPointY = 10;
//		System.out.println(testPoint(vertices, testPointX, testPointY));

	}

	public static String testPoint(String[] vertices, int testPointX,
			int testPointY) {

		String[] str = vertices[0].split("\\s+");
		//System.out.println(vertices[2]+" "+str[0]);
		int x1 = Integer.parseInt(str[0]);
		int y1 = Integer.parseInt(str[1]);
		int x2 = x1;
		int y2 = y1;
		int initpx = x1;
		int initpy = y1;
		Polygon poly = new Polygon();
		poly.addPoint(x1, y1);
		boolean flag = false;
		for (int i = 1; i < vertices.length; i++) {
			x1 = x2;
			y1 = y2;
			String[] str1 = vertices[i].split("\\s+");
			x2 = Integer.parseInt(str1[0]);
			y2 = Integer.parseInt(str1[1]);
			if (Line2D.ptSegDist(x1, y1, x2, y2, testPointX, testPointY) == 0) {
				flag = true;
				break;
			}
			//System.out.println(str1[0]+" "+x2+" "+y2);
			poly.addPoint(x2, y2);
		}
		// if(poly)
		if(Line2D.ptSegDist(initpx, initpy, x2, y2, testPointX, testPointY) == 0){
			flag = true;
		}
		if (flag) {
			return "BOUNDARY";
		} else if (poly.contains(testPointX, testPointY)) {
			return "INTERIOR";
		} else {
			return "EXTERIOR";
		}

	}

}
