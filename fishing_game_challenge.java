import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class Main {
	public static final String[] fish = {"Tuna", "Tadpole", "Whale"};
	public static final int[] points = {2, 1, 1234812034};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		long startTime;
		boolean shouldContinue = true;
		double elapsedTime;
		int total_score = 0;
		char x;
		double input_score;
		String input;
		while (shouldContinue) {
			System.out.print("Type as fast as you can.\n");   
			startTime = System.currentTimeMillis();
			input = scanner.nextLine();
			elapsedTime = ((System.currentTimeMillis() - startTime) +0.1)/1000;
			System.out.format("You typed %d characters in %f seconds%n", input.length(), elapsedTime);
			input_score = input.length() / elapsedTime;

			try {
				if (input_score > 30) {
					total_score = total_score + points[2];
					System.out.format("You caught a %s for %d points%n", fish[2], points[2]);
					if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
						Desktop.getDesktop().browse(new URI("https://claude.ai/new?q=Generate+me+an+SVG+image+of+a Whale.+Be+artistic."));
					}

				} else if (input_score > 20) {
					total_score = total_score + points[0];
					System.out.format("You caught a %s for %d points%n", fish[0], points[0]);
					if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
						Desktop.getDesktop().browse(new URI("https://claude.ai/new?q=Generate+me+an+SVG+image+of+a+tuna.+Be+artistic."));
					}

				} else {
					total_score = total_score + points[1];
					System.out.format("You caught a %s for %d points%n", fish[1], points[1]);
					if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
						Desktop.getDesktop().browse(new URI("https://claude.ai/new?q=Generate+me+an+SVG+image+of+a+tadpole.+Be+artistic."));
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.format("You have %d points in total%n", total_score);
			System.out.print("Continue? [y/n]\n");
			x = (scanner.nextLine()).trim().charAt(0);
			if (x == 'y') {
				shouldContinue = true;
			} else {

				shouldContinue = false;
			}
		}
	}
}


