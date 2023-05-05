package com.ford.task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<BasketItem> items;
	private LocalDate date;

	public Basket() {
		items = new ArrayList<>();
		date = LocalDate.now();
	}

	public LocalDate getDate() {
		return date;
	}

	public List<BasketItem> getItems() {
		return items;
	}

	public void addItem(Product product, int quantity) {
		BasketItem item = new BasketItem(product, quantity);
		items.add(item);
	}

	public int getProductQuantity(String productName) {
		int quantity = 0;
		for (BasketItem item : items) {
			if (item.getProduct().getName().equals(productName)) {
				quantity += item.getQuantity();
			}
		}
		return quantity;
	}

	public double getProductCost(String productName) {
		double cost = 0;
		for (BasketItem item : items) {
			if (item.getProduct().getName().equals(productName)) {
				cost += item.getProduct().getCost() * item.getQuantity();
			}
		}
		return cost;
	}

	public double getDiscount() {
		double discount = 0;
		for (Discount d : getDiscounts()) {
			discount += d.calculateDiscount(this);
		}
		return discount;
	}

	private List<Discount> getDiscounts() {
		List<Discount> discounts = new ArrayList();
		//discounts.add(new BuySoupGetBreadDiscount(LocalDate.of(2023, 5, 2), LocalDate.of(2023, 5, 9)));
		//discounts.add(new ApplesDiscount(LocalDate.of(2023, 5, 6), LocalDate.of(2023, 6, 30)));
		return discounts;
	}

	public double getTotalCost(LocalDate today) {
		double totalCost = 0;
		for (BasketItem item : items) {
			totalCost += item.getProduct().getCost() * item.getQuantity();
		}
		totalCost -= getDiscount();
		return totalCost;
	}
}
