/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.model;

/**
 *
 * @author fan
 */
public class Login {
    
    private String loginDate;
    private String logoutDate;
    
    
    public Login(String loginDate, String logoutDate) {
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
    }
    
    public String getLoginDate() {
        return loginDate;
    }
    
    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }
    
    public String getLogoutDate() {
        return logoutDate;
    }
    
    public void setLogoutDate(String logoutDate) {
        this.logoutDate = logoutDate;
    }
    
}
