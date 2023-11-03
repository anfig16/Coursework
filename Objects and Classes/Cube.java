//****************************
//COSC 1173 Programming Lab
//Name: Andrea Figueroa
//Date: 11/28/2022
//Objects and Classes (bonus)
//****************************
public class Cube {
	private double length;
	private double width;
	private double height;
	
	public Cube() {
		length = 0.0;
		width = 0.0;
		height = 0.0;
	}
	
	public Cube(double length, double width, double height) {
		if((length>0) && (width>0) && (height>0)){
			this.length = length;
			this.width = width;
			this.height = height;
		} else {
			System.out.println("Length, width, and height must be greater than 0.");
		}
	}
	
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	
	public void setLength(double length) {
		if(length>0) {
			this.length = length;
		} else {
			System.out.println("Length must be greater than 0.");
		}
	}
	public void setWidth(double width) {
		if(width>0) {
			this.width = width;
		} else {
			System.out.println("Width must be greater than 0.");
		}
	}
	public void setHeight(double height) {
		if(height>0) {
			this.height = height;
		} else {
			System.out.println("Height must be greater than 0.");
		}
	}
	
	public double getArea() {
		return 6*(length*width);
	}
}
