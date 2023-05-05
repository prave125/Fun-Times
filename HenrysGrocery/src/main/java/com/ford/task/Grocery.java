package com.ford.task;

import java.time.LocalDate;
import java.util.Scanner;

public class Grocery {

	public static void main(String[] args) {
		Basket basket = new Basket();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Enter product name or 'done' to exit: ");
			String productName = scanner.nextLine();

			if (productName.equalsIgnoreCase("done")) {
				break;
			}

			System.out.print("Enter unit: ");
			String unit = scanner.nextLine();

			System.out.print("Enter cost: ");
			double cost = scanner.nextDouble();
			scanner.nextLine(); // consume new line character

			Product product = new Product(productName, unit, cost);

			System.out.print("Enter quantity: ");
			int quantity = scanner.nextInt();
			scanner.nextLine(); // consume new line character

			basket.addItem(product, quantity);
		}

		System.out.println("Items in basket:");
		for (BasketItem item : basket.getItems()) {
			System.out.println(item.getQuantity() + " " + item.getProduct().getUnit() + " of "
					+ item.getProduct().getName() + " at " + item.getProduct().getCost());
		}

		System.out.println("Total cost: " + basket.getTotalCost(LocalDate.now()));

		LocalDate yesterday = LocalDate.now().minusDays(1);
		LocalDate nextWeek = yesterday.plusDays(7);
		BuySoupGetBreadDiscount soupDiscount = new BuySoupGetBreadDiscount(yesterday, nextWeek);
		if (soupDiscount.isApplicable(basket)) {
			System.out.println("Congratulations! You are eligible for a half price loaf of bread.");
		}

		LocalDate validFrom = LocalDate.now().minusDays(1);
		LocalDate validTo = LocalDate.now().plusDays(7);
		Discount applesDiscount = new ApplesDiscount(validFrom, validTo);

		double totalCostBeforeDiscount = basket.getTotalCost(LocalDate.now());
		double totalCostAfterDiscount = applesDiscount.calculateTotalCostAfterDiscount(basket, LocalDate.now());

		if (totalCostBeforeDiscount > totalCostAfterDiscount) {
			double discountAmount = totalCostBeforeDiscount - totalCostAfterDiscount;
			System.out.println("Congratulations! You are eligible for a discount of " + discountAmount + " on apples.");
			System.out.println("Updated total cost: " + totalCostAfterDiscount);
		} else {
			System.out.println("Sorry, you are not eligible for any discount on apples.");
			System.out.println("Total cost: " + totalCostBeforeDiscount);
		}

	}
}
