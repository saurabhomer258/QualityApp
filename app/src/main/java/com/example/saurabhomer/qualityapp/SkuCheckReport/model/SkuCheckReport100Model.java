package com.example.saurabhomer.qualityapp.SkuCheckReport.model;

import java.util.ArrayList;

public class SkuCheckReport100Model {
    public String edt_readyquantity;
    public String edt_checkquantity;
    public String edt_size;
    private String date;
    public ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList;

    public String getEdt_readyquantity() {
        return edt_readyquantity;
    }

    public void setEdt_readyquantity(String edt_readyquantity) {
        this.edt_readyquantity = edt_readyquantity;
    }

    public String getEdt_checkquantity() {
        return edt_checkquantity;
    }

    public void setEdt_checkquantity(String edt_checkquantity) {
        this.edt_checkquantity = edt_checkquantity;
    }

    public String getEdt_size() {
        return edt_size;
    }

    public void setEdt_size(String edt_size) {
        this.edt_size = edt_size;
    }

    public ArrayList<SkuCheckReport100ModelList> getSkuCheckReport100ModelList() {
        return skuCheckReport100ModelList;
    }

    public void setSkuCheckReport100ModelList(ArrayList<SkuCheckReport100ModelList> skuCheckReport100ModelList) {
        this.skuCheckReport100ModelList = skuCheckReport100ModelList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
