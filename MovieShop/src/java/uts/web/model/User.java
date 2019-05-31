package uts.web.model;
import java.io.Serializable;
/**
 *
 * @author francobuena
 */
public class User implements Serializable {
    private String ID;
    private String email;
    private String name;
    private String password;
    private String phonenumber;
    
    public User(String ID, String email, String name, String password, String phonenumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
        this.ID = ID;
    }
    
    public User() { }
    
    public void updateDetails(String email, String name, String password, String phonenumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phonenumber = phonenumber;
    }
    
    public boolean matchID(String ID){
        return this.ID.equals(ID.trim());
    }
    
    public boolean matchPassword(String password){
        return this.password.equals(password.trim());
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
    
}