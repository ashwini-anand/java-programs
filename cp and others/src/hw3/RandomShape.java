package hw3;

import java.util.List;

public class RandomShape {
	private List<Rectangle> rectangles;
	
	public RandomShape() {
		this.rectangles = null;
	}
	public RandomShape(List<Rectangle> l){
		this.rectangles = l;
	}
	public List<Rectangle> getRectangles() {
		return rectangles;
	}
	public void setRectangles(List<Rectangle> rectangles) {
		this.rectangles = rectangles;
	}

	public void addRectangle(Rectangle r){
		this.rectangles.add(r);
	}
	public float area(){
		float RSarea = 0;
		for (Rectangle r : rectangles) {
			RSarea += r.area();
		}
		return RSarea;
	}
}
