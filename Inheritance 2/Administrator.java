//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Administrator extends HospitalEmployee {
	//no-arg constructor
	public Administrator() {
	}
	//constructor for Administrator class, utilizes HospitalEmployee constructor
	public Administrator(String name, String employeeID, String phoneNumber) {
		super(name, employeeID, phoneNumber);
	}
	
	//services methods
	public void budget() {
		System.out.println("Administrator updates and maintains the hospital budget");
	}
	public void employeeManagement() {
		System.out.println("Administrator keeps track of hospital employees");
	}
	public void scheduleEvents() {
		System.out.println("Administrator schedules important events and meetings");
	}
	
	//displays Administrator info (toString() method)
	public void displayInformation() {
		displayInfo();
		System.out.println("Occupation: Administrator\n");
	}
}
