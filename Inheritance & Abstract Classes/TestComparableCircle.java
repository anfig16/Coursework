package defaultPackage;
//*****************
//Andrea Figueroa
//HW 4- Abstract Classes and Interfaces
//Programming Exercise 13.6
//Spring 2023
//COSC 1174
//*****************
public class TestComparableCircle {
	public static void main(String[] args) {
		
		ComparableCircle circle1 = new ComparableCircle(7);
		ComparableCircle circle2 = new ComparableCircle(10);
		resultPrint(circle1, circle2);
		
		ComparableCircle circle3 = new ComparableCircle(10);
		ComparableCircle circle4 = new ComparableCircle(7);
		resultPrint(circle3, circle4);
		
		ComparableCircle circle5 = new ComparableCircle(7);
		ComparableCircle circle6 = new ComparableCircle(7);
		resultPrint(circle5, circle6);
		
		
		
	}
	//compares the two circle objects, prints out corrosponding message for the compareTo result
	public static void resultPrint(ComparableCircle c1, ComparableCircle c2) {
		int result = c1.compareTo(c2);
		if(result==1) {
			System.out.println("First circle is larger");
		} else if(result==-1) {
			System.out.println("Second circle is larger");
		} else {
			System.out.println("Both circles are equal");
		}
	}
}
