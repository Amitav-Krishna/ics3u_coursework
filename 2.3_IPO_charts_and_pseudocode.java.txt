import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	kilogramsToPounds();
	joke();
	compareTwoNumbers();
	daysOfTheWeek();
    }

    // Input: Number
    // Processing: Multiply by 2.20462
    // Output: Number
    // SET pounds TO CALCULATE user_input * 2.20462
    // DISPLAY pounds
    // END
    public static void kilogramsToPounds() {
	System.out.println("Please enter a value in kilograms");
	Scanner scanner = new Scanner(System.in);
	double pounds = Integer.parseInt(scanner.nextLine()) * 2.20462;
	System.out.format("You have %f pounds.%n", pounds);
	
    }

    // Input: Joke
    // Processing: Null
    // Output: "That was a funny joke"
    // DISPLAY "Please enter your joke:\n"
    // DISPLAY "Wow, that was a funny joke"
    // END
    public static void joke() {
	System.out.print("Please enter your joke: ");
	Scanner scanner = new Scanner(System.in);
	String x = scanner.nextLine();
	System.out.println("Wow, that was a funny joke!");
    }

    // Input: two numbers
    // Processing: Compare them
    // Output: one number
    // SET x TO user_input
    // SET y TO user_input
    // IF x - y > 0
    // DISPLAY x
    // ENDIF
    // ELSE
    // DISPLAY y
    // END
    public static void compareTwoNumbers() {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Please enter your first number: ");
	int x = Integer.parseInt(scanner.nextLine());
	System.out.print("Please enter your second number: ");
	int y = Integer.parseInt(scanner.nextLine());

	if (x - y > 0) {
	    System.out.println(x);
	} else {
	    System.out.println(y);
	}
    }

    // Input: Day of the week
    // Processing: Check string against aray for response
    // Output: response
    // SET days_of_the_week TO {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}
    // SET responses TO {"Welcome to the first day of the week.", "One day down, four more until the weekend.", "Wednesday is hump day.", "The weekend is almost here.", "Thank God it's Friday!", "It is the weekend!", "It is the weekend!"};
    // SET input_day TO user_input
    // FOR i FROM 0 TO 6
    // IF days_of_the_week[i] == input_day
    // DISPLAY responses[i]
    // ENDIF
    //END

    public static void daysOfTheWeek() {
	System.out.println("Please enter a day of the week with the first letter capitalized");
	String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	String[] responses = {"Welcome to the first day of the week.", "One day down, four more until the weekend.", "Wednesday is hump day.", "The weekend is almost here.", "Thank God it's Friday!", "It is the weekend!", "It is the weekend!"};
	Scanner scanner = new Scanner(System.in);
	String userInput = scanner.nextLine();
	for (int i = 0; i < 7; i++) {
	    if (daysOfTheWeek[i].equals(userInput)) {
		System.out.println(responses[i]);
	    }
	}
    }

}
