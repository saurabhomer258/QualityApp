package com.example.saurabhomer.qualityapp.Measurement;

import java.util.ArrayList;

public class MeasurementModel {
    public String hours;

    public ArrayList<String> values;

    public MeasurementModel(String hours, ArrayList<String> values) {
        this.hours = hours;

        this.values = values;
    }

    public MeasurementModel() {
    }



    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }



    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }
}
