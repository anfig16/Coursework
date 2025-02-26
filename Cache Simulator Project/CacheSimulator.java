//**********************
// Andrea Figueroa
// Cache Simulator Project
// COSC 4310
// Professor Jiangjiang Liu
// Fall 2024
//**********************

import java.util.*;

public class CacheSimulator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Outputs to user choices available to choose from
		System.out.println("Set associativity and replacement policy options");
		System.out.println("-------------------------------------------------");
		System.out.println("1: Direct-mapped \n2: Set associative(2-way/4-way) (LRU Replacement Policy) \n3: Fully associative (LRU Replacement Policy)");
		//Prompt for user input
		System.out.print("\nEnter choice (1, 2, or 3): ");
		int setChoice = scan.nextInt();
		
		//If set associative, ask if 2-way or 4-way
		int twoOrFour = 0;
		if(setChoice == 2) {
			System.out.print("2-way or 4-way (Type 2 or 4)? ");
			twoOrFour = scan.nextInt();
		}
		
		System.out.print("Enter number of cache blocks: ");
		int cacheBlockNum = scan.nextInt();
		
		System.out.print("Enter sequence of block address references: ");
		scan.nextLine();
		String inputSequence = scan.nextLine();
		String[] sequence = inputSequence.split("[,\\s]+");
		int[] sequenceInts = new int[sequence.length];
		for(int x=0; x<sequenceInts.length; x++) {
			sequenceInts[x] = Integer.parseInt(sequence[x]);
		}
		System.out.println();
		
		
		//print out table showing results/content for each option
		//print out cache miss rate percentage
		if(setChoice == 1) {
			//directMapped content and miss rate
			directMapped(cacheBlockNum, sequenceInts);
		} else if(setChoice == 2) {
			//setAssociative content and miss rate
			setAssociative(cacheBlockNum, sequenceInts, twoOrFour);
		} else if(setChoice ==3) {
			//fullyAssociative content and miss rate
			fullyAssociative(cacheBlockNum, sequenceInts);
		}
		
	}
	
	public static void directMapped(int cacheBlockNum, int[] sequence) {

		int[][] cache = new int[sequence.length][cacheBlockNum];
		//Fill cache with -1 (placeholder value for empty/null)
		for(int x=0; x<sequence.length; x++) {
			for(int y=0; y<cache[0].length; y++) {
				cache[x][y] = -1;
			}
		}
		int missCounter = 0;
		String[] hitMiss = new String[sequence.length];
		Arrays.fill(hitMiss, "Miss");  //assume miss until hit
		
		//direct mapped process
		for(int x=0; x<sequence.length; x++) {  //for each row, each num in sequence
			//Calculate cache entry number
			int cacheColumn = sequence[x] % cacheBlockNum;
			//if hit, update hitMiss and go to next num in sequence; if miss add mem block to cache
			if(cache[x][cacheColumn] == sequence[x]) {
				hitMiss[x] = "Hit";
			}
			if(hitMiss[x] == "Miss") {
				cache[x][cacheColumn] = sequence[x];
				missCounter++;
			}

			//Copy current cache content over to next row (except when on last row)
			if(x != sequence.length-1) {
				for(int c=0; c<cacheBlockNum; c++) {
					cache[x+1][c] = cache[x][c];
				}
			}
			
		}
		printTable(sequence, cache, 1, hitMiss, missCounter, 0); //0 placeholder for set associative 2-way/4-way
	}
	
	public static void setAssociative(int cacheBlockNum, int[] sequence, int twoOrFour) {
		
		int[][] cache = new int[sequence.length][cacheBlockNum];
		//Fill cache with -1 (placeholder value for empty/null)
		for(int x=0; x<sequence.length; x++) {
			for(int y=0; y<cache[0].length; y++) {
				cache[x][y] = -1;
			}
		}
		String[] hitMiss = new String[sequence.length];
		Arrays.fill(hitMiss, "Miss");  //assume miss until hit
		int missCounter = 5;
		
		//# of sets = cache blocks available / #-way set associative(entries per set)
		//cacheColumnNum = sequence num % totalSets
		//keep track of LRU, check whole set for entries for each sequence num
		//sets ÷ cache blocks
		int sets = cache[0].length/twoOrFour; //2-way or 4-way
		int entriesPerSet = cache[0].length/sets;
		
		String[] lru = new String[cacheBlockNum];
		int index = 0;
		int[] startIndexSet = new int[sets];
		Arrays.fill(startIndexSet, -1);
		//initialize LRU value
		for(int s=0; s<sets; s++) {
			lru[index] = "lru";
			startIndexSet[s] = index;
			index = index + entriesPerSet;
		}
		
		//set associative process
		for(int x=0; x<sequence.length; x++) { //go through each sequence num/row
			//find set for sequence num
			int chosenSet = sequence[x] % sets; 
			int startIndex = startIndexSet[chosenSet];
			//Check entries available in chosen set
			int lruVal = startIndex;
			
			for(int y=startIndex; y<startIndex+entriesPerSet; y++) {  
				if(cache[x][y] == sequence[x]) {
					//hit
					hitMiss[x] = "Hit";
					missCounter--;
					//reset lru
					Arrays.fill(lru, null);
					
					if(y<=startIndex+entriesPerSet-1) {
						System.out.println();
						lru[y+1] = "lru";
						
					} else {
						lru[startIndex] = "lru";
				
					}
					break;
					
				} else {
					//miss
					if(lru[y] == "lru") {
						cache[x][y] = sequence[x];
						lru[y] = null;
						if(y!=startIndex+entriesPerSet-1) {
							lru[y+1] = "lru";
							lruVal = y+1;
						} else {
							lru[startIndex] = "lru";
							lruVal = startIndex;
						}
						break;
					}
				}
			}//end of column
			//copy over current row to next row (unless last row)
			if(x != sequence.length-1) {
				for(int c=0; c<cacheBlockNum; c++) {
					cache[x+1][c] = cache[x][c];
				}
			}
		}//end of row
			printTable(sequence, cache, 2, hitMiss, missCounter, twoOrFour);
	}

		

	public static void fullyAssociative(int cacheBlockNum, int[] sequence) {
		int[][] cache = new int[sequence.length][cacheBlockNum];
		//Fill cache with -1 (placeholder value for empty/null)
				for(int x=0; x<sequence.length; x++) {
					for(int y=0; y<cacheBlockNum; y++) {
						cache[x][y] = -1;
					}
				}
		String[] hitMiss = new String[sequence.length];
		Arrays.fill(hitMiss, "Miss");  //assume miss until hit
		int missCounter = 0;
		
		//Fully associative process
		for(int x=0; x<sequence.length; x++) { //go through each input from sequence
			for(int y=0; y<cacheBlockNum; y++) {  //cache block
				if(cache[x][y] == -1) { //if cache empty place mem block there
					cache[x][y] = sequence[x];
					missCounter++;
					break;
				} else if(cache[x][y] == sequence[x]){  //else check if hit
					hitMiss[x] = "Hit";
					break;
				}
				//if not empty and no hit, continue on next entry in cache
			}
			//copy current row to next (unless if last row)
			if(x != sequence.length-1) {
				for(int c=0; c<cacheBlockNum; c++) {
					cache[x+1][c] = cache[x][c];
				}
			}
		}
		
		printTable(sequence, cache, 3, hitMiss, missCounter, 0); //0 placeholder for set associative 2-way/4-way
	}
	
	public static void printTable(int[] sequence, int[][] cache, int option, String[] hitMiss, int missCounter, int twoOrFour) {
		//Table title depending on option
		if(option == 1) {
			System.out.println("Direct-mapped cache");
		} else if(option == 2) {
			if(twoOrFour == 2) {
				System.out.println("2-way Set associative cache");
			} else if(twoOrFour == 4) {
				System.out.println("4-way Set associative cache");
			}
		} else if(option == 3) {
			System.out.println("Fully associative cache");
		}
		
		//Table output
		//headers
		System.out.println("+-----------------------------------------------------------------------+");
		System.out.println("|Address of |   Hit or  |    Contents of cache blocks after reference   |");
		System.out.println("|memory     |   Miss    |-----------------------------------------------+");
		
		System.out.print("|block      |           |");
		
		//Cache headers for each option
		if(option == 1) {
			for(int x=0; x<cache[0].length; x++ ) {
				System.out.print("     " + x + "     |");
			}
		} else if (option == 2) {
			if(twoOrFour == 2) {
				//sets ÷ cache blocks
				int sets = cache[0].length/2; //2-way
				
				for(int x=0; x<sets; x++ ) {
					int times = cache[0].length/sets;
					for(int k=0; k<times; k++) {
						System.out.print("   Set " + x + "   |");
					}
					
				}
			} else if(twoOrFour == 4) {
				//sets ÷ cache blocks
				int sets = cache[0].length/4; //4-way
				
				for(int x=0; x<sets; x++ ) {
					int times = cache[0].length/sets;
					for(int k=0; k<times; k++) {
						System.out.print("   Set " + x + "   |");
					}
					
				}
			}
		} else if(option == 3) {
			for(int x=0; x<cache[0].length; x++ ) {
				System.out.print("  Block " + x + "  |");
			}
		}
		System.out.println();
		
		System.out.println("|accessed   |           |           |           |           |           |");
		System.out.println("+-----------------------------------------------------------------------+");
		
		//Prints out hitMiss values and cache content for each mem block addressed 
		for(int x=0; x<sequence.length; x++) {
			//prints current sequence number and hitMiss result
			System.out.print("|     " + sequence[x] + "     |");
			System.out.print("    " + hitMiss[x]);
			
			//formatting for hit/miss
			if(hitMiss[x] == "Miss") {
				System.out.print("   |"); //Miss
			} else {
				System.out.print("    |");  //Hit
			}
			
			//prints cache content
			for(int k=0; k<cache[0].length; k++) {
				if(cache[x][k] != -1) {
					System.out.print("   Mem["+ cache[x][k] +"]  |");
				} else {
					System.out.print("           |");
				}
			}
			System.out.println();
		}
		
		//End table
		System.out.println("+-----------------------------------------------------------------------+");
		
		//Calculate and display miss percentage below table
		double missPercentage = ((double)missCounter/(double)sequence.length) * 100;
		System.out.println("Miss percentage: %" + missPercentage);
	}
}
