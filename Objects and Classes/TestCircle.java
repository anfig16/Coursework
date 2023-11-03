
public class TestCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle1 = new Circle(1.0);
	    
	    System.out.println("The radius is " + circle1.getRadius());
	    System.out.println("The area is " + circle1.getArea());
	    System.out.println("The diameter is " + circle1.getDiameter());
	    circle1.printCircle();
	        
	    //testing rectangle class, put into new rect testing class
	    System.out.println();
	    Rectangle rect1 = new Rectangle(3.0, 3.0);
	    Rectangle rect2 = new Rectangle();
	    System.out.println("rectangle area " + rect1.getArea());
	    System.out.println(rect2.length);
	    //submit circle, rectangle, and testing class for bonus
	}

}
