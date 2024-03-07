package Assign5;

public class Circle implements Shaper{
	private double radius;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
}

