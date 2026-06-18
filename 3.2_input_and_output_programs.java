import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	roundNumbers();
	centsToDollars();
	calculateChange();
	calculateInterest();
    }

    // Input: Null
    // Processinng: Round the numbers appropriately
    // Output: numbers
    // SET numbers TO {8.5467, 9.6382, 18.5146, 125.496}
    // DISPLAY numbers[0] WITH field_size = 10, decimal places = 3
    // DISPLAY numbers[1] WITH field_size = 8, decimal places = 5
    // DISPLAY numbers[2] WITH field_size = 6, decimal places = 1        
    // DISPLAY numbers[3] WITH field_size = 3, decimal places = 1
    // END
    public static void roundNumbers() {
	double[] numbers = {8.5467, 9.6382, 18.5146, 125.496};

	// Output formatted
	System.out.format("%10.3f%n", numbers[0]);
	System.out.format("%8.5f%n", numbers[1]);
	System.out.format("%6.1f%n", numbers[2]);
	System.out.format("%3.1f%n", numbers[3]);
    }

    // Input: Number
    // Processing: Figure out how mmany dollars are contained within
    // Output: Dollars and cents
    // SET cents TO user_input
    // SET dollars TO TRUNCATE CALCULATE cents / 100
    // SET cents TO CALCULATE cents - (dollars * 100)
    // DISPLAY cents
    // DISPLAY dollars
    // END
    public static void centsToDollars() {
	Scanner scanner = new Scanner(System.in);


	System.out.println("Please enter the number of cents you have.");
	int cents = Integer.parseInt(scanner.nextLine());

	// Calculates the number of dollars and cents
	int dollars = cents / 100;
	cents = cents - (dollars * 100);
	
	System.out.format("You have %d dollars and %d cents%n", dollars, cents);
    }

    // Input: Number
    // Processing: Figure out how much chhange you have
    // Output: how much change you have
    // SET cents TO user_input
    // SET toonies TO TRUNCATE CALCULATE cents / 200
    // SET cents TO cents - (toonies * 200)
    // SET loonies TO TRUNCATE CALCULATE cents / 100
    // SET cents TO cents - (loonies * 100)
    // SET quarters TO TRUNCATE CALCULATE cents / 25
    // SET cents TO cents - (quarters * 25)
    // SET dimes TO TRUNCATE CALCULATE cents / 10
    // SET cents TO cents - (dimes * 10)
    // SET nickels TO TRUNCATE CALCULATE cents / 5
    // SET cents TO cents - (nickels * 10)
    // DISPLAY toonies
    // DISPLAY loonies
    // DISPLAY quarters
    // DISPLAY dimes
    // DISPLAY nickels
    // END 
    public static void calculateChange() {
	Scanner scanner = new Scanner(System.in);

	int cents = Integer.parseInt(scanner.nextLine());

	// Calculate change (main logic)
	int toonies = cents / 200;
	cents = cents - toonies * 200;
	int loonies = cents / 100;
	cents = cents - loonies * 100;
	int quarters = cents / 25;
	cents = cents - quarters * 25;
	int dimes = cents / 10;
	cents = cents - dimes * 10;
	int nickels = cents / 5;
	cents = cents - nickels * 5;

	// Output
	System.out.format("Your change is %d toonies, %d loonies, %d quarters, %d dimes, %d nickels, and %d pennies.%n", toonies, loonies, quarters, dimes, nickels, cents);
    }

    // Input: Initial value, interest rate
    // Processing: Calculate intermediate values
    // Output: Table of values
    // SET interest_rate TO user_input
    // SET initial_value TO user_input
    // SET current_value TO initial_value
    // FOR i FROM 1 TO 10
    // SET interest_gained TO current_value * interest_rate
    // SET current_value TO current_value + interest_gained
    // DISPLAY i, initial_value, interest_gained, current_value
    // ENDFOR
    // END
    public static void calculateInterest() {
	Scanner scanner = new Scanner(System.in);

	System.out.println("Please give me the interest rate");
	double interest_rate = Double.parseDouble(scanner.nextLine());
	System.out.println("Please give me the initial value");
	double initial_value = Double.parseDouble(scanner.nextLine());
	double current_value = initial_value;
	double interest_gained;

	System.out.format("%-2s %20s %20s %20s%n", "Year", "Initial Value", "Interest Gained", "Total Value");

	for (int i = 1; i < 11; i++) {
	    interest_gained = current_value * interest_rate;
	    current_value = current_value + interest_gained;
	    System.out.format("%-2d %20.2f %20.2f %20.2f%n", i, initial_value, interest_gained, current_value);
	}
    }
	


}
