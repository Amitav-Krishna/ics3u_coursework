import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		encryption();
	}

	public static void encryption() {
		Scanner scanner = new Scanner(System.in); // Initializes scanner

		String inputString = scanner.nextLine(); // Reads input string
		char[] inputCharacters = inputString.toCharArray(); // Casts string to character array
		int offset = (Integer.parseInt(scanner.nextLine())) % 26; // Reads the specified offset

		char[] outputCharacters = new char[inputCharacters.length]; // Creates a new array 
		for (int i = 0; i < outputCharacters.length; i++) {
			if ((int) inputCharacters[i] > 96) {  // checks for lowercase letters
				outputCharacters[i] = (char) ((((((int) inputCharacters[i]) - 96) + offset) % 26)+ 96);  // Shifts the characters 
					 
			}
			else { // All other characters
				outputCharacters[i] = (char) ((((((int) inputCharacters[i])-64) + offset) % 26) + 64); // shifts the characters
			}
		}

		String outputString = new String(outputCharacters); // Casts character array to string
		System.out.println(outputString); // Outputs

	}

}
