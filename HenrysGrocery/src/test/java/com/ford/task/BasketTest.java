package com.ford.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class BasketTest{
	@Test
	public void testBuySoupGetBreadDiscount() {
		Basket basket = new Basket();
		Product soup = new Product("soup", "tin", 0.65);
		Product bread = new Product("bread", "loaf", 0.80);
		basket.addItem(soup, 2);
		basket.addItem(bread, 1);

		LocalDate validFrom = LocalDate.now().minusDays(1);
		LocalDate validTo = LocalDate.now().plusDays(7);

		Discount discount = new BuySoupGetBreadDiscount(validFrom, validTo);
		double discountAmount = discount.calculateDiscount(basket);

		assertEquals(0.40, discountAmount, 0.001);
	}


}
