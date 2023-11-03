//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Trapezoid extends Quadrilateral {
	//instance variables for Trapezoid(base1: top base, base2: bottom base)
	private double base1;
	private double base2;
	private double height;
	
	//no-arg constructor
	public Trapezoid() {
	}
	//Trapezoid constructor, calls on Quadrilateral constructor
	public Trapezoid(double x1, double y1, double x2, double y2, 
			 		 double x3, double y3, double x4, double y4) {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
	}
	
	//accessor/mutator methods for instance variables
	//computes base1, assigns and returns it
	public double getBase1() {
		base1 = getX2()-getX1();
		return base1;
	}
	//computes base2, assigns and returns it
	public double getBase2() {
		base2 = getX4()-getX3();
		return base2;
	}
	//computes height, assigns and returns it
	public double getHeight() {
		height = getY1()-getY3();
		return height;
	}
	
	//toString() method
	public String toString() {
		return "Trapezoid base 1: " + getBase1() + "\nTrapezoid base 2: " 
				+ getBase2() + "\nTrapezoid height: " + getHeight();
	}
	
	//area method
	public String getArea() {
		return "Trapezoid area: " + (((base1+base2)/2)*height);
	}

	
}
