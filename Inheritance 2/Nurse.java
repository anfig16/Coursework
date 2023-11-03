//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Nurse extends HospitalEmployee{
	//no-arg constructor
	public Nurse() {
	}
	//constructor for Nurse class, utilizes HospitalEmployee constructor
	public Nurse(String name, String employeeID, String phoneNumber) {
		super(name, employeeID, phoneNumber);
	}
	
	//services methods
	public void care() {
		System.out.println("Nurse cares for patients needs");
	}
	public void takeTemp() {
		System.out.println("Nurse takes the temperature of patients");
	}
	public void giveShot() {
		System.out.println("Nurse administers shots to patients");
	}
	
	//displays Nurse info (toString() method)
	public void displayInformation() {
		displayInfo();
		System.out.println("Occupation: Nurse\n");
	}
}
