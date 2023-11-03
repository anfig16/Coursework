/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 4
 * Due: 9/20/2023
 * Submitted: 9/19/2023
 * Prompts user to enter a U.S. state (must be spelled 
 * correctly and first letter capitalized), then displays 
 * its capital if the state entered is real, else
 * it prints an error message*/
import java.util.*;

public class MapOfStatesAndreaFigueroa {
	public static void main(String args[]) {
		String[][] stateCapital = {{"Alabama", "Montgomery"},{"Alaska", "Juneau"},{"Arizona", "Phoenix"},{"Arkansas", "Little Rock"},{"California", "Sacramento"},{"Colorado", "Denver"},{"Connecticut", "Hartford"},{"Delaware", "Dover"},{"Florida", "Tallahassee"},{"Georgia", "Atlanta"},{"Hawaii", "Honolulu"},{"Idaho", "Boise"},{"Illinois", "Springfield"},{"Indiana", "Indianapolis"},{"Iowa", "Des Moines"},{"Kansas", "Topeka"},{"Kentucky", "Frankfort"},{"Louisiana", "Baton Rouge"},{"Maine", "Augusta"},{"Maryland", "Annapolis"},{"Massachusettes", "Boston"},{"Michigan", "Lansing"},{"Minnesota", "Saint Paul"},{"Mississippi", "Jackson"},{"Missouri", "Jefferson City"},{"Montana", "Helena"},{"Nebraska", "Lincoln"},{"Nevada", "Carson City"},{"New Hampshire", "Concord"},{"New Jersey", "Trenton"},{"New York", "Albany"},{"New Mexico", "Santa Fe"},{"North Carolina", "Raleigh"},{"North Dakota", "Bismark"},{"Ohio", "Columbus"},{"Oklahoma", "Oklahoma City"},{"Oregon", "Salem"},{"Pennslyvania", "Harrisburg"},{"Rhode Island", "Providence"},{"South Carolina", "Columbia"},{"South Dakota", "Pierre"},{"Tennessee", "Nashville"},{"Texas", "Austin"},{"Utah", "Salt Lake City"},{"Vermont", "Montpelier"},{"Virginia", "Richmond"},{"Washington", "Olympia"},{"West Virginia", "Charleston"},{"Wisconsin", "Madison"},{"Wyoming", "Cheyenne"}};
		Map<String, String> hashMap = new HashMap<>();
		
		//Puts all states and their corresponding capitals from the array to the hashMap
		for(int x=0; x<stateCapital.length; x++) {
			hashMap.put(stateCapital[x][0], stateCapital[x][1]);
		}
		
		//User input
		Scanner scan = new Scanner(System.in);
		String state;
		System.out.print("Enter a state: ");
		state = scan.nextLine();
		
		//If the state entered by the user is a real state,
		//its capital is printed, otherwise the error message is printed
		if(hashMap.containsKey(state)) {
			System.out.println(hashMap.get(state));
		} else {
			System.out.println("No such state");
		}
		
	}
}
