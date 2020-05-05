package com.example.saurabhomer.qualityapp.Measurement;

import java.util.List;

public class MeasurementListModel {
    public String date;
    public List<MeasurementModel> measurementModels;

    public List<MeasurementModel> getMeasurementModels() {
        return measurementModels;
    }

    public void setMeasurementModels(List<MeasurementModel> measurementModels) {
        this.measurementModels = measurementModels;
    }
    public String getDate() {
        return date;
    }

    public MeasurementListModel() {
    }

    public void setDate(String date) {
        this.date = date;
    }
}
