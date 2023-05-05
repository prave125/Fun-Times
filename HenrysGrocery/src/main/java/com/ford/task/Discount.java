package com.ford.task;

import java.time.LocalDate;

public abstract class Discount {
    private LocalDate validFrom;
    private LocalDate validTo;

    public Discount(LocalDate validFrom, LocalDate validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public abstract double calculateDiscount(Basket basket);

}