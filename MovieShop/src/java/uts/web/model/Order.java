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
    private String orderID;
    private String movieID;
    private String status;
    private String date;
    private String price;
    private String total;
    private String userID;
    
    
    public Order(String orderID, String userID, String movieID, String status, String date, String price, String total){
        this.orderID = orderID;
        this.userID = userID;
        this.movieID = movieID;
        this.status = status;
        this.date = date;
        this.price = price;
        this.total = total;
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
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String price){
        this.price = price;
    }
    
    public String getUserID() {
        return userID;
    }
    
    public String getOrderID(){
        return orderID;
    }
    
    public String getMovieID(){
        return movieID;
    }
    
    public String getTotal(){
        return total;
    }
    
    public void setTotal(String total){
        this.total = total;
    }
    
   
}

