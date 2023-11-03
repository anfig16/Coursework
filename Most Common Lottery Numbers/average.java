package lottery;
import java.io.*;
import java.util.*;

/* Program reads a local text file with a list of winning lottery tickets
 * over the years, and finds/prints out the most common lottery numbers
 */

public class average {
	public static void main(String[] args)throws FileNotFoundException {
		File powerballNums = new File("C:/Users/anfig/Downloads/powerball nums.txt");
		Scanner console = new Scanner(powerballNums);
		int[] nums = new int[70];//70 for numbers to choose from for regular numbers
		int[] powerball = new int[27];//27 for numbers to choose from for powerball
		
		/*index is lottery num, value inside
		  is the times it has appeared in a win */
		while(console.hasNextInt()) {
			for(int x=0; x<5; x++) {
				int num = console.nextInt();
				nums[num]++;
			}
			int num2 = console.nextInt();
			powerball[num2]++;
		}
		
		//Prints out which number appears most
		System.out.println("Most common lottery numbers:");
		for(int j=0; j<20; j++) {
			int index = 0;
			int max=0;
			for(int y=0; y<nums.length; y++){
				if(nums[y]>max) {
					max = nums[y];
					index = y;
				}
			}
			System.out.print(index + " ");
			nums[index]=0;
		}
		System.out.println();
		
		//Prints out which Powerball numbers are the most common
		System.out.println("\nMost common Powerball numbers:");
		for(int q=0; q<20; q++) {
			int pIndex = 0;
			int pMax = 0;
			for(int y=0; y<powerball.length; y++) {
				if(powerball[y]>pMax) {
					pMax = powerball[y];
					pIndex = y;
				}
			}
			System.out.print(pIndex + " ");
			powerball[pIndex] = 0;
		}
		
		console.close();
	}
}
