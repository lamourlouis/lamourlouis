package com.example.schotu.Class;

class Facture_log {
    private int factur_Id;
    private int user_Id;
    //constructor

    public Facture_log() {
    }

    public Facture_log(int factur_Id, int user_Id) {
        this.factur_Id = factur_Id;
        this.user_Id = user_Id;
    }
    //getters and setters

    public int getFactur_Id() {
        return factur_Id;
    }

    public void setFactur_Id(int factur_Id) {
        this.factur_Id = factur_Id;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }
}
