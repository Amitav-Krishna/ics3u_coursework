import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		power();
		fibonacci();
		countdown();
		sum_evens();
	}
	
	// Input: A base and an exponent
	// Processing: Repeatedly multiply the base by itself a number of times equal to the exponent
	// Output: The result
	// SET base TO user_input
	// SET exponent TO user_input
	// SET final_result TO 1
	// SET negative_exponent TO false
	// IF exponent < 0
	//     SET negative_exponent TO true
	//     SET exponent TO CALCULATE 0 - exponent
	// ENDIF
	// WHILE exponent > 0
	//     SET final_result TO CALCULATE final_result * base
	// ENDWHILE
	// IF negative_exponent = true
	//     SET final_result TO CALCULATE 1 / final_result
	// ENDIF
	// DISPLAY final_result
	// END
	public static void power() { // Begins method
		Scanner scanner = new Scanner(System.in); // Create scanner for reading in input
                // Blank line for readability
		System.out.println("Give me the base"); // Asks user for base
		double base = Double.parseDouble(scanner.nextLine());  // Reads next line and casts to double			
		System.out.println("Give me the exponent"); // Asks user for the exponent
		int exponent = Integer.parseInt(scanner.nextLine());  // Reads next line and casts to double			
                // Blank line for readability
		double final_result = 1; // Initializes final result
		boolean negative_exponent = false; // Initializes negative_exponent variable
                // Blank line for readability
		if (exponent < 0) { // Checks for negative exponent
			negative_exponent = true; // Toggles negative exponent 
			exponent = 0 - exponent; // Sets exponent to its negative (i.e. makes it positive)
		} // Ends if block
                // Blank line for readability
		int i = 0;
		while (exponent - i > 0) { // Runs the repeated multiplication
			final_result = final_result * base; // Body of the exponent loop
			i++;
		} // Ends the exponentiation
                // Blank line for readability
		if (negative_exponent == true) { // Checks if the exponent was negative
			final_result = 1 / final_result; // Applies the appropriate calculation
		} // Ends the if block
                // Blank line for readability
		System.out.format("%.2f to the power of %d is: %.2f%n", base, exponent, final_result); // Outputs the result
	}

	// Input: Upper bound for fibonacci series
	// Processing: Calculate all intermediate values
	// Output: All intermediate values
	// SET limit TO user_input
	// SET fib_n-2 TO 0
	// SET fib_n-1 TO 1
	// SET fib_n TO 1
	// DISPLAY fib_n-2
	// DISPLAY fib_n-1
	// WHILE fib_n < limit
	//     DISPLAY fib_n
	//     SET fib_n-2 TO fib_n-1
	//     SET fib_n-1 TO fib_n
	//     SET fib_n TO fib_n-2 + fib_n-1
	// ENDWHILE
	// END
	public static void fibonacci () { // Begins method
		Scanner scanner = new Scanner(System.in); // Initializes scanner for reading input
                // Blank line for readability
		System.out.println("Give me the limit for the Fibonacci series");
		int limit = Integer.parseInt(scanner.nextLine()); // Reads input and sets it to the limit
		int fib_nminustwo = 0; // Initializes fib_n-two
		int fib_nminusone = 1; // Initializes fib_n-one
		int fib_n = 1; // Initializes fib_n
                // Blank line for readability
		System.out.format("%d ", fib_nminustwo); // Prints fib_n-two
		System.out.format("%d ", fib_nminusone); // Prints fib_n-one
                // Blank line for readability
		while (fib_n < limit) { // Repeats while the nth fibonacci number is under the limit
			System.out.format("%d ", fib_n); // Outputs the nth fibonacci number
			fib_nminustwo = fib_nminusone; // Sets the n-2th fibonacci number to the current n-1st fibonacci number
			fib_nminusone = fib_n; // Sets the n-1st fibonacci number to the current nth fibonacci number
			fib_n = fib_nminustwo + fib_nminusone; // Sets the nth fibonacci number to the current n-2th fibonaccci number plus the n-1st fibonacci number
		} // Ends while block
		System.out.print('\n'); // Output hygiene
	} // Ends method
	
	// Input: Positive integer
	// Processing: Countdown
	// Output: the numbers
	// DO 
	//     DISPLAY "Give me a positive integer to count down from"
	//     SET element TO user_input
	// WHILE NOT element.isPositiveInteger
	// DISPLAY "Counting down from element"
	// WHILE element >= 0
	//     DISPLAY element
	//     SET element TO CALCULATE element - 1
	// ENDWHILE
	// END
	public static void countdown() { // Begins method
		Scanner scanner = new Scanner(System.in); // Initializes scanner for reading input
                // Blank line for readability
		int element = 0; // Initializes element
		do { // Input validation
			System.out.println("Give me a positive integer to countdown from"); // Asks the user for input
			try { // Tries the following code
				element = Integer.parseInt(scanner.nextLine()); // Tries to parse input into an integer
			} catch (NumberFormatException e) { // Is caught if the input is not an integer
				element = -1; // Sets the element to -1 so that it will ontinue the loop while preserving type safety
			} // Ends catch block
		} while (element < 0); // Repeat condition
		System.out.format("Counting down from %d", element); // Tells the user what you are counting down from	
		while (element >= 0) { // Continues while element is greater than 0
			System.out.println(element); // Prints the current element
			element = element - 1; // Decrements element
		} // Ends while block
	} // Ends method
	
	// Input: Positive integer
	// Processing: gets sum of all even numbers from 1 to that number
	// Output: The sum
	// SET x TO user_input
	// SET sum TO 0
	// SET i TO 0
	// WHILE i <= (x/2)
	//     SET sum TO CALCULATE sum + (i*2)
	//     SET i TO i + 1
	// ENDWHILE
	// DISPLAY sum
	// ENDWHILE
	// END
	public static void sum_evens() { // Begins method
		Scanner scanner = new Scanner(System.in); // Initialize a scanner for reading input
                // Blank line for readability
		System.out.println("Give me the upper bound for the numbers to sum");
		int x = Integer.parseInt(scanner.nextLine()); // Read input and parses to an integer, no input validation so will crash on invalid input :^(
		int sum = 0;
		int i = 0;
		while (i <= (x/2)) {
			sum = sum + (i*2);
			i = i + 1;
		}
		System.out.println(sum);
	}
}


