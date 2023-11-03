package defaultPackage;
//*****************
//Andrea Figueroa
//HW 4- Abstract Classes and Interfaces
//Programming Exercise 13.6
//Spring 2023
//COSC 1174
//*****************
public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
	public ComparableCircle() {
		super();
	}
	public ComparableCircle(double radius) {
		super(radius);
	}
	//compares two circle objects, returns 1 if circle1 is bigger,
	//returns -1 if circle2 is bigger, and 0 if both objects are equal
	public int compareTo(ComparableCircle circle2) {
		if (getArea() > circle2.getArea()) {
			return 1;
		}
		else if (getArea() < circle2.getArea()) {
			return -1;
		  }  
		  else {
			 return 0;
		  }	 
	}
}
