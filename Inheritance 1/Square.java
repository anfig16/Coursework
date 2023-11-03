//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Square extends Rectangle {
	//instance variables for Square
	private double side;
	
	//no-arg constructor
	public Square() {
	}
	//Square constructor, calls back all the way to Quadrilateral constructor
	public Square(double x1, double y1, double x2, double y2, 
	 		 	  double x3, double y3, double x4, double y4) {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
	}
	
	//accessor/mutator methods for instance variables
	//computes side, assigns and returns it
	public double getSide() {
		side = getWidth();
		return side;
	}
	
	//toString() method
	public String toString() {
		return "Square side: " + getSide();
	}
	
	//area method
	public String getArea() {
		return "Square area: " + (side*side);
	}
	
}
