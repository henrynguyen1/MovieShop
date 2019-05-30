/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.model1;

import java.time.LocalDate;

/**
 *
 * @author f
 */
public class Login {
    protected int id;
    protected String email;
    protected  String name;
    protected String password;
    protected String dob;
    private LocalDate date;

public Login(LocalDate date){
    this.date= date;
}
public Login(int id,String password) {
    this.id =id;
this.password = password;
}

     
    public Login(int id,  LocalDate date,String name, String email, String password, String dob){
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.id=id;
        date = LocalDate.now(); 
    }

   
    
    public boolean matchPassword(String password){
        return this.password.equals(password.trim());
    }

   public Login(String id, String email, String name, String password, String dob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public Login(String 1ID, String lEmail, String lName, String lPassword, String lDOB) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String Email) {
        this.email =email ;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name ) {
        this.name = name;
    }
 public String getPassword() {
        return password;
    }
 
    public void setPassword(String password ) {
        this.name = password;
    }
    public String getDob() {
        return dob;
    }
 
    public void setDob(String dob) {
        this.dob = dob;
    }
    public LocalDate getDate() {
        return date;
    }
}
