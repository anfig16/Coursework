public class Circle {
  private double radius;
  // no-arg constructor
  public Circle() {
	  radius= 0.0;
  }
  // constructor with parameter
  public Circle(double newRadius) {
    if (newRadius>0)
	  this.radius = newRadius;
    else
    	System.out.println("Radius must be greater than 0.");
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double newRadius) {
    if (newRadius>0.0)
	  this.radius = newRadius;
    else
    	System.out.println("Radius must be greater than 0.");
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /* Print the circle info */
  public void printCircle() {
    System.out.println("The radius is: " + radius + "\nThe area is: "+ this.getArea());
  }
}