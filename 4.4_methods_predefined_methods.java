import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		guessingGame();
		calculator();
		sentenceSearch();
	}

	public static void guessingGame() {
		Scanner scanner = new Scanner(System.in); // Creates a new scanner to read input
		Random rand = new Random(); // Creates a psuedo-random number generator

		System.out.print("Welcome to the Guessing Game!\n");
		int correctNumber = rand.nextInt(10) + 1; // Generates a random number from 0 to 9 and then increments it
		int guess = -1; // Initializes the guess to negative one (i.e. a number impossible for the correct number)
		System.out.print("Guess a number between 1 and 10.  Enter 0 to quit.\n");
		while (guess != correctNumber) {
			System.out.print("Enter your guess: ");
			guess = Integer.parseInt(scanner.nextLine()); // No input validation, will crash on invalid input
			if (guess == 0) {
				break;
			}
			if (guess == correctNumber) {
				System.out.print("Congratulations!\n");
				break;
			}
			// I don't very much like this control flow because it relegates the happy path (guessing the correct number) to a branch when really it should be the root
			System.out.print("Try again.\n");
		}
	}

	public static void calculator() {
		Scanner scanner = new Scanner(System.in); // Creates a new scanner to read input

		System.out.print("Welcome to my calculator program!\n");
		System.out.print("What operation would you like to perform today?  (Select by typing the letter in front of the operation)\n");
		System.out.print("a. add\n");
		System.out.print("b. subtract\n");
		System.out.print("c. multiply\n");
		System.out.print("d. divide\n");
		System.out.print("e. absolute value\n");
		System.out.print("f. round\n");
		System.out.print("g. raise to an exponent\n");
		System.out.print("h. square root\n");

		String inputString = scanner.nextLine();
		char input = inputString.charAt(0);

		switch (input) {
			case 'a': {
				System.out.print("Please give me two numbers on different lines.\n");
				double x = Double.parseDouble(scanner.nextLine());
				double y = Double.parseDouble(scanner.nextLine());
				double z = x + y;
				System.out.format("The sum of %.2f and %.2f is %.2f%n", x, y, z);
				break;
			}
			case 'b': {
				System.out.print("Please give me two numbers on different lines.\n");
				double x = Double.parseDouble(scanner.nextLine());
				double y = Double.parseDouble(scanner.nextLine());
				double z = x - y;
				System.out.format("The difference between %.2f and %.2f is %.2f%n", x, y, z);
				break;
			}
			case 'c': {
				System.out.print("Please give me two numbers on different lines.\n");
				double x = Double.parseDouble(scanner.nextLine());
				double y = Double.parseDouble(scanner.nextLine());
				double z = x * y;
				System.out.format("The product of %.2f and %.2f is %.2f%n", x, y, z);
				break;
			}
			case 'd': {
				System.out.print("Please give me two numbers on different lines.  The second number MUST NOT be equal to zero.\n");
				double x = Double.parseDouble(scanner.nextLine());
				double y = Double.parseDouble(scanner.nextLine());
				double z = x / y;
				System.out.format("The quotient of %.2f and %.2f is %.2f%n", x, y, z);
				break;
			}
			case 'e': {
				System.out.print("Please give me one number.\n");
				double x = Double.parseDouble(scanner.nextLine());
				double z = Math.abs(x);
				System.out.format("The absolute value of %.2f is %.2f%n", x, z);
				break;
			}
			case 'f': {
				System.out.print("Please give me one number.\n");
				double x = Double.parseDouble(scanner.nextLine());
				long z = Math.round(x);
				System.out.format("Rounding %.2f gives %d", x, z);
				break;
			}
			case 'g': {
				System.out.print("Please give me one number, greater than or equal to zero.\n");
				double x = Double.parseDouble(scanner.nextLine());
				double z = Math.sqrt(x);
				System.out.format("The square root of %.2f is %.2f", x, z);
				break;
			}
		}
	}

	public static void sentenceSearch() {
		Scanner scanner = new Scanner(System.in); // Initializes scanner to read input
		
		System.out.print("\nPlease enter a sentence: ");
		String x = scanner.nextLine();
		System.out.print("\nPlease enter a word to search for in your sentence: ");
		String y = scanner.nextLine();
		if (x.contains(y)) {
			System.out.print("\nThe second string is contained in the first string");
			return;
		}
		System.out.print("\nThe second string is not contained in the first string.");
	}

}
