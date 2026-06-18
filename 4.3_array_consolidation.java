import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		shoppingCart();
	}

	// Input: Names of products, number of items, price of each item
	// Processing: Calculate total price and discount if applicable
	// Output: Display the items, total cost, discount (if applicable), and number of items
	// SET number_of_items TO user_input
	// SET item_names TO {}
	// SET item_prices TO {}
	// FOR i FROM 0 TO number_of_items
	//     SET item_names[i] TO user_input
	//     SET item_prices[i] TO user_input
	// ENDFOR
	// SET total_price TO 0
	// FOR i FROM 0 TO number_of_items
	//     SET total_price TO total_price + item_prices[0]
	// ENDFOR
	// SET discount TO 0
	// IF total_price > 350
	//     SET discount TO total_price * 0.1
	// ENDIF
	// FOR i FROM 0 TO number_of_items
	//     DISPLAY item_names[i]
	// ENDFOR
	// DISPLAY total_price
	// IF discount > 0
	//     DISPLAY discount
	// ENDIF
	// DISPLAY number_of_items
	// END
	public static void shoppingCart() {
		Scanner scanner = new Scanner(System.in); // Initializes scanner that i sused for reading input

		System.out.println("Please give me the number of items you have purchased");
		int numItems = Integer.parseInt(scanner.nextLine()); // No input validation
								     
		String[] itemNames = new String[numItems]; // Creates a new string array for the names of the items
		double[] itemPrices = new double[numItems]; // Creates a new double array for the prices of items
		
		for (int i = 0; i < numItems; i++) { // Beginning of input loop
			System.out.format("Please give me the name of the %dth item.%n", i+1);  // This returns the wrong prefix for numbers less than four
			itemNames[i] = scanner.nextLine(); // Reads the input and sets it to the name, no input validation needed since it's string -> string

			System.out.format("Please tell me how much you spent on %s.%n", itemNames[i]); // Asks you for how much you spent on that item
			itemPrices[i] = Double.parseDouble(scanner.nextLine()); // No input validation, will crash if input is not double
		} // Ends input loop

		double totalPrice = 0; // Sets the totalPrice to 0
		for (int i = 0; i < numItems; i++) { // Loops through item prices
			totalPrice += itemPrices[i]; // Adds the current item's price to the total
		} // Ends the loop
		double discount = 0; // Sets the discount to 0 
		if (totalPrice > 350) { // Checks if the totalPrice is greater than 350
			discount = totalPrice * 0.1; // Sets the discount to 10% of the total price
		} // Ends the if block
		
		System.out.print("Your shopping cart includes:\n"); // Prints "Your shopping cart includes:\n"
		for (int i = 0; i < numItems; i++) { // Loops through the items
			System.out.format("- %s%n", itemNames[i]); // Prints them on their own line with a bullet
		} // Ends the loo
		System.out.format("The total cost of this shopping trip was $%.2f.%n", totalPrice); // Prints "The total cost of this shopping trip was $%.2f.%n", where %.2f is the totalPrice truncated to two decimal places
		if (discount > 35) { // Checks if the discount is greater than 35 dollars
			System.out.format("You are eligible for a discount of %.2f.%n", discount); // Prints "You are eligible for a discount of %.2f.%n" where %.2f is the discount truncated to two decimal places
		} // Ends the if block
		System.out.format("The total amount of items in your shopping cart is %d", numItems); // Prints "The total amount of items in your shopping cart is %d" where %d is the number of items
	} // Ends the method
		

}
