//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 11/28/2022
//Objects and Classes
//****************************
public class Rectangle {
	//two double data fields for rectangle width/length
	public double width;
	public double length;
	
	//constructor for default rectangle
	public Rectangle() {
		width = 0.0;
		length = 0.0;
	}
	//constructor with parameters
	public Rectangle(double width, double length) {
		if(width>0 && length>0) {
			this.width = width;
			this.length = length;
		} else {
			System.out.println("Width and length must be greater than 0.");
		}
	}
	
	//accessor method for length(start with get)
	public double getLength() {
		return length;
	}
	//accessor method for width
	public double getWidth() {
		return width;
	}
	
	//mutator method for length(start with set)
	public void setLength(double length) {
		if(length>0) {
			this.length = length;
		} else {
			System.out.println("Length must be greater than 0.");
		}
	}
	//mutator method for width
	public void setWidth(double width) {
		if(width>0) {
			this.width = width;
		} else {
			System.out.println("Width must be greater than 0.");
		}
	}
	//method getArea()
	public double getArea() {
		return length*width;
	}
	//method getPerimeter()
	public double getPerimeter() {
		return length+length+width+width;
	}
	
}
