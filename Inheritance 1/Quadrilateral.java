//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Quadrilateral {
	/*instance variables: 
	x-y coordinate pairs for four end points*/
	private double x1, y1, x2, y2, x3, y3, x4, y4;
	
	//no-arg constructor
	public Quadrilateral() {
	}
	
	/*Quadrilateral constructor, initializes x-y coordinate pairs
	x1y1:top left, x2y2:top right, x3y3:bottom left, x4y4:bottom right*/
	public Quadrilateral(double x1, double y1, double x2, double y2, 
						 double x3, double y3, double x4, double y4) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.x4 = x4;
		this.y4 = y4;
	}
	
	//accessor methods for each coordinate
	public double getX1() {
		return x1;
	}
	public double getY1() {
		return y1;
	}
	public double getX2() {
		return x2;
	}
	public double getY2() {
		return y2;
	}
	public double getX3() {
		return x3;
	}
	public double getY3() {
		return y3;
	}
	public double getX4() {
		return x4;
	}
	public double getY4() {
		return y4;
	}
	
	//mutator methods for each coordinate
	public void setX1(double x1) {
		this.x1 = x1;
	}
	public void setY1(double y1) {
		this.y1 = y1;
	}
	public void setX2(double x2) {
		this.x2 = x2;
	}
	public void setY2(double y2) {
		this.y2 = y2;
	}
	public void setX3(double x3) {
		this.x3 = x3;
	}
	public void setY3(double y3) {
		this.y3 = y3;
	}
	public void setX4(double x4) {
		this.x4 = x4;
	}
	public void setY4(double y4) {
		this.y4 = y4;
	}
	
	/*Quadrilateral toString() method, returns a string displaying
	the four end points of the quadrilateral*/
	public String toString() {
		return "Quadrilateral end points: ("+x1+", "+y1+
				") ("+x2+", "+y2+") ("+x3+", "+y3+
				") ("+x4+", "+y4+")";
	}
}
