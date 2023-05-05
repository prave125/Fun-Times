package com.ford.task;

import java.time.LocalDate;

public class BuySoupGetBreadDiscount extends Discount {

	public BuySoupGetBreadDiscount(LocalDate validFrom, LocalDate validTo) {
		super(validFrom, validTo);
	}

	public double calculateDiscount(Basket basket) {
		LocalDate currentDate = LocalDate.now();
		int soupCount = basket.getProductQuantity("soup");
		int breadCount = basket.getProductQuantity("bread");

		if (currentDate.isAfter(getValidFrom().minusDays(1)) && currentDate.isBefore(getValidTo().plusDays(1))
				&& soupCount >= 2 && breadCount >= 1) {
			double soupPrice = basket.getProductCost("soup");
			double breadPrice = basket.getProductCost("bread");
			double discountAmount = breadPrice / 2;
			return discountAmount;
		}

		return 0.0;
	}

	public boolean isApplicable(Basket basket) {
		int soupCount = basket.getProductQuantity("soup");
		int breadCount = basket.getProductQuantity("bread");
		return soupCount >= 2 && breadCount >= 1;
	}
}