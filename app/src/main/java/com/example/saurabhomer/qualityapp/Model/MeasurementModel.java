package com.example.saurabhomer.qualityapp.Model;

public class MeasurementModel {
    private String edt_measur;
    private String edt_tolerance_plus;
    private String edt_tolerance_minus;
    private String check_40;
    private String check_42;
    private String check_44;
    private String check_46;
    private String check_48;
    private String next;
    private String done;

    public MeasurementModel(String edt_measur, String edt_tolerance_plus, String edt_tolerance_minus, String check_40, String check_42, String check_44, String check_46, String check_48, String next, String done) {
        this.edt_measur = edt_measur;
        this.edt_tolerance_plus = edt_tolerance_plus;
        this.edt_tolerance_minus = edt_tolerance_minus;
        this.check_40 = check_40;
        this.check_42 = check_42;
        this.check_44 = check_44;
        this.check_46 = check_46;
        this.check_48 = check_48;
        this.next = next;
        this.done = done;
    }

    public String getEdt_measur() {
        return edt_measur;
    }

    public void setEdt_measur(String edt_measur) {
        this.edt_measur = edt_measur;
    }

    public String getEdt_tolerance_plus() {
        return edt_tolerance_plus;
    }

    public void setEdt_tolerance_plus(String edt_tolerance_plus) {
        this.edt_tolerance_plus = edt_tolerance_plus;
    }

    public String getEdt_tolerance_minus() {
        return edt_tolerance_minus;
    }

    public void setEdt_tolerance_minus(String edt_tolerance_minus) {
        this.edt_tolerance_minus = edt_tolerance_minus;
    }

    public String getCheck_40() {
        return check_40;
    }

    public void setCheck_40(String check_40) {
        this.check_40 = check_40;
    }

    public String getCheck_42() {
        return check_42;
    }

    public void setCheck_42(String check_42) {
        this.check_42 = check_42;
    }

    public String getCheck_44() {
        return check_44;
    }

    public void setCheck_44(String check_44) {
        this.check_44 = check_44;
    }

    public String getCheck_46() {
        return check_46;
    }

    public void setCheck_46(String check_46) {
        this.check_46 = check_46;
    }

    public String getCheck_48() {
        return check_48;
    }

    public void setCheck_48(String check_48) {
        this.check_48 = check_48;
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
}
