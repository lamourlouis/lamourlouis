package com.example.schotu.Class;

class Payment {
    private int payment_id;
    private double pay_Montant;
    private double hours;
    private double rate;
     //constructor

    public Payment() {
    }

    public Payment(int payment_id, double pay_Montant, double hours, double rate) {
        this.payment_id = payment_id;
        this.pay_Montant = pay_Montant;
        this.hours = hours;
        this.rate = rate;
    }
    //Setters and Getters

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public double getPay_Montant() {
        return pay_Montant;
    }

    public void setPay_Montant(double pay_Montant) {
        this.pay_Montant = pay_Montant;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
