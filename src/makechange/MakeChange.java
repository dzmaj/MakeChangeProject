package makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		// Variables
		Scanner sc = new Scanner(System.in);
		double price, payment, change;
		// Get user inputs
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
		}
		else if (change < 0) {
			// payment not enough
			System.out.println("Payment not enough");
		}
		else {
			// calculate change to give
			calcChange(change);
		}
		
		
		
		// End of program
		sc.close();
		
	}
	
	public static void calcChange(double changeAmount) {
		
		int twentyAmount = 0, tenAmount = 0, fiveAmount = 0, oneAmount = 0,
			quarterAmount = 0, dimeAmount = 0, nickelAmount = 0, pennyAmount = 0;
		
		
			if (changeAmount / 20 >= 1 ) {
				twentyAmount = (int)(changeAmount / 20);
				changeAmount %= 20;
				changeTwenty(twentyAmount);
			}
			if (changeAmount / 10 >= 1 ) {
				tenAmount = (int)(changeAmount / 10);
				changeAmount %= 10;
				changeTen(tenAmount);
			}
			if (changeAmount / 5 >= 1 ) {
				fiveAmount = (int)(changeAmount / 5);
				changeAmount %= 5;
				changeFive(fiveAmount);
			}
			if (changeAmount / 1 >= 1 ) {
				oneAmount = (int)(changeAmount / 1);
				changeAmount %= 1;
				changeOne(oneAmount);
			}
			
			// add a hundredth of a penny to correct for precision
			changeAmount += 0.0001;
			
			if (changeAmount / 0.25 >= 1 ) {
				quarterAmount = (int)(changeAmount / 0.25);
				changeAmount %= 0.25;
				changeQuarter(quarterAmount);
			}
			if (changeAmount / 0.10 >= 1 ) {
				dimeAmount = (int)(changeAmount / 0.10);
				changeAmount %= 0.10;
				changeDime(dimeAmount);
			}
			if (changeAmount / 0.05 >= 1 ) {
				nickelAmount = (int)(changeAmount / 0.05);
				changeAmount %= 0.05;
				changeNickel(nickelAmount);
			}
			if (changeAmount / 0.01 >= 1 ) {
				pennyAmount = (int)(changeAmount / 0.01);
				changeAmount %= 0.01;
				changePenny(pennyAmount);
			}
		
		
		
	}
	
	public static void changeTwenty(int quantity) {
		String changeString = " twenty dollar bill";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changeTen(int quantity) {
		String changeString = " ten dollar bill";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changeFive(int quantity) {
		String changeString = " five dollar bill";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changeOne(int quantity) {
		String changeString = " one dollar bill";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changeQuarter(int quantity) {
		String changeString = " quarter";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changeDime(int quantity) {
		String changeString = " dime";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changeNickel(int quantity) {
		String changeString = " nickel";
		if (quantity > 1) {
			changeString += "s";
		}
		System.out.println(quantity + changeString);
	}
	public static void changePenny(int quantity) {
		String changeString = " penny";
		if (quantity > 1) {
			changeString = " pennies";
		}
		System.out.println(quantity + changeString);
	}

}
