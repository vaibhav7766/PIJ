package Assign5;

public class Sphere implements Shaper3D{
	private double radius;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double volume() {
		return (4/3) * Math.PI * Math.pow(radius, 3);
	}
	
	public double surfaceArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
}