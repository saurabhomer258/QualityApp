package com.example.saurabhomer.qualityapp.Model.DailyFinishingModel;

public class DailyFinishingModel1 {
    private String hours ;
    private String totalDefect ;
    private String DefectInPercent;
    private String totalCheck;

    public DailyFinishingModel1(String hours, String totalDefect, String defectInPercent, String totalCheck) {
        this.hours = hours;
        this.totalDefect = totalDefect;
        DefectInPercent = defectInPercent;
        this.totalCheck = totalCheck;
    }

}
