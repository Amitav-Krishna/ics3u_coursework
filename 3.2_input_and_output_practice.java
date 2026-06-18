import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	happyBirthdaySong();
	provincesTerritoriesAndCapitals();
	centimetresToInches();
	reverseInput();
    }    
    // Input: Name
    // Processing: Null
    // Output: Birthday song
    // SET name TO user_input
    // PRINT Happy birthday to you!  \nHappy birthday to you!  \nHappy birthday to
    // PRINT name
    // PRINT !  \nHappy birthday to you!
    // END

	
    public static void happyBirthdaySong () {
	Scanner scanner = new Scanner(System.in); // Declares a new scanner
	String name = null; // Variable for the name
	System.out.println("What is your name?"); // Asks user for name
	name = scanner.nextLine(); // Takes input from user

	System.out.println("Happy birthday to you!  \nHappy birthday to you!  \nHappy birthday to " + name + "!  \nHappy birthday to you!"); // Prints happy birthday song
    }
    // Input: Names of provinces, territories, and capitals
    // Processing: Null
    // Output: Input
    // SET provinces TO {}
    // SET capitals TO {}    
    // FOR i FROM 0 TO 12
    // PRINT Please give me the name of the
    // PRINT (i+1)
    // PRINT th province or territory
    // SET provinces[i] TO user_input
    // ENDFOR
    // FOR j FROM 0 TO 12
    // PRINT Please give me the name of the capital of
    // PRINT provinces[j]
    // SET capitals[j] TO user_input
    // ENDFOR
    // PRINT Province/Territory                   Capital
    // FOR k FROM 0 TO 12
    // PRINT provinces[k]
    // PRINT capitals[k]
    // ENDFOR
    // END
    public static void provincesTerritoriesAndCapitals () {
	String[] provinces = {"placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder"};
	String[] capitals = {"placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder", "placeholder"};
	Scanner scanner = new Scanner(System.in);
	for (int i = 0; i <= 12; i++) {
	    System.out.println("Please give me the name of the " + (i+1) + "th province or territory.");
	    provinces[i] = scanner.nextLine();
	}

	for (int j = 0; j <= 12; j++) {
	    System.out.println("PLease give me the name of the capital of " + provinces[j] + ".");
	    capitals[j] = scanner.nextLine();
	}
	System.out.println("Province / Territory          Capital");
	for (int k = 0; k <= 12; k++) {
	    System.out.print(provinces[k]);
	    for (int l = 0; l < (30-provinces[k].length()); l++) {
		System.out.print(' ' );
	    }
	    System.out.print(capitals[k] + '\n');
	}
    }
    // Input: Number
    // Processing: convert to inches
    // Output: number
    // SET centimetres TO user_input
    // SET inches TO CALCULATE user_input * 2.54
    // DISPLAY inches
    public static void centimetresToInches() {
	final double ratio = 2.54;
	Scanner scanner = new Scanner(System.in);
	System.out.println("Give me number.");
	double centimetres = Float.parseFloat(scanner.nextLine());
	double inches = centimetres * ratio;
	System.out.println("That is " + inches + " inches");
    }
    // Input: four strings
    // Processing: Null
    // output: Line 4 -> line 3 -> line 2 -> line 1
    // SET lines TO {"placeholder", "placeholder", "placeholder", "placeholder"}
    // FOR i FROM 0 TO 3
    // SET lines[i] TO user_input
    // ENDFOR
    // FOR j FROM 3 TO 0
    // DISPLAY lines[j]
    // ENDFOR
    // END
    public static void reverseInput() {
	String[] lines = {"placeholder", "placeholder", "placeholder", "placeholder"};
	Scanner scanner = new Scanner(System.in);
	for (int i = 0; i <= 3; i++) {
	    lines[i] = scanner.nextLine();
	}
	for (int j = 0; j <= 3; j++) {
	    System.out.println(lines[3-j]);
	}
    }
}
