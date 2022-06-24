package com.exams.createexams.utils.enums;

public enum PaymentType {
    HOURLY("Hourly payment"),
    PER_CLASS("Per class payment"),
    MONTHLY("Monthly payment"),
    YEARLY("Yearly subscription"),
    ONE_TIME("One time payment");

    private String payment;

    private PaymentType(String payment) {
        this.payment = payment;
    }

    public String getPaymentType() {
        return this.payment;
    }
}
