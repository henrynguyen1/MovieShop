/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;

import java.io.Serializable;
import java.time.LocalDate;

/*
 * Enum constants representing the payment method to pay for an order.
 */
enum PaymentType {
    WALLET,
    CREDIT_CARD,
    BANK_TRANSFER,
    PAYPAL;    
}

/*
 * Enum constants representing the status of the payment.
 */
enum PaymentStatus {
    STARTED,
    SAVED,
    PROCESSING,
    ACCEPTED,
    DECLINED;
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
    private PaymentStatus status;

    public Payment() {
        paymentID = 0;
        orderID = 0;
        userID = 0;
        amount = 0.0;
        type = PaymentType.WALLET;
        date = LocalDate.now();
        status = PaymentStatus.STARTED;
    }

    public Payment(int paymentID, int orderID, int userID, double amount,
            String type, LocalDate date, String status) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.userID = userID;
        this.amount = amount;
        this.type = PaymentType.valueOf(type);
        this.date = date;
        this.status = PaymentStatus.valueOf(status);
    }

    public Payment(int orderID, int userID, double amount, String type, LocalDate date, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMethod() {
        return type.toString();
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
    
    public String getStatus() {
        return status.toString();
    }

    public void setAmount(double amount) {
        if (amount > 0.0) {
            this.amount = amount;
        }
        // TODO: else throw exception
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMethod(String type) {
        this.type = PaymentType.valueOf(type);
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
    
    public void setStatus(String status) {
        this.status = PaymentStatus.valueOf(status);
    }
}
