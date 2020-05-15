package com.example.saurabhomer.qualityapp.InlinePrelineFinal.handles;

public class ResultModel {
    String AQL;
    String INSPECTION;
    String SAMPLESIZE;
    int CRITICAL_ACE;
    int CRITICAL_REJ;
    int MAJORL_ACE;
    int MAJOR_REJ;
    int MINOR_ACE;
    int MINOR_REJ;

    public ResultModel() {
    }

    public ResultModel(String AQL, String INSPECTION, String SAMPLESIZE, int CRITICAL_ACE, int CRITICAL_REJ, int MAJORL_ACE, int MAJOR_REJ, int MINOR_ACE, int MINOR_REJ) {
        this.AQL = AQL;
        this.INSPECTION = INSPECTION;
        this.SAMPLESIZE = SAMPLESIZE;
        this.CRITICAL_ACE = CRITICAL_ACE;
        this.CRITICAL_REJ = CRITICAL_REJ;
        this.MAJORL_ACE = MAJORL_ACE;
        this.MAJOR_REJ = MAJOR_REJ;
        this.MINOR_ACE = MINOR_ACE;
        this.MINOR_REJ = MINOR_REJ;
    }

    public String getAQL() {
        return AQL;
    }

    public void setAQL(String AQL) {
        this.AQL = AQL;
    }

    public String getINSPECTION() {
        return INSPECTION;
    }

    public void setINSPECTION(String INSPECTION) {
        this.INSPECTION = INSPECTION;
    }

    public String getSAMPLESIZE() {
        return SAMPLESIZE;
    }

    public void setSAMPLESIZE(String SAMPLESIZE) {
        this.SAMPLESIZE = SAMPLESIZE;
    }

    public int getCRITICAL_ACE() {
        return CRITICAL_ACE;
    }

    public void setCRITICAL_ACE(int CRITICAL_ACE) {
        this.CRITICAL_ACE = CRITICAL_ACE;
    }

    public int getCRITICAL_REJ() {
        return CRITICAL_REJ;
    }

    public void setCRITICAL_REJ(int CRITICAL_REJ) {
        this.CRITICAL_REJ = CRITICAL_REJ;
    }

    public int getMAJORL_ACE() {
        return MAJORL_ACE;
    }

    public void setMAJORL_ACE(int MAJORL_ACE) {
        this.MAJORL_ACE = MAJORL_ACE;
    }

    public int getMAJOR_REJ() {
        return MAJOR_REJ;
    }

    public void setMAJOR_REJ(int MAJOR_REJ) {
        this.MAJOR_REJ = MAJOR_REJ;
    }

    public int getMINOR_ACE() {
        return MINOR_ACE;
    }

    public void setMINOR_ACE(int MINOR_ACE) {
        this.MINOR_ACE = MINOR_ACE;
    }

    public int getMINOR_REJ() {
        return MINOR_REJ;
    }

    public void setMINOR_REJ(int MINOR_REJ) {
        this.MINOR_REJ = MINOR_REJ;
    }
}
