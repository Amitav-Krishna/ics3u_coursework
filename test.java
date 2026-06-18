import java.util.Scanner; // import the scanner toolbox
public class Main  // main class
{ // start of class
  public static void main(String[] args) // magic line
  { // start of main method
	//declare and assign my variables and objects
	Scanner scanner = new Scanner(System.in); //scanner object
	String name = null; // will hold user's name
	String subject = null; // will hold user's subject
	double mark_1 = 0.0; // will hold the user's first mark
	double mark_2 = 0.0; // will hold the user's second mark
	double mark_3 = 0.0; // will hold the user's third  mark
	double average = 0.0; // will hold the user's average
	    
	// ask the user their name
	  System.out.println("What is your name?");
    // grab the user's name from the keyboard using nextLine() method
      name = scanner.nextLine();
   // ask the user their subject
	  System.out.println("What is the name of a course you are taking?");
   // grab the user's subject from the keyboard using nextLine() method
      subject = scanner.nextLine();
  // ask the user for first mark
	  System.out.println("What is your first test mark in "+subject+"?");
  // grab the user's first mark from the keyboard using nextDouble() 
      mark_1 = scanner.nextDouble();
  // ask the user for second mark
      System.out.println("What is your second test mark in "+subject+"?");
 // grab the user's second mark from the keyboard using nextDouble() 
      mark_2 = scanner.nextDouble();
 // ask the user for third mark
      System.out.println("What is your third test mark in "+subject+"?");
// grab the user's third mark from the keyboard using nextDouble() 
      mark_3 = scanner.nextDouble();
       
  // calcuate the average of your 3 marks
      average = (mark_1+mark_2+mark_3)/3;
 // now display the results to the screen
      System.out.println("Your name is "+name);
      System.out.println("The course you are taking at school is "+subject);
      System.out.println("Your first test mark in "+subject+" is " + mark_1);
      System.out.println("Your second test mark in "+subject+" is " + mark_2);
      System.out.println("Your third test mark in "+subject+" is " + mark_3);
      System.out.println("Your average in "+subject+" is " + average);
      scanner.close();// closes the Scanner object	        
	} // end of main method
} // end of class
