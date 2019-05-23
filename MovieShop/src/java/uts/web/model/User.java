/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;
import java.io.Serializable;
/**
 *
 * @author francobuena
 */
public class User implements Serializable {
    private String email;
    private String name;
    private String password;
    private String phonenumber;
    private boolean valid;
    
    public User() {
        super();
    }
    
    public User(String email, String name, String password, String phonenumber) {
        super();
        this.email = email;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhoneNumber() {
        return phonenumber;
    }
    
    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public boolean isValid() {
         return valid;
    }

      public void setValid(boolean newValid) {
         valid = newValid;
    }	
    
}
