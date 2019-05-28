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
public class OrderLine implements Serializable {
    private int orderID;
    private int movieID;
    private double price;
    
    public OrderLine(int orderID, int movieID, double price){
        this.orderID = orderID;
        this.movieID = movieID;
        this.price = price;     
    }

    public OrderLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getOrderID(){
        return orderID;
    }
    
    public void setOrderID(int orderID){
        this.orderID = orderID;
    }
    
    public int getMovieID(){
        return movieID;
    }
    
    public void setMovieID(int movieID){
        this.movieID = movieID;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    
}
