/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Ben Stevens (02078018)
 */
public class Payment implements Serializable {
    
    private int paymentID;
    private int orderID;
    private int userID;
    private double amount;
    private String method;
    private LocalDate date;

    public Payment() {
        paymentID = 0;
        orderID = 0;
        userID = 0;
        amount = 0.0;
        method = "none";
        date = LocalDate.now();
    }

    public Payment(int paymentID, int orderID, int userID, double amount, String method, LocalDate date) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.userID = userID;
        this.amount = amount;
        this.method = method;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMethod() {
        return method;
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
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setOrderID(int orderID) {
        if (orderID > 0) {
            this.orderID = orderID;
        }
    }

    public void setPaymentID(int paymentID) {
        if (paymentID > 0) {
            this.paymentID = paymentID;
        }
    }

    public void setUserID(int userID) {
        if (userID > 0) {
            this.userID = userID;
        }
    }
    
}
