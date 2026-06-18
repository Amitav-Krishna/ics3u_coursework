public class Main {
    public static void main (String[] args) {
	String[] arguments = {};
	meal(arguments);
    }

    // Input: Nothing
    // Processing: Calculate the stuff
    // Output: The stuff
    // SET totalCost TO 0
    // SET subtotal TO 31599
    // SET taxRate TO 0.13
    // SET tipRate TO 0.20
    // SET splitAmong TO 5
    // SET satisfaction TO "G"
    // SET billSplit TO true
    // SET totalCost TO subtotal
    // SET taxAmount TO CALCULATE subtotal * taxRate
    // SET totalCost TO CALCULATE totalCost + taxAmount
    // SET tipAmount TO CALCULATE totalCost * tipRate
    // SET totalCost TO CALCULATE totalCost + tipAmount
    // IF billSplit IS true
    // SET totalCost TO CALCULATE totalCost / splitAmong
    // ENDIF
    // DISPLAY subtotal, taxAmount, tipAmount, totalCost, satisfaction, billSplit
    public static void meal(String[] args) {
	double totalCost = 0;
	double subtotal = 31599;
	double taxRate = 0.13;
	double tipRate = 0.20;
	int splitAmong = 5;
	String satisfaction = "G";
	boolean billSplit = true;
	double taxAmount = subtotal * taxRate;
	totalCost = totalCost + taxAmount;
	double tipAmount = totalCost * tipRate;
	totalCost = totalCost + tipAmount;
	System.out.print("Subtotal: " + subtotal + "\n");
	System.out.print("Tax amount: " + taxAmount + "\n");
	System.out.print("Tip amount: " + tipAmount + "\n");	
	System.out.print("Satisfaction rating: " + satisfaction + "\n");	
	if (billSplit = true) {
	    totalCost = totalCost / splitAmong;
	    System.out.print("The bill was split!\n");
	}

	System.out.print("Total cost per person: " + totalCost + "\n");
    }


}
