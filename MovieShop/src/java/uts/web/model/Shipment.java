package uts.web.model;
import java.io.Serializable;




/**
 *
 * @author henry117
 */

public class Shipment implements Serializable{
    private String shipID; 
    private String email;   
    private String name;
    private int orderID;
    private int movieID; 
    private String trackingNo;
    private String status;
    private String date;
    private double price;
    private int userID;

    public Shipment() {}
    
    public Shipment(String shipID, String email, String name){
    this.email = email;
    this.name = name;
    this.shipID = shipID;
            
    }

    public String getShipID() {
        return shipID;
    }

    public void setShipID(String shipID) {
        this.shipID = shipID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getOrderID() {
        return orderID;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getUserID() {
        return userID;
    }
      
}
