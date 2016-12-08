package hw5;

public class Rectangle implements Shape {

	private int length;
	private int breadth;
	private Coordinates c;
	
	
	public Rectangle(int length, int breadth, Coordinates c) {
		super();
		this.length = length;
		this.breadth = breadth;
		this.c = c;
	}

	
	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getBreadth() {
		return breadth;
	}


	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}


	public Coordinates getC() {
		return c;
	}


	public void setC(Coordinates c) {
		this.c = c;
	}


	@Override
	public void getArea() {
        System.out.println("Area of rectangle is : "+length*breadth);		
	}

	@Override
	public void draw() {
        System.out.println("Drawing rectangle");		
	}

	@Override
	public void setPosition(Coordinates c) {
        System.out.println("Position of top left vertex of Rectangle : ("+c.getX1()+","+c.getY1()+")");	
        System.out.println("Position of bottom right vertex of Rectangle : ("+c.getX2()+","+c.getY2()+")");	
	}

}
