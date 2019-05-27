package uts.web.model;
import java.io.Serializable;
import java.time.LocalDate;




/**
 *
 * @author henry117
 */


public class Shipment implements Serializable{
    private int shipID; 
    private String email;   
    private String address;
    private int trackingNo;
    private String name;
    private int userID;
    private String type;
    private LocalDate date;
    private String status;
    
    
    
    public Shipment() {
        type = "STANDARD";
        date = LocalDate.now();
        status = "SUBMITTED";
    }
    public Shipment(int shipID){
       this.shipID = shipID;
    
    }
    public Shipment( int trackingNo, int userID, LocalDate date, String status){
       
       this.trackingNo = trackingNo;
       this.userID = userID;
       this.date = date;
       this.status = status;

    }


    public Shipment(String email, String address, String name, String type ) {
        this.shipID = shipID;
        this.email = email;
        this.address = address;
        this.name = name;
        this.type = type;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public int getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address ;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTrackingNo() {
        return trackingNo;
    }
   
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }
      
}
