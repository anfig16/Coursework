//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 11/28/2022
//Objects and Classes
//****************************
public class testRectangle {
	public static void main(String[] args) {
		
		Rectangle rec1 = new Rectangle(4, 40);
		Rectangle rec2 = new Rectangle(3.5, 35.9);
		System.out.println("Rectangle 1 width " + rec1.getWidth());
		System.out.println("Rectangle 1 length " + rec1.getLength());
		System.out.println("Rectangle 1 area " + rec1.getArea());
		System.out.println("Rectangle 1 perimeter " + rec1.getPerimeter());
		
		System.out.println("\nRectangle 2 width " + rec2.getWidth());
		System.out.println("Rectangle 2 length " + rec2.getLength());
		System.out.println("Rectangle 2 area " + rec2.getArea());
		System.out.println("Rectangle 2 perimeter " + rec2.getPerimeter());
		
		//bonus
		Cube cube1 = new Cube(2,2,2);
		Cube cube2 = new Cube();
		System.out.println("\nBonus:");
		System.out.println("Cube 1 length " + cube1.getLength());
		System.out.println("Cube 1 width " + cube1.getWidth());
		System.out.println("Cube 1 height " + cube1.getHeight());
		cube2.setLength(4);
		cube2.setWidth(4);
		cube2.setHeight(4);
		System.out.println("Cube 2 length " + cube2.getLength());
		System.out.println("Cube 2 width " + cube2.getWidth());
		System.out.println("Cube 2 height " + cube2.getHeight());
		System.out.println("Cube 1 area " + cube1.getArea());
		System.out.println("Cube 2 area " + cube2.getArea());

	}
}
