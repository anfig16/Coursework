# Cache Simulator Project 
A simple cache simulator coded in Java in Eclipse. Runs in the console-asks the user to enter a set associativity option, the number of cache blocks, and a sequence of block address references, and prints out the corresponding cache content table and miss rate percentage. 

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Conclusion](#conclusion)

### Installation
	1. Download the file CacheSimulator.java
	1. Open an IDE of your choice (I used Eclipse)
	2. Open the CacheSimulator.java file in this IDE
	3. Run the CacheSimulator.java file, which should output to the console and prompt for user input
	
	
### Usage
Once you have the CacheSimulator.java file downloaded and running in your IDE, it's time to begin!

Once the program is run, the first thing outputted in the console is 3 options, which list different set associativity and replacement policy options:

	1: Direct-mapped 
	2: Set associative(2-way/4-way) (LRU Replacement Policy) 
	3: Fully associative (LRU Replacement Policy) 

The user is then prompted to choose an option (type '1' for option 1, '2' for option 2, '3' for option 3):

** Don't forget to press enter after typing your input! **
>Enter choice (1, 2, or 3): 1

Side note: if user enters option 2, the user is also prompted to choose between 2-way or 4-way set associative:
> 2-way or 4-way (Type 2 or 4)? 2

Following this, the user is also prompted to enter the number of cache blocks (example input: 4) as well as a sequence of block address references (example input: 0 8 0 6 8):
>Enter number of cache blocks: 4 

>Enter sequence of block address references: 0 8 0 6 8

After entering this data, the program outputs a table of the resulting cache content. It includes a title (the set associativity option chosen at the beginning), a table listing the cache content of each memory block reference and hit/miss value, and a miss rate percentage following the table.
	*(Screenshot outputs of example tables attached in report)*


###Conclusion
You can run this program as many times as you like, choosing between different set associativity options, cache block sizes, and block address reference sequences.

This project is meant to simulate how these different set associativity options are implemented in the cache, giving a visual output with a table.

Have fun!



By: Andrea Figueroa

Title: Cache Simulator Project

Course: COSC 4310

Professor Jiangjiang Liu

Term: Fall 2024
