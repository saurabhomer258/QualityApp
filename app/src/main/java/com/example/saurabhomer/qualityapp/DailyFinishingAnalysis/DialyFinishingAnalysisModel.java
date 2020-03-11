package com.example.saurabhomer.qualityapp.DailyFinishingAnalysis;

import android.widget.Button;

public class DialyFinishingAnalysisModel {
    private String PrintingMRBO,Slubs_Holes_NAR,colorShading,BrokenStitches,SlipStitches,SPI,Pukering,LooseTensions,SnapDefects,NeedleMark,OpenSeam,Pleats;
   private String MissingStitches,SkipRunOff,IncorrectLabel,WrongPlacement,LooseNess,CutDamage,Others,Stain,OilMark,Stickers,UncutThread,OutOfSpec;
    private String TotalDefect,QualityOut,ProductionOut,Damage,Dirty,Iron;
    private String hours;

    public String getPrintingMRBO() {
        return PrintingMRBO;
    }

    public void setPrintingMRBO(String printingMRBO) {
        PrintingMRBO = printingMRBO;
    }

    public String getSlubs_Holes_NAR() {
        return Slubs_Holes_NAR;
    }

    public void setSlubs_Holes_NAR(String slubs_Holes_NAR) {
        Slubs_Holes_NAR = slubs_Holes_NAR;
    }

    public String getBrokenStitches() {
        return BrokenStitches;
    }

    public void setBrokenStitches(String brokenStitches) {
        BrokenStitches = brokenStitches;
    }

    public String getSlipStitches() {
        return SlipStitches;
    }

    public void setSlipStitches(String slipStitches) {
        SlipStitches = slipStitches;
    }

    public String getSPI() {
        return SPI;
    }

    public void setSPI(String SPI) {
        this.SPI = SPI;
    }

    public String getPukering() {
        return Pukering;
    }

    public void setPukering(String pukering) {
        Pukering = pukering;
    }

    public String getLooseTensions() {
        return LooseTensions;
    }

    public void setLooseTensions(String looseTensions) {
        LooseTensions = looseTensions;
    }

    public String getSnapDefects() {
        return SnapDefects;
    }

    public void setSnapDefects(String snapDefects) {
        SnapDefects = snapDefects;
    }

    public String getNeedleMark() {
        return NeedleMark;
    }

    public void setNeedleMark(String needleMark) {
        NeedleMark = needleMark;
    }

    public String getOpenSeam() {
        return OpenSeam;
    }

    public void setOpenSeam(String openSeam) {
        OpenSeam = openSeam;
    }

    public String getPleats() {
        return Pleats;
    }

    public void setPleats(String pleats) {
        Pleats = pleats;
    }

    public String getMissingStitches() {
        return MissingStitches;
    }

    public void setMissingStitches(String missingStitches) {
        MissingStitches = missingStitches;
    }

    public String getSkipRunOff() {
        return SkipRunOff;
    }

    public void setSkipRunOff(String skipRunOff) {
        SkipRunOff = skipRunOff;
    }

    public String getIncorrectLabel() {
        return IncorrectLabel;
    }

    public void setIncorrectLabel(String incorrectLabel) {
        IncorrectLabel = incorrectLabel;
    }

    public String getWrongPlacement() {
        return WrongPlacement;
    }

    public void setWrongPlacement(String wrongPlacement) {
        WrongPlacement = wrongPlacement;
    }

    public String getLooseNess() {
        return LooseNess;
    }

    public void setLooseNess(String looseNess) {
        LooseNess = looseNess;
    }

    public String getCutDamage() {
        return CutDamage;
    }

    public void setCutDamage(String cutDamage) {
        CutDamage = cutDamage;
    }

    public String getOthers() {
        return Others;
    }

    public void setOthers(String others) {
        Others = others;
    }

    public String getStain() {
        return Stain;
    }

    public void setStain(String stain) {
        Stain = stain;
    }

    public String getOilMark() {
        return OilMark;
    }

    public void setOilMark(String oilMark) {
        OilMark = oilMark;
    }

    public String getStickers() {
        return Stickers;
    }

    public void setStickers(String stickers) {
        Stickers = stickers;
    }

    public String getUncutThread() {
        return UncutThread;
    }

    public void setUncutThread(String uncutThread) {
        UncutThread = uncutThread;
    }

    public String getOutOfSpec() {
        return OutOfSpec;
    }

    public void setOutOfSpec(String outOfSpec) {
        OutOfSpec = outOfSpec;
    }

    public String getTotalDefect() {
        return TotalDefect;
    }

    public void setTotalDefect(String totalDefect) {
        TotalDefect = totalDefect;
    }

    public String getQualityOut() {
        return QualityOut;
    }

    public void setQualityOut(String qualityOut) {
        QualityOut = qualityOut;
    }

    public String getProductionOut() {
        return ProductionOut;
    }

    public void setProductionOut(String productionOut) {
        ProductionOut = productionOut;
    }

    public String getDamage() {
        return Damage;
    }

    public void setDamage(String damage) {
        Damage = damage;
    }

    public String getDirty() {
        return Dirty;
    }

    public void setDirty(String dirty) {
        Dirty = dirty;
    }

    public String getIron() {
        return Iron;
    }

    public void setIron(String iron) {
        Iron = iron;
    }

    public DialyFinishingAnalysisModel(String printingMRBO, String slubs_Holes_NAR, String colorShading, String brokenStitches, String slipStitches, String SPI, String pukering, String looseTensions, String snapDefects, String needleMark, String openSeam, String pleats, String missingStitches, String skipRunOff, String incorrectLabel, String wrongPlacement, String looseNess, String cutDamage, String others, String stain, String oilMark, String stickers, String uncutThread, String outOfSpec, String totalDefect, String qualityOut, String productionOut, String damage, String dirty, String iron, String hours) {
        PrintingMRBO = printingMRBO;
        Slubs_Holes_NAR = slubs_Holes_NAR;
        this.colorShading = colorShading;
        BrokenStitches = brokenStitches;
        SlipStitches = slipStitches;
        this.SPI = SPI;
        Pukering = pukering;
        LooseTensions = looseTensions;
        SnapDefects = snapDefects;
        NeedleMark = needleMark;
        OpenSeam = openSeam;
        Pleats = pleats;
        MissingStitches = missingStitches;
        SkipRunOff = skipRunOff;
        IncorrectLabel = incorrectLabel;
        WrongPlacement = wrongPlacement;
        LooseNess = looseNess;
        CutDamage = cutDamage;
        Others = others;
        Stain = stain;
        OilMark = oilMark;
        Stickers = stickers;
        UncutThread = uncutThread;
        OutOfSpec = outOfSpec;
        TotalDefect = totalDefect;
        QualityOut = qualityOut;
        ProductionOut = productionOut;
        Damage = damage;
        Dirty = dirty;
        Iron = iron;
        this.hours = hours;
    }
}
