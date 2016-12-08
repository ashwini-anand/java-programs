package hw3;

import java.util.ArrayList;
import java.util.List;

public class Q3 {

	public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10,5);
        Rectangle r2 = new Rectangle(12,5);
        List<Rectangle> rectangles= new ArrayList<Rectangle>();
        rectangles.add(r1);
        rectangles.add(r2);
        RandomShape rs = new RandomShape(rectangles);
        Rectangle r3 = new Rectangle(14,8);
        Rectangle r4 = new Rectangle(16,9);
        rs.addRectangle(r3);
        rs.addRectangle(r4);
        
        int i=1;
        for(Rectangle r : rs.getRectangles()){
        	System.out.println("Rectangle "+i+":   Length = "+r.getLength()+"   Breadth = "+r.getBreadth());
        	i++;
        }
        System.out.println("\nArea of RandomShape is "+rs.area());
	}

}
