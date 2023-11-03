//*****************
//Andrea Figueroa
//HW 5- Abstract Classes and Interfaces
//Programming Exercise 13.5
//Spring 2023
//COSC 1337
//*****************
public class Circle extends GeometricObject{
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  //Return radius 
  public double getRadius() {
    return radius;
  }

  //Set a new radius
  public void setRadius(double radius) {
    this.radius = radius;
  }

  
  @Override //Return area 
  public double getArea() {
    return radius * radius * Math.PI;
  }

  @Override //Return perimeter 
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }
  
  //Return diameter
  public double getDiameter() {
    return 2 * radius;
  }

  //Print the circle info
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  }

  @Override //Return a string representation of a Circle object
  public String toString() {
    return super.toString() + " radius: " + radius;
  }

}