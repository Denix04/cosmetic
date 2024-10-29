package com.delhi.entity.enums;

public enum PaymentMethod {
    TRANSFER,
    CASH,
    DEBIT,
    CREDIT;

    public String toString() {
        return name().toUpperCase();
    }
}

