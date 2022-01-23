package com.example.schotu.Class;

import java.util.ArrayList;

class Order {
    private int order_id;
    private int user_Id;
    private String zone;
    private ArrayList<Double> Geocode;

    //Constructor
    public Order() {

    }

    public Order(int order_id, int user_Id, String zone, ArrayList<Double> geocode) {
        this.order_id = order_id;
        this.user_Id = user_Id;
        this.zone = zone;
        Geocode = geocode;
    }

    //Getters and Setters

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public ArrayList<Double> getGeocode() {
        return Geocode;
    }

    public void setGeocode(ArrayList<Double> geocode) {
        Geocode = geocode;
    }
}//Fin de la classe
