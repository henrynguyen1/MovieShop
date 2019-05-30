/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author yantoyanto
 */
public class Order implements Serializable {
    private int orderID;
    private String status;
    private Date date = new Date();
    private double total;
    private String userID;
    
    
    public Order(int orderID, String userID, String status, Date date, double total){
        this.orderID = orderID;
        this.userID = userID;
        this.status = status;
        LocalDateTime now = LocalDateTime.now();
        this.date = date;
        this.total = total;
    }  
     
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public int getOrderID(){
        return orderID;
    }
    
   
}
