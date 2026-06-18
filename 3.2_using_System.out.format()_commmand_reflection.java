public class Main	// name of class
{ // start of class
  public static void main (String[]args)	//magic line
  {	// start of main method
	final double PI = 3.141593; // constant variable for Pi
	int Age = 8;  // age is set to 8 years old
	String Name = "Johnny";  // String object set to Johnny 
        
	System.out.format ("%s is %d years old.%n", Name, Age);  // It fills in %s and %d with Johnny and 8, because those are the values of the provided variables
	System.out.format ("The value of PI is %.3f%n", PI);  // It outputs to 3 decimal points, because we say .3f
        System.out.format ("PI = %012f%n", PI);  // Prints the full number, with 4 leading zeros to achieve the specified width of 12 
        System.out.format ("%-10.3f%n", PI); // Prints Pi to 3 digits, left justified 

  }	// end of main method
}// end of class
