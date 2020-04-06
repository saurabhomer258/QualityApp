package com.example.saurabhomer.qualityapp.Model.DailyFinishingModel;

import java.util.ArrayList;

public class DailyFinishinfModels
{
    ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels;


    public String date;

    private String finishingLine;

    public ArrayList<DialyFinishingAnalysisModel> getDialyFinishingAnalysisModels() {
        return dialyFinishingAnalysisModels;
    }

    public void setDialyFinishingAnalysisModels(ArrayList<DialyFinishingAnalysisModel> dialyFinishingAnalysisModels) {
        this.dialyFinishingAnalysisModels = dialyFinishingAnalysisModels;
    }

    public String getFinishingLine() {
        return finishingLine;
    }

    public void setFinishingLine(String finishingLine) {
        this.finishingLine = finishingLine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
