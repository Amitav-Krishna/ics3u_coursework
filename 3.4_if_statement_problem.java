import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		life_stages();
	}

	// Input: name, age, and whether they are a student
	// Process: If they are between 5 and 12 inclusive and a student, they are a student.  If they are between 13 and 19 inclusive and a student they are a teenager.  If they are between 20 and 30 inclusive and not a student they are a young adult.  Otherwise, they are in a different stage of life
	// Output: their name and stage of life
	//
	// DEFINE name AS user_input
	// DEFINE age AS user_input
	// DEFINE is_student AS user_input
	//
	// IF is_student == true AND age >= 5 AND age <= 12
	//     DISPLAY "${{name}} is a child."
	// ELSE IF is_student == true AND age >= 13 AND age <= 19
	//     DISPLAY "${{name}} is a teenager."
	// ELSE IF is_student == false AND age >= 20 AND age <= 30
	//     DISPLAY "${{name}} is a young adult."
	// ELSE
	//     DISPLAY "${{name}} is in a different stage of life"
	public static void life_stages() {
		Scanner scanner = new Scanner(System.in); // Defines a scanner named scanner
		// Blank line for readability
		System.out.println("Please enter your age."); // Outputs "Please enter your age."
		int age = Integer.parseInt(scanner.nextLine());  // Sets age to scanner.nextLine()
		System.out.println("Please enter your name."); // Outputs "Please enter your name."
		String name = scanner.nextLine();  // Sets name to scanner.nextLine()
		// Blank line for readability
		System.out.println("Please enter if you are a student (yes or no)."); // Outputs "Please enter if you are a student (yes or no)."
		String is_student_string = scanner.nextLine();  // Sets is_student_string to scanner.nextLine()
		boolean is_student = false; // Sets is_student to false
		if (is_student_string.equals("yes")) { // Checks if is_student_string.equals("yes")
			is_student = true; // Sets is_student to true
		} // Ends if statement
		// Blank line for readability
		if (is_student == true && age >= 5 && age <= 12) { // Checks if is_student == true and age >= 5 and age <= 12
			System.out.format("%s is a child%n", name); // Outputs "%s is a child" where %s is equal to name
		} else if (is_student == true && age >= 13 && age <= 19) {// Checks if is_student == true and age >= 13 and age <= 19
			System.out.format("%s is a teenager%n", name);// Outputs "%s is a teenager" where %s is equal to name
		} else if (is_student == false && age >= 20 && age <= 30) { // Checks if is_student == true and age >= 20 and age <= 30
			System.out.format("%s is a young adult%n", name);// Outputs "%s is a young adult" where %s is equal to name
		} else {
			System.out.format("%s is in a different stage of life%n", name); // Outputs "%s is in a different stage of life" where %s is equal to name
		} // Ends if else chain
		scanner.close();
	} // Ends method
}
