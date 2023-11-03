package defaultPackage;
//*****************
//Andrea Figueroa
//HW 4- Abstract Classes and Interfaces
//Programming Exercise 13.6
//Spring 2023
//COSC 1174
//*****************
public class Circle {
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

  
  //Return area 
  public double getArea() {
    return radius * radius * Math.PI;
  }

  //Return perimeter 
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }
  
  //Return diameter
  public double getDiameter() {
    return 2 * radius;
  }

  @Override //Return a string representation of a Circle object
  public String toString() {
    return super.toString() + " radius: " + radius;
  }

}