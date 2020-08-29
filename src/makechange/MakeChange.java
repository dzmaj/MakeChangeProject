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
			System.out.print("Enter the price of the item: ");
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
				calcChange(change);
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

	public static void calcChange(double changeAmount) {

		int hundredAmount = 0, fiftyAmount = 0, twentyAmount = 0, tenAmount = 0, fiveAmount = 0, oneAmount = 0,
				quarterAmount = 0, dimeAmount = 0, nickelAmount = 0, pennyAmount = 0;

		if (changeAmount / 100 >= 1) {
			hundredAmount = (int) (changeAmount / 100);
			changeAmount %= 100;
			printChange(hundredAmount, "hundred dollar bill");
		}
		if (changeAmount / 50 >= 1) {
			fiftyAmount = (int) (changeAmount / 50);
			changeAmount %= 50;
			printChange(fiftyAmount, "fifty dollar bill");
		}
		if (changeAmount / 20 >= 1) {
			twentyAmount = (int) (changeAmount / 20);
			changeAmount %= 20;
			printChange(twentyAmount, "twenty dollar bill");
		}
		if (changeAmount / 10 >= 1) {
			tenAmount = (int) (changeAmount / 10);
			changeAmount %= 10;
			printChange(tenAmount, "ten dollar bill");
		}
		if (changeAmount / 5 >= 1) {
			fiveAmount = (int) (changeAmount / 5);
			changeAmount %= 5;
			printChange(fiveAmount, "five dollar bill");
		}
		if (changeAmount >= 1) {
			oneAmount = (int) (changeAmount / 1);
			changeAmount %= 1;
			printChange(oneAmount, "one dollar bill");
		}

		// add a hundredth of a penny to correct for precision errors
		changeAmount += 0.0001;

		if (changeAmount / 0.25 >= 1) {
			quarterAmount = (int) (changeAmount / 0.25);
			changeAmount %= 0.25;
			printChange(quarterAmount, "quarter");
		}
		if (changeAmount / 0.10 >= 1) {
			dimeAmount = (int) (changeAmount / 0.10);
			changeAmount %= 0.10;
			printChange(dimeAmount, "dime");
		}
		if (changeAmount / 0.05 >= 1) {
			nickelAmount = (int) (changeAmount / 0.05);
			changeAmount %= 0.05;
			printChange(nickelAmount, "nickel");
		}
		if (changeAmount / 0.01 >= 1) {
			pennyAmount = (int) (changeAmount / 0.01);
			changeAmount %= 0.01;
			printChange(pennyAmount, "penny", "pennies");
		}

	}
	
	
	// in progress
	public static double calcDenominationChange(double changeAmount, double value, String name, String plural) {
		
		if (changeAmount / value >= 1) {
			int amount = (int)(changeAmount / value);
			changeAmount %= value;
			printChange(amount, name, plural);
		}
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

	public static void printChange(int quantity, String changeString) {
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + " " + changeString);
	}
	public static void printChange(int quantity, String changeString, String changeStringMultiple) {
		if (quantity > 1) {
			changeString = changeStringMultiple;
		}
		System.out.println(quantity + " " + changeString);
	}

	public static void printSeparator(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("---------------------");
		}
	}

}
