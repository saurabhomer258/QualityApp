package com.example.saurabhomer.qualityapp.Model.DailyFinishingModel;

import java.util.ArrayList;

public class DailyFinishinfModels {

    ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels;
    DailyFinishingModel1 model;
    private String hours ;
    private String totalDefect ;

    private String DefectInPercent;
    private String totalCheck;

    public ArrayList<DialyFinishingAnalysisModel> getDialyFinishingAnalysisModels() {
        return dialyFinishingAnalysisModels;
    }

    public void setDialyFinishingAnalysisModels(ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels) {
        this.dialyFinishingAnalysisModels = dialyFinishingAnalysisModels;
    }

    public DailyFinishingModel1 getModel() {
        return model;
    }

    public void setModel(DailyFinishingModel1 model) {
        this.model = model;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getTotalDefect() {
        return totalDefect;
    }

    public void setTotalDefect(String totalDefect) {
        this.totalDefect = totalDefect;
    }

    public String getDefectInPercent() {
        return DefectInPercent;
    }

    public void setDefectInPercent(String defectInPercent) {
        DefectInPercent = defectInPercent;
    }

    public String getTotalCheck() {
        return totalCheck;
    }

    public void setTotalCheck(String totalCheck) {
        this.totalCheck = totalCheck;
    }
}
