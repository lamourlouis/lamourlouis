package com.example.schotu.Class;

class Payment_Log {
    private int payment_Id;
    private int Tutor_id;

    //constructor

    public Payment_Log() {
    }

    public Payment_Log(int payment_Id, int tutor_id) {
        this.payment_Id = payment_Id;
        Tutor_id = tutor_id;
    }
    //getters and setters

    public int getPayment_Id() {
        return payment_Id;
    }

    public void setPayment_Id(int payment_Id) {
        this.payment_Id = payment_Id;
    }

    public int getTutor_id() {
        return Tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        Tutor_id = tutor_id;
    }
}
