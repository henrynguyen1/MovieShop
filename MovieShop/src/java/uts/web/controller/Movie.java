/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.web.controller;

/**
 *
 * @author HenryNguyen
 */
public class Movie {
    private String movieID;
    private String title; 
    private String genre; 
    private String duration;
    private double price;
    
    
    
    public Movie(String movieID, String title, String genre, String duration, double price) {
        this.movieID = movieID;
        this.title = title; 
        this.genre = genre; 
        this.duration = duration; 
        this.price = price;
    }
   
    public String getmovieID() {
        return movieID;
    }
    public String gettitle() {
        return title;
    }
    public String getgenre(){
        return genre;
    }
    public String getduration(){
        return duration;
    }
    public double getprice(){
        return price;
    }
    }

    

