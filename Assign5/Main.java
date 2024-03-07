package Assign5;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the radius in cm: ");
		double radius = scan.nextDouble();
		System.out.println("Enter the height in cm: ");
		double height = scan.nextDouble();
		
		Circle circle = new Circle();
		circle.setRadius(radius); //Set value of radius 
		System.out.println("Area of Circle: "+circle.area());
		System.out.println("Perimeter of Circle: "+circle.perimeter());
		
		Sphere sphere = new Sphere();
		sphere.setRadius(radius);
		System.out.println("Volume of sphere: "+sphere.volume());
		System.out.println("Surface Area of sphere: "+sphere.surfaceArea());
		
		Cylinder cylinder = new Cylinder();
		cylinder.setRadius(radius);
		cylinder.setHeight(height);
		System.out.println("Volume of cylinder: "+cylinder.volume());
		System.out.println("Total Surface Area of cylinder: "+cylinder.surfaceArea());
		System.out.println("Curved Surface Area of cylinder: "+cylinder.curvedSurfaceArea());
	}
}
