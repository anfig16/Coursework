//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Rectangle extends Trapezoid{
	//instance variables for Rectangle
	private double width;
	private double length;
	
	//no-arg constructor for Rectangle
	public Rectangle() {
	}
	
	//Rectangle constructor, calls on Quadrilateral constructor
	public Rectangle(double x1, double y1, double x2, double y2, double x3, double y3,
					 double x4, double y4) {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	//accessor/mutator methods for instance variables
	//computes width with Trapezoid method, and returns width
	public double getWidth() {
		width = getBase1();
		return width;
	}
	//computes height with Trapezoid method, and returns height
	public double getLength() {
		length = getHeight();
		return length;
	}
	
	//Rectangle toString() method
	public String toString() {
		return "Rectangle width: "+ getWidth() +"\nRectangle length: "+ getLength();
	}
	
	//area method
	public String getArea() {
		return "Rectangle area: " + (width*length);
	}
}
