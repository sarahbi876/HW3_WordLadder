/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Sarah Bi
 * sb48785
 * 16330
 * Max Winthrow
 * <Student2 EID>
 * 16330
 * Slip days used: <0>
 * Git URL:
 * Spring 2020
 */


package assignment3;
import java.util.*;
import java.io.*;

public class Main {
	
	// static variables and constants only here.
	
	public static void main(String[] args) throws Exception {
		
		// 0. Initialize Scanner here 
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file, for student testing and grading only
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default input from Stdin
			ps = System.out;			// default output to Stdout
		}
		
		// 1. Initialize other variables 
		initialize();
		
		// 2. Get start and end words 
		ArrayList<String> startEndWords = parse(kb);
		
		// Check if user entered /quit 
		if (startEndWords.isEmpty() == false) {
			
			// 3. Find ladder between words (using DFS) 
			getWordLadderDFS(startEndWords.get(0), startEndWords.get(1));
			System.out.println("at DFS ladder");
			
			// 4. Find ladder between words (using BSF)
			getWordLadderBFS(startEndWords.get(0), startEndWords.get(1));
			System.out.println("at BFS ladder");
			
		}
		
	}
	
	public static void initialize() {
		// initialize your static variables or constants here.
		// We will call this method before running our JUNIT tests.  So call it 
		// only once at the start of main.
		
		// Set <String> dictionary = makeDictionary();
		
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		
		// Create array list to hold the start and end words given by user 
		ArrayList<String> startEndWords = new ArrayList<String> (); // create array list to hold the start and end words 
		
		// Read user input for the words they give
		String inputWords = keyboard.nextLine();

		// If command is quit, return empty ArrayList 
		if (inputWords.equals("/quit")) {
			
			return startEndWords; 
		}
		
		// If command is not quit, return the start and end words 
		else {
			
			// Split input into separate start word and end word 
			StringTokenizer st = new StringTokenizer(inputWords);
			while (st.hasMoreTokens()) {
				startEndWords.add(st.nextToken());
			}
			return startEndWords;
		}

	}
	
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		
		// Returned list should be ordered start to end.  Include start and end.
		// If ladder is empty, return list with just start and end.
		// TODO some code
		
		return null; // replace this line later with real return
	}
	
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		
		// TODO some code
		
		return null; // replace this line later with real return
	}
    
	
	public static void printLadder(ArrayList<String> ladder) {
		
	}
	// TODO
	// Other private static methods here


	/* Do not modify makeDictionary */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
}
