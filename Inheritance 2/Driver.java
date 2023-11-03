//*****************
//Andrea Figueroa
//HW 2- Inheritance
//Spring 2023
//COSC 1174
//*****************
public class Driver {
	public static void main(String[] args) {
		//instantiates and implements doctor, nurse, administrator, surgeon, receptionist, and janitor classes
		Doctor doc = new Doctor("Sylvie Ware","5347","326-5910");
		Nurse nurse = new Nurse("Dante Walter","9477","495-0424");
		Administrator admin = new Administrator("Anne Coleman","2913","444-7589");
		Surgeon surgeon = new Surgeon("Connor Weaver","5830","880-5062");
		Receptionist recep = new Receptionist("Mari Bishop","9463","257-8402");
		Janitor janitor = new Janitor("Bill Barton","2376","974-1780");
		
		//uses service methods in each class
		doc.diagnose();
		nurse.takeTemp();
		admin.scheduleEvents();
		surgeon.followUp();
		recep.book();
		janitor.cleans();
		
		System.out.println("-----------------------------------");
		
		//displays info about each employee (toString() methods)
		doc.displayInformation();
		nurse.displayInformation();
		admin.displayInformation();
		surgeon.displayInformation();
		recep.displayInformation();
		janitor.displayInformation();
		
	}
}
