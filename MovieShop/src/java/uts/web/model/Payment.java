/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Enum constants representing the payment types to restrict the input.
 */
enum PaymentType {
    WALLET,
    CREDIT_CARD,
    BANK_TRANSFER,
    PAYPAL;    
}

/**
 * Payment class that represents a single payment record in the database.
 * @author Ben Stevens (02078018)
 */
public class Payment implements Serializable {
    
    private int paymentID;
    private int orderID;
    private int userID;
    private double amount;
    private PaymentType type;
    private LocalDate date;

    public Payment() {
        paymentID = 0;
        orderID = 0;
        userID = 0;
        amount = 0.0;
        type = PaymentType.WALLET;
        date = LocalDate.now();
    }

    public Payment(int paymentID, int orderID, int userID, double amount,
            PaymentType type, LocalDate date) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.userID = userID;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public PaymentType getMethod() {
        return type;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setAmount(double amount) {
        if (amount > 0.0) {
            this.amount = amount;
        }
        // TODO: else throw exception
    }

    public void setDate(LocalDate date) {
        // The transaction date cannot be set in the past.
        if (!(date.isBefore(LocalDate.now()))) {
            this.date = date;
        }
        // TODO: else throw exception
    }

    public void setMethod(PaymentType type) {
        this.type = type;
    }

    public void setOrderID(int orderID) {
        if (orderID > 0) {
            this.orderID = orderID;
        }
        // TODO: else throw exception
    }

    public void setPaymentID(int paymentID) {
        if (paymentID > 0) {
            this.paymentID = paymentID;
        }
        // TODO: else throw exception
    }

    public void setUserID(int userID) {
        if (userID > 0) {
            this.userID = userID;
        }
        // TODO: else throw exception
    }
    
}
