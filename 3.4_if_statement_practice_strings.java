import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		sweaters();
		car_dealership();
	}

	// Input: String
	// Processing: Check if it's black, blue, red, white, or invalid
	// Output: Appropriate string
	//
	// DISPLAY "Please choose a sweater colour from the available choices: Blue, Black, Red, White"
	// IF user_input == "black" OR user_input == "white"
	//     DISPLAY "You have enough sweaters in this colour"
	// ELSE IF user_input == "red"
	//     DISPLAY "This colour will look good on you."
	//     DISPLAY "How about a pair of jeans tto go with the sweater?"
	// ELSE IF user_input == "blue"
	//     DISPLAY "This colour doesn't go well with your eyes."
	// ELSE 
	//     DISPLAY "Your colour choice is invalid
	// END IF
	// END
	public static void sweaters() {
		System.out.println("Please choose a sweater colour from the available choices: blue, black, red, and white."); // asks for input
		Scanner scanner = new Scanner(System.in); // Initializes scanner
		// Blank line for readability
		// Another blank line for readability
		String colour = scanner.nextLine(); // Gets the input
               	// Blank line for readability 
		if (colour.equals("black") || colour.equals("white")) { // Checks if input is black or white
			System.out.println("You have enough sweaters in this colour"); // outputs "You have enough sweaters in this colour."
		} else if (colour.equals("red") ){ // Checks if the input is read`
			System.out.println("This colour will look good on you"); // outputs "This colour will look good on you"
			System.out.println("How about a pair of jeans to go with the sweater?"); // outputs "How about a pair of jeans to go with the sweater?"
		} else if (colour.equals("blue")) { // Checks if the input is blue
			System.out.println("This colour doesn't go well with your eyes"); // outputs "This colour doesn't go well with your eyes"
		} else { 
			System.out.println("Your choice is invalid"); // outputs "Your choice is invalid"
		}
		// Blank line for readability
	}

	// Input: "yes" or "no" four timmes
	// Process: Enable the appropriate features
	// Output:  total price
	//
	// DEFINE features_enabled AS {true, false, false, false, false}
	// DEFINE features AS {"base price", "floor mats", "navigation system", "heated leather seats", "5-year warranty"}
	// DEFINE feature_prices AS {25000, 500, 1000, 500, 2500}
	// FOR i FROM 1 TO 4
	//     DISPLAY "Would you like to buy "
	//     DISPLAY features[i]
	//     DISPLAY " (yes or no)"
	//     IF user_input == "yes"
	//         features_enabled[i] = true
	// DEFINE subtotal= 0
	// FOR i FROM 0 TO 4
	//     IF features_enabled[i] == true
	//         subtotal += feature_prices[i]
	// DEFINE tax_amount = subtotal* 0.13
	// DEFINE total_amount =subtotal + tax_amount
	// FOR i FROM 0 TO 4
	//    IF features_enabled[i] == true
	//        DISPLAY features[i] AND feature_prices[i]
	// DISPLAY "tax amount" AND tax_amount
	// DISPLAY "Total price" AND total_price
	
	public static void car_dealership() {
		boolean[] features_enabled = {true, false, false, false, false}; // Defines features_enabled as a boolean array
		String[] features = {"Base Price", "Floor Mats", "Navigation System", "Heated Leather Seats", "5-year warranty"}; // Defines features as a string array
		float[] feature_prices = {25000, 500, 1000, 500, 2500}; // Defines feature_prices as a string array
	        // Blank line for readability
		// Another blank line for readability
		Scanner scanner = new Scanner(System.in); // Defines a scanner
		for (int i = 1; i < 5; i++) { // Starts a for loop
			System.out.format("Would you like to buy %s for %f dollars? (yes or no)", features[i], feature_prices[i]); // Outputs "Would you like to buy %s for %f dollars" where %s = features[i] and %f = feature_prices[i]
		 	String response = scanner.nextLine(); // Sets response to scanner.nextLine()
			if (response.equals("yes")) { // Checks if the response is yes
				features_enabled[i] = true; // Sets features_enabled[i] to true
			} // Closes if statement
		} // Closes for loop
		// Blank line for readability
		int subtotal = 0; // Sets subtotal to 0
		for (int i = 0; i < 5; i++) { // Begins for loop from 0 to 4
		 	if (features_enabled[i] == true) { // Checks that features_enabled[i] is true
				subtotal += feature_prices[i]; // Adds feature_prices[i] to subtotal
			} // Ends if statement
		} // Ends for loop
		// Blank line for readability
		double tax_amount = subtotal * 0.13; // Sets tax_amount to subtotal * 0.13
		double total_amount = subtotal + tax_amount; // Sets total_amount to subtotal + tax_amount
		for (int i = 0; i < 5; i++) { // Begins for loop from 0 to 4
			if (features_enabled[i] == true) { // Checks that features_enabled[i] is true
				System.out.format("%-10s      %5f%n", features[i], feature_prices[i]); // Outputs "%-10s      %5f%n" where %s is features[i] and %f is feature_prices[i]
			} // Ends if statement
		} // Ends for loop
		System.out.format("%-10s     %5f%n", "13% Taxes", tax_amount); // Outputs "%-10s      %5f%n" where %s is "13% Taxes" and %f is tax_amount
	
		System.out.format("%-10s     %5f%n", "Final cost of the car", total_amount); // Outputs "%-10s      %5f%n" where %s is "Final cost of the car" and %f is total_amount
	} // Ends method


}
