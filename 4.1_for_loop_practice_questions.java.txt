import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		backwardsCount();
		oddsAndEvens();
		loopBetweenTwoNumbers();
		summation();
		asciiInterpolation();
	}

	// Input: 100
	// Processing: Find all of the multiples of 5 between 100 and 0 (inclusive)
	// Output: All of the multiples found in the previous line
	// FOR i FROM 100 TO 0 DECREMENT 5
	//     DISPLAY 'i '
	// ENDFOR
	// END
	public static void backwardsCount() { // Beginning of method
		for (int i = 100; i >= 0; i = i - 5) {  // Initializes i to 100, repeats until i is equal to 0, decrements by 5 each iteration
							// Start of repeating block
			System.out.format("%d ", i); // Prints i
		} // End of repeating block
		System.out.print("\n"); // Output hygiene
	} // ENd of method
	
	// Input: Two odd numbers
	// Processing: Find all of the multiples between those two numbers
	// Output: All of the numbers found during processing
	// SET x TO user_input
	// SET y TO user_input
	// FOR i FROM (x+1) TO (y+1) INCREMENT 2
	//    DISPLAY "i "
	// ENDFOR
	// END
	public static void oddsAndEvens() { // Beginning of method
		Scanner scanner = new Scanner(System.in); // Initializes Scanner used for retrieving input
                // Blank line for readability
		int x = 1;
		int y = 0;
                // Blank line for readability
		// Get max and min
		while (x >= y) { // Input validation
			System.out.println("Please give an odd number which will serve as the lower bound"); // Asks the user to give an odd number
			x = Integer.parseInt(scanner.nextLine()); // Reads input and casts it to an integer
			System.out.println("Please give an odd number which will serve as the upper bound");// Asks the user to give an odd number
			y = Integer.parseInt(scanner.nextLine()); // Reads input and casts it to an integer
		} // End of input validation
                // Blank line for readability
                // Blank line for readability
		// Main processing
		for (int i = x+1; i < y; i += 2) { // Initializes i to the number above x
			System.out.format("%d ", i); // Outputs the multiple of 2
		} // End loop
		System.out.print("\n"); // Output hygiene
	} // End of method
	
	// Input: Two numbers
	// Processing: Ensure that one is greater than the other, and then find all of the numbers between the two numbers
	// Output: Print all of those numbers
	// SET is_valid TO false
	// WHILE is_valid IS false
	//     SET x TO user_input 
	//     SET y TO user_input
	//     IF x LESS THAN y
	//         SET is_valid TO true
	//     ENDIF
	//     ELSE 
	//         DISPLAY "Enter valid numbers please"
	//     ENDELSE
	// ENDWHILE
	//
	// FOR i FROM x TO y INCREMENT 1
	//     DISPLAY i
	// ENDFOR
	// END
	public static void loopBetweenTwoNumbers() { // Beginning of method
		Scanner scanner = new Scanner(System.in); // Initializes Scanner used for retrieving input
                // Blank line for readability
		// Initializes x and y
		int x;
		int y;
                // Blank line for readability
                // Blank Line for Readability
		while (true) { // Begins input loop
			System.out.println("Please enter a lower bound for the printed numbers"); // Asks the user for a lower bound
			x = Integer.parseInt(scanner.nextLine()); // Reads input and casts to integer
			System.out.println("Please enter a upper bound for the printed numbers"); // Asks user for an upper bound
			y = Integer.parseInt(scanner.nextLine()); // Reads input and casts to integer
			// Blank Line for Readability
			if (x < y) {  // Input validation
				break; // Breaks out of loop if input is valid
			} // Ends if condition
		} // Ends input loop
                // Blank Line for Readability
		for (int i = x; i <= y; i++) { // Begins for loop
			System.out.println(i); // Prints current number
		} // Ends for loop
                // Blank Line for Readability
	} // End of method
	
	// Input: number N and N more numbers
	// Processing: Add all N numbers
	// Output: The sum of the N numbers
	// SET n TO user_input
	// SET sum TO 0
	// FOR i FROM 0 TO N INCREMENT 1
	//     SET sum TO CALCULATE sum + user_input
	// ENDFOR
	// DISPLAY sum
	// END
	public static void summation() { // Beginning of method
		Scanner scanner = new Scanner(System.in); // Initializes scanner used for retrieving input
                // Blank line for readability
		System.out.println("Please tell me how many numbers you want summed together."); // Asks the user for N
		int n = Integer.parseInt(scanner.nextLine()); // Reads input and casts to integer
		int sum = 0; // Initializes sum to 0
                // Blank line for readability
		for (int i = 0; i < n; i++) { // Begins for loop 0 to N
			sum = sum + Integer.parseInt(scanner.nextLine()); // Adds user input to sum
		}  // Ends for loop
                // Blank line for readability
		System.out.println(sum); // Displays the sum
	} // End of method

	// Input: Two numbers x and y between 32 and 126
	// Processing: Loop between those two numbers and outputs the corresponding ASCII characters
	// Output: Those interpolated characters
	// is_valid = false
	// WHILE is_valid IS false
	//     SET x TO user_input
	//     SET y TO user_input
	//     IF (x >= 32) AND (y <= 126) AND (x < y)
	//         SET is_valid TO true
	//     ENDIF
	// ENDWHILE
	//
	// FOR i FROM x TO y
	//     DISPLAY "i = char(i) WHERE i = i AND char(i) = char(i)
	// ENDFOR
	// END
	public static void asciiInterpolation() { // Beginning of method
		Scanner scanner = new Scanner(System.in); // Initializes scanner used for retrieving input
                // Blank line for readability
		// Initializes variables
		int x;
		int y;
                // Blank line for readability
		while (true) { // Traps the user until they give valid input
			System.out.format("Please enter a number between 32 and 126 (inclusive)%n"); // Prompts user for input
			x = Integer.parseInt(scanner.nextLine()); // Reads input and casts to integer
			System.out.format("Please enter a number between %d and 126 (inclusive)%n", Math.max(x, 32)); // Prompts user for input
			y = Integer.parseInt(scanner.nextLine()); // Reads input and casts to integer
                // Blank line for readability
			if ((x >= 32) && (y <= 126) && (x <= y)) { // Validates input
				break; // Exits loop if valid
			} // End of if block
		} // End of while block
                // Blank line for readability
		for (int i = x; i <= y; i++) { // Loops through all numbers between x and y inclusive
			System.out.format("%d = %c%n", i, (char) i); // Outputs the integer and its character equivalent
		} // Ends for loop
	} // Ends method

} // Ends class
