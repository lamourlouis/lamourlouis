package com.example.schotu.Class;

import java.util.Date;

class Admin {
    private int admin_Id;
    private String ad_name;
    private String ad_first_name;
    private String ad_address;
    private String ad_tel;
    private String ad_email;
    private Date date;

    //constructor

    public Admin() {
    }

    public Admin(int admin_Id, String ad_name, String ad_firstname, String ad_address, String ad_tel, String ad_email, Date date) {
        this.admin_Id = admin_Id;
        this.ad_name = ad_name;
        this.ad_first_name = ad_firstname;
        this.ad_address = ad_address;
        this.ad_tel = ad_tel;
        this.ad_email = ad_email;
        this.date = date;
    }

//setters and Getters

    public int getAdmin_Id() {
        return admin_Id;
    }

    public void setAdmin_Id(int admin_Id) {
        this.admin_Id = admin_Id;
    }

    public String getAd_name() {
        return ad_name;
    }

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public String getAd_firstname() {
        return ad_first_name;
    }

    public void setAd_firstname(String ad_firstname) {
        this.ad_first_name = ad_firstname;
    }

    public String getAd_address() {
        return ad_address;
    }

    public void setAd_address(String ad_address) {
        this.ad_address = ad_address;
    }

    public String getAd_tel() {
        return ad_tel;
    }

    public void setAd_tel(String ad_tel) {
        this.ad_tel = ad_tel;
    }

    public String getAd_email() {
        return ad_email;
    }

    public void setAd_email(String ad_email) {
        this.ad_email = ad_email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}//fin classe
