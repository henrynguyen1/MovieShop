package uts.web.model;
import java.io.Serializable;
import java.time.LocalDate;




/**
 *
 * @author henry117
 */
enum ShipmentStatus {
    PROCESSING,
    DESPATCHED,
    TRANSIT,
    DELIVERED,
    
}
enum ShipmentType{
    STANDARD,
    EXPRESS,
    LOCALPICKUP,

}

public class Shipment implements Serializable{
    private int shipID; 
    private String email;   
    private String address;
    private String trackingNo;
    private String name;
    private int userID;
    private ShipmentType type;
    private LocalDate date;
    private ShipmentStatus status;
    
    
    
    
    
    public Shipment() {
        type = ShipmentType.STANDARD;
        date = LocalDate.now();
        status = ShipmentStatus.PROCESSING;
    }

    public Shipment(int shipID, String email, String address, String trackingNo, String name, int userID, ShipmentType type, LocalDate date, ShipmentStatus status) {
        this.shipID = shipID;
        this.email = email;
        this.address = address;
        this.trackingNo = trackingNo;
        this.name = name;
        this.userID = userID;
        this.type = type;
        this.date = date;
        this.status = status;
    
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
    public ShipmentType getType(){
        return type;
    }
    public void setType(ShipmentType type){
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrackingNo() {
        return trackingNo;
    }
   
    public ShipmentStatus getStatus() {
        return status;
    }
    public void setStatus(ShipmentStatus status) {
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
