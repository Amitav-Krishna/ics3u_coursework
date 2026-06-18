public class Main  // name of class
{ // start of class
  public static void main(String[] args)  // magic line
  { // start of main method
   int number = 25; // Change this variable and re-run the program to explore

      System.out.println("Example using nested if statements\n");
      // Using nested if statements
        if (number < 50) 
          System.out.println("Number is less than 50");
        else // number has to be larger than 51 to get here
        {// start of else
          // number has to be over 50 and less than 100
          if (number < 100) 
            System.out.println("Number is between 50 and 100");
          else // number is over 100
            System.out.println("Number is greater than or equal to 100");
        } // end of else
      System.out.println("\nSame example using if, else if, else\n");
    // Using if, else if, and else statements
        if (number < 50) 
          System.out.println("Number is less than 50");
        else if (number < 100) 
          System.out.println("Number is between 50 and 100");
        else 
          System.out.println("Number is greater than or equal to 100");
  } // end of main method
} // end of class
//
// Trace tables
// number, x > 50, x < 100
// 75, true, true
// 25, false, true
// 25 returns less than 50 because it is less than 50
