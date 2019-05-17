/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;


import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author HenryNguyen
 */
public class Shipments {
    private ArrayList<Shipment> list = new ArrayList<Shipment>();
    
    
    public ArrayList<Shipment> getList(){
    return list;
    }
    
    public void addShipment(Shipment shipment){
    list.add(shipment);
    }
    
    public void removeShipment(Shipment shipment){
        list.remove(shipment);
    }
    
    public Shipment getShipmentWithID(String shipID){
       for (Shipment shipment: list){
           if(shipment.getShipID() == shipID){
               return shipment;
       }
    }
       return null;
    }  
   
    public Shipment getShipmentWithName(String name){
        for (Shipment shipment : list){
            if (shipment.getName().equals(name))
                return shipment;
        }
        return null;
    }
    
}


