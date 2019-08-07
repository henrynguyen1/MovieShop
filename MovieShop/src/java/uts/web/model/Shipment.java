package uts.web.model;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author henry117
 */


public class Shipment implements Serializable{
    private String shipID; 
    private String email;   
    private String address;
    private String trackingNo;
    private String userID;
    private String type;
    private String status;
    
    
    
    public Shipment() {
        type = "STANDARD";
        status = "SUBMITTED";
    }
    public Shipment(String shipID){
       this.shipID = shipID;
    
    }
    public Shipment( String trackingNo, String userID, String status){
       
       this.trackingNo = trackingNo;
       this.userID = userID;
       this.status = status;

    }
    public Shipment( String shipID, String address,  String type, String trackingNo, String userID, String status ){
        this.shipID = shipID;
        this.email = email;
        this.address = address;
        this.type = type;
        this.trackingNo = trackingNo;
        this.userID = userID;
        this.status = status;
    }


//    public Shipment(String ShipID, String email, String address,  String type ) {
//        this.shipID = shipID;
//        this.email = email;
//        this.address = address;
//        
//        this.type = type;
//       
//    }

    

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

    public String getTrackingNo() {
        return trackingNo;
    }
   
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }
      
}
