//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Receptionist extends HospitalEmployee {
	//no-arg constructor
	public Receptionist() {
	}
	//constructor for Receptionist class, utilizes HospitalEmployee constructor
	public Receptionist(String name, String employeeID, String phoneNumber) {
		super(name, employeeID, phoneNumber);
	}
	
	//services methods
	public void calls() {
		System.out.println("Receptionist makes and receives calls at desk");
	}
	public void organize() {
		System.out.println("Receptionist organizes patients files");
	}
	public void book() {
		System.out.println("Receptionist books appointments for patients");
	}
	
	//displays Receptionist info (toString() method)
	public void displayInformation() {
		displayInfo();			
		System.out.println("Occupation: Receptionist\n");
	}
}
