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
		
	}

}
