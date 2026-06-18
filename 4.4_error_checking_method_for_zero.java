import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		double dividend = 3;
		double divisor = 0;
		System.out.format("%b\n", divideByZero(dividend, divisor)); // Should print 'false'
		divisor = 23414;
		System.out.format("%b\n", divideByZero(dividend, divisor)); // Should print 'true'
	}
	
	public static boolean divideByZero(double dividend, double divisor) {
		if (Math.abs(0 - divisor) < 1e-9) { // 1e-9 is the epsilon since comparisons between floating point numbers are inherently imprecise. See https://stackoverflow.com/questions/4915462/how-should-i-do-floating-point-comparison for more information
			return false;
		}
		return true;
	}
}
