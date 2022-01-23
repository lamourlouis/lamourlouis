package com.example.schotu.Class;

public class Tutor {

    private String tutorName;
    private String tutor_pwd;
    private String tutor_email;
  //  private int telephone;
    //private String adress;

    public Tutor() {
    }

/*
    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
*/
    public Tutor(String tutorName, String tutor_pwd, String tutor_email) {
        this.tutorName = tutorName;
        this.tutor_pwd = tutor_pwd;
        this.tutor_email = tutor_email;
       // this.telephone = telephone;
        //this.adress = adress;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutor_pwd() {
        return tutor_pwd;
    }

    public void setTutor_pwd(String tutor_pwd) {
        this.tutor_pwd = tutor_pwd;
    }

    public String getTutor_email() {
        return tutor_email;
    }

    public void setTutor_email(String tutor_email) {
        this.tutor_email = tutor_email;
    }


}//fin de la classe
