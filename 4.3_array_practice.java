import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		friendArray();
		oddFunction();
		verySelfishFunction();
		rainAverages();
	}

	// Input: 10 strings that are the names of the friends
	// Processing: Reverse the array
	// Output: The reversed list
	// LEN 10 ARRAY STRING x = {}
	// FOR i FROM 1 TO 10
	//     ELEMENT i OF x = user_input
	// ENDFOR
	// FOR j FROM 1 TO 10
	//     DISPLAY ELEMENT (10-j) OF x
	// ENDFOR
	// END
	public static void friendArray() {
		Scanner scanner = new Scanner(System.in); // Initializes scanner to read input
                // Blank line for readability
		String[] x = new String[10]; // Initializes x
                // Blank line for readability
		System.out.println("Please tell me your best friends in order of length of friendship from oldest to newest on different lines.");
		for (int i = 0; i < 10; i++) { // Loops through all of the elements of x
			x[i] = scanner.nextLine(); // Sets the current element of x to the input
		} // Ends the loop
                // Blank line for readability
		System.out.println("Here are your friends listed from oldest to newest friend"); // Says "Here are your friends listed from oldest to newest friend"
		for (int i = 0; i < 10; i++) { // Starts a loop
			System.out.println(x[i]); // Prints x[i]
		} // Ends the loop
                // Blank line for readability
		System.out.println("Here are your friends listed from newest to oldest friend"); // Prints "Here are your friends listed from newest to oldest friend"
		for (int i = 0; i < 10; i++) { // Starts a loop
			System.out.println(x[(9-i)]); // Prints x[9-i]
		} // Ends loop
	} // Ends the method

	// Input: 10 numbers
	// Processing: Find the maximum 
	// Output: The maximum and all of the numbers
	// LEN 10 ARRAY DOUBLE x = {}
	// DOUBLE maximum = negative infinity
	// FOR i FROM 1 TO 10
	//     ELEMENT i OF x = user_input
	//     IF maximum < user_input
	//         SET maximum TO user_input
	//     ENDIF
	// ENDFOR
	// DISPLAY maximum
	// FOR i FROM 1 TO 10
	//     DISPLAY ELEMENT i OF x
	// ENDFOR
	public static void oddFunction() {
		Scanner scanner = new Scanner(System.in); // Initializes scanner for reading input

		double[] x = new double[10]; // Creates a new array for the numbers
		double maximum = Double.NEGATIVE_INFINITY; // Sets maximum to Double.NEGATIVE_INFINITY
		System.out.println("Please give me 10 numbers on different lines."); // Prints "Please give me 10 numbers on different lines.")
		for (int i = 0; i < 10; i++) { // Loops through every element in x
			// No input validation
			x[i] = Double.parseDouble(scanner.nextLine()); // Reads the next element of input, cast it to a double, then set it to x[i]
			if (maximum < x[i]) { // Checks if the current element is greater than the maximum
				maximum = x[i]; // Sets the maximum to the current element
			} // Ends if block
		} // Ends for loop
		System.out.println(maximum); // Prints the maximum
		for (int i = 0; i < 10; i++) { // Loops through every element in x
			System.out.println(x[i]); // Prints x[i]
		} // Ends for loop
	} // Ends method


	// Input: The arrays
	// Processing: Figure out the number for each element
	// Output: Null
	// FOR i FROM 1 TO length(Array_1)
	//     SET ELEMENT i OF Array_2 TO (25 - ELEMENT i OF Array_1)
	// ENDFOR
	// END
	public static void verySelfishFunction() // magic line
	{ // start of main method
	      // declare your 2 arrays.
	      int[] Array_1 = { 13, -22, 82, 17, 96, 45, 23, 87, -12, -71}; // Sets Array_1 to { 13, -22, 82, 17, 96, 45, 23, 87, -12, -71};
	      int[] Array_2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // Sets Array_2 to { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	  
	      for (int i = 0; i < Array_1.length; i++) { // Loops through every element in the array
		      Array_2[i] = 25 - Array_1[i]; // Sets Array_2[i] to 25 - Array_1[i]
	      } // Ends the for loop
	}// end of main method.

	// Input: 15 values
	// Processing: Compute the averages of each 5, and then the average of all 15
	// Output: The averages
	// SET april_rain TO user_input
	// SET may_rain TO user_input
	// SET june_rain TO user_input
	// SET april_average TO 0
	// SET april_sum TO 0
	// SET may_average TO 0
	// SET may_sum TO 0
	// SET june_average TO 0
	// SET june_sum TO 0
	// SET total_average TO 0
	// SET total_sum TO 0
	// FOR i FROM 1 TO LENGTH april_rain
	//     SET april_sum = april_sum + ELEMENT i OF april_rain
	// ENDFOR 
	// SET april_average TO april_sum / LENGTH april_rain
	// FOR i FROM 1 TO LENGTH may_rain
	//     SET may_sum = may_sum + ELEMENT i OF may_rain
	// ENDFOR 
	// SET may_average TO may_sum / LENGTH may_rain
	//
	// FOR i FROM 1 TO LENGTH june_rain
	//     SET june_sum = june_sum + ELEMENT i OF june_rain
	// ENDFOR 
	// SET june_average TO june_sum / LENGTH june_rain
	//
	// DISPLAY april_average
	// DISPLAY may_average
	// DISPLAY june_average
	// SET total_sum TO june_average + may_average + april_average
	// SET total_average TO total_sum / 3
	// DISPLAY total_average
	// END
	public static void rainAverages() { // Opens method
		Scanner scanner = new Scanner(System.in); // Initializes scanner for reading input
		
		double[] april_rain = new double[5]; // Initializes april_rain as an array of doubles
		double[] may_rain = new double[5];// Initializes may_rain as an array of doubles
		double[] june_rain = new double[5];// Initializes june_rain as an array of doubles

		double april_sum = 0; // Initializes april_sum to 0
		double may_sum = 0; // Initializes may_sum to 0
		double june_sum = 0; // Initializes june_sum to 0

		double april_average = 0; // Initializes april_average to 0
		double may_average = 0; // Initializes may_average to 0
		double june_average = 0; // Initializes june_average to 0

		double total_sum = 0; // Initializes total_sum to 0
		double total_average = 0; // Initializes total_average to 0

		System.out.println("Please give me 15 numbers on different lines"); // Prints "Please give me 15 numbers on different lines"
		for (int i = 0; i < april_rain.length; i++) { // Begins for loop
			april_rain[i] = Double.parseDouble(scanner.nextLine());	 // Reads the next input, casts it to a double, and sets it to april_rain[i]
		} // Ends for loop
		for (int i = 0; i < may_rain.length; i++) { // Begins for loop
			may_rain[i] = Double.parseDouble(scanner.nextLine());	//Reads the next input, casts it to a double, and sets it to may_rain[i]
		} // Ends for loop
		for (int i = 0; i < june_rain.length; i++) { // Begins for loop
			june_rain[i] = Double.parseDouble(scanner.nextLine());	// Reads the next input, casts it to a double, and sets it to june_rain[i]
		} // Ends for loop
		

		for (int i = 0; i < april_rain.length; i++) { // Begins for loop
			april_sum = april_sum + april_rain[i]; // Sets april_sum to april_sum + april_rain[i]
		} // Ends for loop 
		april_average = april_sum / april_rain.length; // Sets april_average to april_sum 
		for (int i = 0; i < may_rain.length; i++) { // Begins for loop
			may_sum = may_sum + may_rain[i]; // Sets may_sum to may_sum + may_rain[i]
		} // Ends for loop 
		may_average = may_sum / may_rain.length; // Sets may_average to may_sum 
		for (int i = 0; i < june_rain.length; i++) { // Begins for loop
			june_sum = june_sum + june_rain[i]; // Sets june_sum to june_sum + june_rain[i]
		} // Ends for loop 
		june_average = june_sum / june_rain.length; // Sets june_average to june_sum 
							    //
		System.out.format("Average rainfall for April is %.1f%n", april_average);
		System.out.format("Average rainfall for May is %.1f%n", may_average);
		System.out.format("Average rainfall for June is %.1f%n", june_average);
	
		total_average = (april_average + may_average + june_average) / 3;
		System.out.format("Total average rainfall is %.1f", total_average);
	}
}



