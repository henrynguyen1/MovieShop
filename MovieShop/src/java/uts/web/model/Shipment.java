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
    private String shipID; 
    private String email;   
    private String name;
    private String trackingNo;
    private int userID;
    private ShipmentType type;
    private LocalDate date;
    private ShipmentStatus status;
    
    
    
    
    
    public Shipment() {
        type = ShipmentType.STANDARD;
        date = LocalDate.now();
        status = ShipmentStatus.PROCESSING;
    }

    public Shipment(String shipID, String email, String name, String trackingNo, int userID, ShipmentType type, LocalDate date, ShipmentStatus status) {
        this.shipID = shipID;
        this.email = email;
        this.name = name;
        this.trackingNo = trackingNo;
        this.userID = userID;
        this.type = type;
        this.date = date;
        this.status = status;
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
