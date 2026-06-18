import java.util.Scanner;
class Main {
	public static void main (String[] args) {
		hungerMessages();
		gas();
	}

	// Input: Number from one to ten
	// Processing: Null
	// Output: Messages
	// SET hunger TO user_input
	// IF hunger >= 5
	//     DISPLAY "Please eat!"
	// ENDIF
	// ELSE IF HUNGER < 5
	//     DISPLAY "You are not really that hungry."
	// ENDIF
	// END
	
	public static void hungerMessages() {
		Scanner scanner = new Scanner(System.in); // Initializes scanner to read input
		System.out.println("How hungry are you on a scale from 1 to 10?"); // Asks the usre for their level of hunger
		int hunger = Integer.parseInt(scanner.nextLine()); // Reads the input and parses it to an input.  If the input is not an integer, then the program will crash
		if (hunger >= 5) { // Checks if hunger >= 5
			System.out.println("Please eat!!"); // If so, asks the user to eat
		} else if (hunger < 5) { // Checks if the user's hunger is less than 5.  This could technically be an else statement as this covers all of the possibilities when the first condition is false, but I decided to use an else if for clarity
			System.out.println("You are not really that hunger."); // Tells the user that they are not that hungry
		} // Ends the else if block
	} // Ends the method

	// Input: Capacity of gas tank in litres, percentage amount of gas in the tank, gas mileage
	// Processing: Figure out if there's enough gas to travel 200 kilometres
	// Output: Get Gas or Safe To Proceed
	// SET capacity TO user_input
	// SET percentage_in_tank TO user_input
	// SET mileage TO user_input
	// SET miles_left TO CALCULATE (capacity * percentage_in_tank) * mileage
	// IF miles_left - 200 < 0
	//     DISPLAY "Get Gas" 
	// ENDIF
	// ELSE 
	//     DISPLAY "Safe To Proceed"
	// ENDELSE
	// END
	public static void gas() {
		Scanner scanner = new Scanner(System.in);  // Initializes scanner for reading input
		System.out.println("What is the capacity of your tank?"); // Asks the user for the capacity of their tank
		// NOTE: We don't catch errors in parsing here, so if the user does not enter and integer the program will crash
		int capacity = Integer.parseInt(scanner.nextLine());
		System.out.println("How full is your tank (percentage)?");
		int percentage_in_tank = Integer.parseInt(scanner.nextLine());
		System.out.println("What is the mileage of your car?");
		int mileage = Integer.parseInt(scanner.nextLine());
		int miles_left = mileage * (capacity * percentage_in_tank); // Calculates the miles left as the number of gallons of gas (capacity multiplied by how much is in the tank) multiplied by the mileage
		if (miles_left - 200 < 0) { // Checks if there are fewer than 200 miles left
			System.out.println("Get Gas");
		} else { // This block triggers when there are greater than 200 miles left
			System.out.println("Good to go!!");
		}
	}

}
