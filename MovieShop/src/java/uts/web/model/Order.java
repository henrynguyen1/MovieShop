/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;

import java.io.Serializable;
/**
 *
 * @author yantoyanto
 */
public class Order implements Serializable {
    private int orderID;
  //  private int userID;
    private int movieID; //Movie movie;
    private String trackingNo;
    private String status;
    private String date;
    private double price;
    private int userID;
    
    
    public Order(){
    
    }
    
    public Order(int userID, int movieID, String trackingNo, String status, String date, double price){
        this.userID = userID;
        this.movieID = movieID;
        this.trackingNo = trackingNo;
        this.status = status;
        this.date = date;
        this.price = price;
    }  
    
    public String getTrackingNo(){
        return trackingNo;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
}
