package com.example.saurabhomer.qualityapp.Model;

public class MetelDetectionPageModel
{
    private String next;
    private String done;
    private String edt_date;
    private String edt_time;
    private String countryhasbeencheck;
    private String edt_garment_pass;
    private String edt_garment;

    public MetelDetectionPageModel(String next, String done, String edt_date, String edt_time, String countryhasbeencheck, String edt_garment_pass, String edt_garment) {
        this.next = next;
        this.done = done;
        this.edt_date = edt_date;
        this.edt_time = edt_time;
        this.countryhasbeencheck = countryhasbeencheck;
        this.edt_garment_pass = edt_garment_pass;
        this.edt_garment = edt_garment;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getEdt_date() {
        return edt_date;
    }

    public void setEdt_date(String edt_date) {
        this.edt_date = edt_date;
    }

    public String getEdt_time() {
        return edt_time;
    }

    public void setEdt_time(String edt_time) {
        this.edt_time = edt_time;
    }

    public String getCountryhasbeencheck() {
        return countryhasbeencheck;
    }

    public void setCountryhasbeencheck(String countryhasbeencheck) {
        this.countryhasbeencheck = countryhasbeencheck;
    }

    public String getEdt_garment_pass() {
        return edt_garment_pass;
    }

    public void setEdt_garment_pass(String edt_garment_pass) {
        this.edt_garment_pass = edt_garment_pass;
    }

    public String getEdt_garment() {
        return edt_garment;
    }

    public void setEdt_garment(String edt_garment) {
        this.edt_garment = edt_garment;
    }
}
