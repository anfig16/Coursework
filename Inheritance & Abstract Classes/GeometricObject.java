//*****************
//Andrea Figueroa
//HW 5- Abstract Classes and Interfaces
//Programming Exercise 13.5
//Spring 2023
//COSC 1337
//*****************
public abstract class GeometricObject implements Comparable<GeometricObject>{
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
	
	//abstract method getArea
	public abstract double getArea();
	
	//abstract method getPerimeter
	public abstract double getPerimeter();
	
	//compares GeometricObjects, returns positive if this object is greater, negative
	//if object1 is greater, and zero if objects are equal
	public int compareTo(GeometricObject object1) {
		if (getArea() > object1.getArea()) {
			return 1;
		}
		else if (getArea() < object1.getArea()) {
			return -1;
		  }  
		  else {
			 return 0;
		  }	  
	}
	
	public static void max(GeometricObject object1, GeometricObject object2) {
		int result = object1.compareTo(object2);
		if(result == 1) {
			System.out.println("First object is larger");
		} else if(result == -1) {
			System.out.println("Second object is larger");
		} else if(result == 0){
			System.out.println("Both objects are equal");
		}
	}
	
}
