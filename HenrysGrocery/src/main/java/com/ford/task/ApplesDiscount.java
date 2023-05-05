package com.ford.task;

import java.time.LocalDate;

public class ApplesDiscount extends Discount {

	public ApplesDiscount(LocalDate validFrom, LocalDate validTo) {
		super(validFrom, validTo);
	}

	public double calculateDiscount(Basket basket) {
		LocalDate basketDate = basket.getDate();

		if (basketDate.isAfter(getValidFrom()) && basketDate.isBefore(getValidTo().plusDays(3))) {
			// Calculate the total cost of all apples in the basket
			double totalApplesCost = 0;
			for (BasketItem item : basket.getItems()) {
				if (item.getProduct().getName().equals("apples")) {
					totalApplesCost += item.getTotalCost();
				}
			}
			double discountAmount = totalApplesCost * 0.1;
			return discountAmount;
		}

		return 0.0;
	}
	public boolean isApplicable(Basket basket) {
		for (BasketItem item : basket.getItems()) {
			if (item.getProduct().getName().equals("apples")) {
				return true;
			}
		}
		return false;
	}
}