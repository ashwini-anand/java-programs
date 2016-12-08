package hw5;

public class Q2 {
  public static void main(String[] args) {
	Coordinates recCoord = new Coordinates(0, 4, 7, 0);
	Rectangle rect = new Rectangle(7, 4, recCoord);
	rect.draw();
	rect.setPosition(recCoord);
	rect.getArea();
	System.out.println("----------------------------------");
	Coordinates circoord = new Coordinates(0,0);
	Circle c = new Circle(circoord, 10);
	c.draw();
	c.setPosition(circoord);
	c.getArea();
}
}
