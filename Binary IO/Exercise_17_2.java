//*****************
//Andrea Figueroa
//HW 10- Binary IO
//Programming Exercise 17.2
//Spring 2023
//COSC 1174
//*****************
import java.io.*;
import java.util.Random;

public class Exercise_17_2 {
	public static void main(String[] args) {
		Random rand = new Random();
		try {
			//Creates the file/appends if already exists 100 random integers
			DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_02.dat", true));
			for(int x=0; x<100; x++) {
				output.writeInt(rand.nextInt(100)+1);
			}
			
			//Extra bit: prints out to console the 100 integers added into the file
			DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_02.dat"));
			for(int x=1; x<=100; x++) {
				System.out.print(input.readInt() + " ");
				if(x%10==0) {
					System.out.println();
				}
			}
			/////////////////
			
			output.close();
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
