public class Main {
    public static void main(String[] args) {
	String[] arguments = {};
	areaOfCircle(arguments);
	cubeRoot(arguments);
	multiplicationTable(arguments);
	average(arguments);
    }
    // Input: Nothing
    // Processing: calculate area of circle
    // Output: area
    // SET x to CALCULATE 5.6 * 5.6
    // SET y to CALCULATE pi * x
    // PRINT y
    // END
    public static void areaOfCircle(String[] args) {
	double x = 5.6 * 5.6;
	double y = 3 * x;
	System.out.println("The area of a circle with radius 5.6 is " + y);
    }
    // Input: Nothing
    // Processing: Iteratively get closer and closer to the cube root of 1000 over 1000 steps
    // Output: the cube root of 1000
    // SET cubeRoot to 0
    // FOR i FROM 1 TO 999
    // SET cubeVolume to CALCULATE cubeRoot * cubeRoot * cubeRoot
    // SET delta to 1000 - cubeVolume
    // SET cubeRoot to cubeRoot + (delta/100) / i
    // ENDFOR
    // PRINT cubeRoot
    // END

    public static void cubeRoot(String[] args) {
	double cubeRoot = 0;
	double cubeVolume;
	double delta;
	
	for (int i = 1; i < 1000; i++) {
	    cubeVolume = cubeRoot * cubeRoot * cubeRoot;
	    delta = 1000 - cubeVolume;
	    
	    cubeRoot = cubeRoot + ((delta/100) / i);
	}
	System.out.println("The side length of a cube with volume 1000 is " + cubeRoot);
    }
	
    // Input: Nothing
    // Processing: Looping through each pair of numbers and displaying their product
    // Output: A multiplication table
    // FOR i FROM 1 TO 12
    // FOR j FROM i TO 12
    // PRINT i, j, CALCULATE i * j
    // ENDFOR
    // ENDFOR
    // END

    public static void multiplicationTable(String[] args) {
	for (int i = 1; i <= 12; i++) {
	    for (int j = i; j <= 12; j++) {
		int x = i * j;
		System.out.println(i + " * " + j + " = " + x);
	    }
	}
    }

    // Input: Nothing
    // Processing: Take the sum of the numbers and divide it by 3
    // Output: The average
    // SET sum TO 0
    // SET numbers TO {56.9, 89.7, 90.2}
    // FOR i FROM 0 TO 2
    // SET sum TO CALCULATE sum + numbers[i]
    // SET average TO CALCULATE sum / 3
    // DISPLAY average

    public static void average(String[] args) {
	double sum = 0;
	double[] numbers = {56.9, 89.7, 90.2};
	for (int i = 0; i < 3; i++) {
	    sum = sum + numbers[i];
	}
	double average = sum / 3;
	System.out.println("The average is " + average);
    }
    
    
}
