package Assign5;

public class Cylinder {
	private double radius;
	private double height;
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double volume() {
		return Math.PI * Math.pow(radius, 2) * height;
	}
	
	public double surfaceArea() {
		return 2 * Math.PI * radius * (radius + height);
	}
	
	public double curvedSurfaceArea() {
		return 2 * Math.PI * radius * height;
	}
}
