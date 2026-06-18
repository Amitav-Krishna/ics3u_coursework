import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		segregated_sum();
		compound_interest();
	}

	// Input: Lower and upper bound for the range, as well as an arbitrary number of numbers
	// Processing: Segregate the numbers based on whether they are or are not within the range and take the sum in either case
	// Output: the sums
	// SET range_lower TO user_input
	// SET range_upper TO user_input
	// SET inside_sum TO 0
	// SET outside_sum TO 0
	// SET x TO 1
	// WHILE x != 0
	//     SET x TO user_input
	//     IF (x <= range_upper) AND (x >= range_lower)
	//         SET inside_sum TO CALCULATE inside_sum + x
	//     ENDIF 
	//     ELSE 
	//         SET outside_sum TO CALCULATE outside_sum + x
	//     ENDELSE
	// ENDWHILE
	// DISPLAY inside_sum
	// DISPLAY outside_sum
	// END
	public static void segregated_sum() { // Begins method
		Scanner scanner = new Scanner(System.in); // Initialize scanner to read input
                // Blank line for readability
		System.out.print("Enter an integer for the start of the range: ");
		int range_lower = Integer.parseInt(scanner.nextLine()); // No input validation
		System.out.print("Enter an integer for the end of the range: ");
		int range_upper = Integer.parseInt(scanner.nextLine()); // No input validation
                // Blank line for readability
		int inside_sum = 0; // Initializes sum to 0
		int outside_sum = 0; // initializes sum to 0
		int x = 1; // Initialize x
			  
		while (x != 0) {
			x = Integer.parseInt(scanner.nextLine()); // No input validation
			if ((x <= range_upper) && (x >= range_lower)) {
				inside_sum += x; // Adds x to the inside sum if it's inside the range
			} else {
				outside_sum += x; // This runs even if x is 0, but it's fine because outside_sum + 0 = outside_sum ∀ outside_sum
			} 
		}
                // Blank line for readability
		System.out.format("The sum of numbers inside of the range is %d%n", inside_sum);
		System.out.format("The sum numbers outside of the range is %d%n", outside_sum);
	} // End method
	
	// Input: Principal, interest, amount necessary for post-secondary
	// Processing: Repeatedly apply interest
	// Output: Number of times interest was applied
	// SET capital TO user_input
	// SET interest TO user_input
	// SET amount_needed_for_postsecondary TO user_input
	// SET i TO 0
	// WHILE (capital < amount_needed_for_post-secondary)
	//     capital = capital + (capital * interest)/100
	//     SET i TO i + 1
	// ENDWHILE
	// DISPLAY i
	public static void compound_interest() { // begins method
		Scanner scanner = new Scanner(System.in); // Initialize scanner to read input
                // Blank line for readability
		System.out.print("Please give me your starting capital: ");
		int capital = Integer.parseInt(scanner.nextLine()); // No input validation
		System.out.print("Please give me your interest rate as a percentage: ");
		int interest = Integer.parseInt(scanner.nextLine()); // No input validation
		System.out.print("Please give me the amount of money you need for your post-secondary education: ");
		int amount_needed = Integer.parseInt(scanner.nextLine()); // No input validation
		int years = 0; 
                // Blank line for readability
		while (capital < amount_needed) {
			capital = capital + (interest * capital)/100;
			years++;
		}
		System.out.println(years);
	} // Ends method
}
