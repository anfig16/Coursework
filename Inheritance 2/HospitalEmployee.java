//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class HospitalEmployee {
	//instance variables, basic employee info
	private String name;
	private String employeeID;
	private String phoneNumber;
	
	//no-arg constructor
	public HospitalEmployee() {
	}
	//constructor that initializes the basic employee info
	public HospitalEmployee(String name, String employeeID, String phoneNumber) {
		this.name = name;
		this.employeeID = employeeID;
		this.phoneNumber = phoneNumber;
	}
	
	//accessor methods for instance variables
	public String getName() {
		return name;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//mutator methods for instance variables
	public void setName(String name) {
		this.name = name;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//displays employee information (toString() method)
	public void displayInfo() {
		System.out.println("Employee name: " + name);
		System.out.println("Employee ID: " + employeeID);
		System.out.println("Employe phone number: " + phoneNumber);
	}
}
