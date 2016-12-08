package hw5;

public class Circle implements Shape{
   private Coordinates center ;
   private float radius;   


public Circle(Coordinates center,float r) {
	super();
	this.center = center;
	this.radius = r;
}


public float getRadius() {
	return radius;
}


public void setRadius(float radius) {
	this.radius = radius;
}

public Coordinates getCenter() {
	return center;
}


public void setCenter(Coordinates center) {
	this.center = center;
}


@Override
public void getArea() {
 System.out.println("Ara of circle is : "+3.14*radius*radius);	
}

@Override
public void draw() {
  System.out.println("Drawing Circle");	
}

@Override
public void setPosition(Coordinates c) {
  System.out.println("Center of circle is at : ("+center.getX1()+","+center.getY1()+")");
  System.out.println("Length of radius is :"+radius);
}
}
