//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class TestProgram {
	public static void main(String[] args) {
		Quadrilateral quad = new Quadrilateral(1,5,4,5,1,1,5,1);
		Trapezoid trap = new Trapezoid(2,4,4,4,1,1,5,1);
		Rectangle rect = new Rectangle(1,3,5,3,1,1,5,1);
		Square box = new Square(1,3,3,3,1,1,3,1);
		
		System.out.println(quad.toString() + "\n");
		System.out.println(trap.toString());
		System.out.println(trap.getArea() + "\n");
		System.out.println(rect.toString());
		System.out.println(rect.getArea() + "\n");
		System.out.println(box.toString());
		System.out.println(box.getArea());
	}
}
