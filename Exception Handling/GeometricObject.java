//*****************
//Andrea Figueroa
//HW 4- Exception Handling
//Programming Exercise 11.1
//Spring 2023
//COSC 1337
//*****************
public class GeometricObject {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	//constructs a default geometric object
	public GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	//constructs a geometric object with specified color and filled value
	public GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	//return color
	public String getColor() {
		return color;
	}
	
	//set a new color
	public void setColor(String color) {
		this.color = color;
	}
	
	//return filled
	public boolean isFilled() {
		return filled;
	}
	
	//set a new filled
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	//get dateCreated
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	//return string representation of the object
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
}
