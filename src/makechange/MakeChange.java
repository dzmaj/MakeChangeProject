package makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		// Variables
		Scanner sc = new Scanner(System.in);
		double price, payment, change;

		printSeparator(2);
		System.out.println("---- Make Change ----");
		printSeparator(2);
		boolean keepGoing = true;
		while (keepGoing) {

			// Get user inputs
			printSeparator(1);
			System.out.print("Enter the price of the item(s): ");
			price = sc.nextDouble();
			System.out.print("Enter the payment amount: ");
			payment = sc.nextDouble();
			// check change amount
			change = payment - price;
			// Check change conditions
			if (change == 0) {
				// exact change
				System.out.println("Exact change");
			} else if (change < 0) {
				// payment not enough
				System.out.println("Payment not enough");
			} else {
				// calculate change to give
				if (change % 0.01 != 0) {
					change = (int) ((change + 0.0001) * 100) / 100.0;
				}
				System.out.println("Change: $" + change);
				calcAllChange(change);
			}
			// Ask if user wants another transaction
			printSeparator(1);
			System.out.println("Do you wish to enter another transaction? (y/n): ");
			keepGoing = yesNoToBool(sc.next());
		}
		// End of program
		System.out.println("Exiting");
		sc.close();
	}

	public static void calcAllChange(double changeAmount) {
		changeAmount = calcAndPrintChange(changeAmount, 100.0, "hundred dollar bill");
		changeAmount = calcAndPrintChange(changeAmount, 50.0, "fifty dollar bill");
		changeAmount = calcAndPrintChange(changeAmount, 20.0, "twenty dollar bill");
		changeAmount = calcAndPrintChange(changeAmount, 10.0, "ten dollar bill");
		changeAmount = calcAndPrintChange(changeAmount, 5.0, "five dollar bill");
		changeAmount = calcAndPrintChange(changeAmount, 1.0, "one dollar bill");
		// add a hundredth of a penny to correct for precision errors
		changeAmount += 0.0001;
		changeAmount = calcAndPrintChange(changeAmount, 0.25, "quarter");
		changeAmount = calcAndPrintChange(changeAmount, 0.10, "dime");
		changeAmount = calcAndPrintChange(changeAmount, 0.05, "nickel");
		changeAmount = calcAndPrintChange(changeAmount, 0.01, "penny", "pennies");
	}

	// default adds 's' to end
	public static double calcAndPrintChange(double changeAmount, double value, String name) {
		int amount = 0;
		if (changeAmount / value >= 1) {
			amount = (int) (changeAmount / value);
			changeAmount %= value;
		} else {
			return changeAmount;
		}
		if (amount > 1) {
			name += "s";
		}
		System.out.println(amount + " " + name);
		return changeAmount;
	}

	// optional plural string for pennies
	public static double calcAndPrintChange(double changeAmount, double value, String name, String plural) {
		int amount = 0;
		if (changeAmount / value >= 1) {
			amount = (int) (changeAmount / value);
			changeAmount %= value;
		} else {
			return changeAmount;
		}
		if (amount > 1) {
			name = plural;
		}
		System.out.println(amount + " " + name);
		return changeAmount;
	}

	public static boolean yesNoToBool(String input) {
		switch (input) {
		case "y":
		case "yes":
		case "Y":
		case "Yes":
		case "YES":
			return true;
		case "n":
		case "no":
		case "N":
		case "No":
		case "NO":
			return false;
		default:
			System.err.println("Invalid Response");
			return false;
		}
	}

	public static void printSeparator(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("---------------------");
		}
	}

}
