//*****************
//Andrea Figueroa
//HW 5- Abstract Classes and Interfaces
//Programming Exercise 13.5
//Spring 2023
//COSC 1337
//*****************
public class TestProgram {
	public static void main(String[] args) {
		
		//Creates two circle objects, the first one with radius 5
		//and the second with radius 3
		Circle circle1 = new Circle(5);
		Circle circle2 = new Circle(3);
		//Compares both circle objects and outputs which one is larger area-wise
		GeometricObject.max(circle1, circle2);
		System.out.println();
		
		//Creates two rectangle objects, the first with width 4 and height 2
		//and the second width 8 and 4 height
		Rectangle rect1 = new Rectangle(4,2);
		Rectangle rect2 = new Rectangle(8,4);
		//Compares both rectangle objects and outputs which one is larger area-wise
		GeometricObject.max(rect1, rect2);
		System.out.println();
		
		//Creates two circle objects, both with radius 7
		Circle circleOne = new Circle(7);
		Circle circleTwo = new Circle(7);
		//Compares both circle objects and outputs which one is larger area-wise
		GeometricObject.max(circleOne, circleTwo);
	}
}
