//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Janitor extends HospitalEmployee {
	//no-arg constructor
	public Janitor() {
	}
	//constructor for Janitor class, utilizes HospitalEmployee constructor
	public Janitor(String name, String employeeID, String phoneNumber) {
		super(name, employeeID, phoneNumber);
	}
	
	//services methods
	public void cleans() {
		System.out.println("Janitor cleans and sanitizes the hospital");
	}
	public void trash() {
		System.out.println("Janitor takes out the trash");
	}
	public void windows() {
		System.out.println("Janitor washes the hospital windows");
	}
	
	//displays Janitor info (toString() method)
	public void displayInformation() {
		displayInfo();			
		System.out.println("Occupation: Janitor\n");
	}
}
