import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		discountNutsAndBolts();
		pie();
	}

	// Input: Number of bolts, nuts, and washers`
	// Processing: Ensure that the number of bolts is less than the number of nuts and the number of washers (individually)
	// Output: The cost of the order
	// SET bolts, nuts, washers TO user_input
	// IF bolts >= nuts
	//     DISPLAY "Check your order, not enough nuts for the number of bolts
	// ENDIF
	// IF bolts >= washers
	//     DISPLAY "Check your order, not enough washers for the number of bolts
	// ENDIF
	// SET price TO CALCULATE bolts * 10 + nuts * 5 + washers * 10
	// DISPLAY price
	// END
	
	public static void discountNutsAndBolts() {
		Scanner scanner = new Scanner(System.in);

		// Reads the inputs
		int bolts = Integer.parseInt(scanner.nextLine());
		int nuts = Integer.parseInt(scanner.nextLine());
		int washers = Integer.parseInt(scanner.nextLine());

		// Set rates
		final int bolt_price = 10;
		final int nut_price = 5;
		final int washer_price = 3;

		// Ensures input validity
		if (bolts > nuts) {
			System.out.println("Check your order.  You have not ordered enough nuts for the number of bolts you have.");
		}

		if (bolts > washers) {
			System.out.println("Check your order.  You have not ordered enough washers for the number of bolts you have.");
		}

		int price = (bolts * bolt_price) + (nuts * nut_price) + (washers * washer_price); // Calculates price

		System.out.format("Your order comes to %d%n", price); // Prints output
	}

	// Input: Weight
	// Processing: Check that it's less than 105 and greater than 77kg
	// Output: Go/No Go
	// SET weight TO user_input
	// IF weight <= 105 AND weight >= 77
	//     DISPLAY "You may enter the contest"
	// ENDIF
	// ELSE
	//    DISPLAY "You are ineligible for the contest, you goober."
	// ENDELSE
	// END
	
	public static void pie() {
		Scanner scanner = new Scanner(System.in);

		// Set upper and lower bounds
		final double minimum = 77;
		final double maximum = 105;

		// Read user input
		double user_weight = Double.parseDouble(scanner.nextLine());

		// Check eligibility
		if (user_weight >= minimum && user_weight <= maximum) {
			System.out.println("You may enter the contest");
		} else {
			System.out.println("You are ineligibile, you goober");
		}
	}

}
