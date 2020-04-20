package com.example.saurabhomer.qualityapp.MetelDetectionPage;

import java.util.ArrayList;

public class MetelDetectionPageModel
{

    private String edt_date;
    private String edt_time;
    private String edt_calibrated;
    private String edt_garment_pass;
    private String edt_garment_fail;
    private String edt_no_of_garment_check;
    private String remark;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getEdt_calibrated() {
        return edt_calibrated;
    }

    public void setEdt_calibrated(String edt_calibrated) {
        this.edt_calibrated = edt_calibrated;
    }

    public String getEdt_garment_pass() {
        return edt_garment_pass;
    }

    public void setEdt_garment_pass(String edt_garment_pass) {
        this.edt_garment_pass = edt_garment_pass;
    }

    public String getEdt_garment_fail() {
        return edt_garment_fail;
    }

    public void setEdt_garment_fail(String edt_garment_fail) {
        this.edt_garment_fail = edt_garment_fail;
    }

    public String getEdt_no_of_garment_check() {
        return edt_no_of_garment_check;
    }

    public void setEdt_no_of_garment_check(String edt_no_of_garment_check) {
        this.edt_no_of_garment_check = edt_no_of_garment_check;
    }
}
