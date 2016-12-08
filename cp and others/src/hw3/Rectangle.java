package hw3;

public class Rectangle {
	private final float length;
	private final float breadth;
	
	public Rectangle(float l, float b){
		this.length = l;
		this.breadth = b;
	}
	public Rectangle(){
		this.length =0;
		this.breadth =0;
	}
	public float getLength() {
		return length;
	}
	public float getBreadth() {
		return breadth;
	}
	
	public float area(){
		return length*breadth;
	}
	public float perimeter(){
		return 2*(length + breadth);
	}

}
