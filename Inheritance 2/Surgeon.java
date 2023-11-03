//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Surgeon extends HospitalEmployee {
	//no-arg constructor
	public Surgeon() {
	}
	//constructor for Surgeon class, utilizes HospitalEmployee constructor
	public Surgeon(String name, String employeeID, String phoneNumber) {
		super(name, employeeID, phoneNumber);
	}
	
	//services methods
	public void prepare() {
		System.out.println("Surgeon prepares patients for their operations");
	}
	public void operation() {
		System.out.println("Surgeon performs operations on patients");
	}
	public void followUp() {
		System.out.println("Surgeon follows up on patients after their surgery");
	}
	
	//displays Surgeon info (toString() method)
	public void displayInformation() {
		displayInfo();			
		System.out.println("Occupation: Surgeon\n");
	}
}
