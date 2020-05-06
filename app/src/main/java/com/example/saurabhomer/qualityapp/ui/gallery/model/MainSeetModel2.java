package com.example.saurabhomer.qualityapp.ui.gallery.model;

public class MainSeetModel2 {

    public String measurementDiscription;
    public String toerance;
    public String size;

    public MainSeetModel2(String measurementDiscription, String toerance, String size) {
        this.measurementDiscription = measurementDiscription;
        this.toerance = toerance;
        this.size = size;
    }

    public MainSeetModel2() {
    }

    public String getMeasurementDiscription() {
        return measurementDiscription;
    }

    public void setMeasurementDiscription(String measurementDiscription) {
        this.measurementDiscription = measurementDiscription;
    }

    public String getToerance() {
        return toerance;
    }

    public void setToerance(String toerance) {
        this.toerance = toerance;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
