//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Doctor extends HospitalEmployee{
	//no-arg constructor
	public Doctor() {
	}
	//constructor for Doctor class, utilizes HospitalEmployee constructor
	public Doctor(String name, String employeeID, String phoneNumber) {
		super(name, employeeID, phoneNumber);
	}
	
	//services methods
	public void diagnose() {
		System.out.println("Doctor diagnoses patients");
	}
	public void prescribe() {
		System.out.println("Doctor prescribes medicine for patients");
	}
	
	//displays Doctor info (toString() method)
	public void displayInformation() {
		displayInfo();
		System.out.println("Occupation: Doctor\n");
	}
}
