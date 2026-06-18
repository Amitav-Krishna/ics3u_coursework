import java.util.Scanner;
public class Main {
	public static void main (String[] args) {
		average();
		triangle();
	}

	// Input: a number N, and N marks
	// Processing: Calculate the average of the N marks
	// Output: The average and feedback on the grade
	// SET num_marks TO user_input
	// SET marks TO {num_marks}
	// SET x TO 0
	// WHILE i < num_marks
	//     SET marks[i] TO user_input
	//     SET x TO x + 1
	// ENDWHILE
	// SET sum TO 0
	// FOR i FROM 0 TO num_marks
	//     SET sum TO sum + marks[i]
	// ENDFOR
	// SET average TO sum / num_marks
	// if average > 80
	//     DISPLAY "Student is on honour roll"
	// ENDIF
	// ELSE IF (average >=70 AND average < 80)
	//     DISPLAY "Student is average"
	// ENDELSEIF
	// ELSE IF (average >= 50 AND average < 70)
	//     DISPLAY "Student is just under average"
	// ENDELSEIF
	// ELSE
	//     DISPLAY "Student is failng"
	// ENDELSE
	// DISPLAY average
	// DISPLAY num_marks
	// END
	public static void average () {
		Scanner scanner = new Scanner(System.in); // Creates a scanner to read input
                // Blank line for readability
		System.out.println("How many classes does the student have?"); // Asks the student for num_marks
		int num_marks = Integer.parseInt(scanner.nextLine()); // Read the next line of input and cast it to an integer
                // Blank line for readability
		float[] marks = new float[num_marks]; // Creates an array for marks
		for (int i = 0; i < num_marks; i++) { // Begins a for loop 
			System.out.format("Please give me the %dth mark.%n", i); // Requests the user for a mark
			marks[i] = Float.parseFloat(scanner.nextLine()); // Read the next line of input and cast it to an integer
		} // Ends a for loop
                // Blank line for readability
		float sum = 0; // Initializes sum to 0
                // Blank line for readability
		for (int i = 0; i < num_marks; i++) { // Begins a for loop
			sum += marks[i]; // Adds the ith mark to the sum
		} // Ends a for loop
                // Blank line for readability
		float average = sum / num_marks; // Computes thr average
                // Blank line for readability
		System.out.format("You have entered %d marks.  The student's average is %.2f%n", num_marks, average); // Outputs the average
                // Blank line for readability
		if (average > 80) { // Checks if the user's average is greater than 80
			System.out.println("The student is on the honour roll"); // Outputs the appropriate response
		} else if (average >= 70) { // Checks if the user's average is greater than or equal  to 70
			System.out.println("The student is average"); // Outputs the appropriate response
		} else if (average >= 50) { // Checks if the user's average is greater than or equal to 50
			System.out.println("The student is just under average"); // Outputs the appropriate response
		} else { // If all else fails
			System.out.println("The student is failing"); // Outputs the appropriate reponse
		}
	} // Ends the method

	// Input: Nothing
	// Processing: Create triangle
	// Output: Print triangle
	// FOR i FROM 1 TO 1000 
	//     FOR j FROM 1 TO i
	//         DISPLAY "j "
	//     ENDFOR
	//     DISPLAY '\n'
	// ENDFOR
	// END
	public static void triangle() {
		for (int i = 1; i <= 1000; i++) { // Begin outer for loop
			for (int j = 1; j <= i; j++) { // Begin inner for loop
				System.out.format("%d ", j); // Output the jth element of the ith line of the triangle
			} // End inner for loop
			System.out.print('\n'); // Ends the ith line of the triangle
		} // End outer for loop
	} // End method

}
