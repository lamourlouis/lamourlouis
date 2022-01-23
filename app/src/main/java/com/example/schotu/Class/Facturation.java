package com.example.schotu.Class;

class Facturation {
    private  int factur_Id;
    private  double fact_Montant;
    private  int user_Id;
    private double nbr_Heure;
    boolean confirmation;

    public Facturation() {
    }

    public Facturation(int facture_Id, double fact_Montant, int user_Id, double nbr_Heure, boolean confirmation) {
        this.factur_Id = facture_Id;
        this.fact_Montant = fact_Montant;
        this.user_Id = user_Id;
        this.nbr_Heure = nbr_Heure;
        this.confirmation = confirmation;
    }

    //Setters and Getters

    public int getFacture_Id() {
        return factur_Id;
    }

    public void setFacture_Id(int facture_Id) {
        this.factur_Id = facture_Id;
    }

    public double getFact_Montant() {
        return fact_Montant;
    }

    public void setFact_Montant(double fact_Montant) {
        this.fact_Montant = fact_Montant;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public double getNbr_Heure() {
        return nbr_Heure;
    }

    public void setNbr_Heure(double nbr_Heure) {
        this.nbr_Heure = nbr_Heure;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }
}//fin classe
