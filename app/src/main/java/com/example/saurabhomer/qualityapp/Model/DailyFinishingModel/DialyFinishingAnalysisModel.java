package com.example.saurabhomer.qualityapp.Model.DailyFinishingModel;

import android.widget.Button;

public class DialyFinishingAnalysisModel {
    private int PrintingMRBO,Slubs_Holes_NAR,colorShading,BrokenStitches,SlipStitches,SPI,Pukering,LooseTensions,SnapDefects,NeedleMark,OpenSeam,Pleats;
   private int MissingStitches,SkipRunOff,IncorrectLabel,WrongPlacement,LooseNess,CutDamage,Others,Stain,OilMark,Stickers,UncutThread,OutOfSpec;
    private int TotalDefect,QualityOut,ProductionOut,Damage,Dirty,Iron;
    private String hours;
    private int totalCheck;
    private int uneven;

    public DialyFinishingAnalysisModel()
    {

    }

    public int getPrintingMRBO() {
        return PrintingMRBO;
    }

    public int getUneven() {
        return uneven;
    }

    public void setUneven(int uneven) {
        this.uneven = uneven;
    }

    public void setPrintingMRBO(int printingMRBO) {
        PrintingMRBO = printingMRBO;
    }

    public int getSlubs_Holes_NAR() {
        return Slubs_Holes_NAR;
    }

    public void setSlubs_Holes_NAR(int slubs_Holes_NAR) {
        Slubs_Holes_NAR = slubs_Holes_NAR;
    }

    public int getColorShading() {
        return colorShading;
    }

    public void setColorShading(int colorShading) {
        this.colorShading = colorShading;
    }

    public int getBrokenStitches() {
        return BrokenStitches;
    }

    public void setBrokenStitches(int brokenStitches) {
        BrokenStitches = brokenStitches;
    }

    public int getSlipStitches() {
        return SlipStitches;
    }

    public void setSlipStitches(int slipStitches) {
        SlipStitches = slipStitches;
    }

    public int getSPI() {
        return SPI;
    }

    public void setSPI(int SPI) {
        this.SPI = SPI;
    }

    public int getPukering() {
        return Pukering;
    }

    public void setPukering(int pukering) {
        Pukering = pukering;
    }

    public int getLooseTensions() {
        return LooseTensions;
    }

    public void setLooseTensions(int looseTensions) {
        LooseTensions = looseTensions;
    }

    public int getSnapDefects() {
        return SnapDefects;
    }

    public void setSnapDefects(int snapDefects) {
        SnapDefects = snapDefects;
    }

    public int getNeedleMark() {
        return NeedleMark;
    }

    public void setNeedleMark(int needleMark) {
        NeedleMark = needleMark;
    }

    public int getOpenSeam() {
        return OpenSeam;
    }

    public void setOpenSeam(int openSeam) {
        OpenSeam = openSeam;
    }

    public int getPleats() {
        return Pleats;
    }

    public void setPleats(int pleats) {
        Pleats = pleats;
    }

    public int getMissingStitches() {
        return MissingStitches;
    }

    public void setMissingStitches(int missingStitches) {
        MissingStitches = missingStitches;
    }

    public int getSkipRunOff() {
        return SkipRunOff;
    }

    public void setSkipRunOff(int skipRunOff) {
        SkipRunOff = skipRunOff;
    }

    public int getIncorrectLabel() {
        return IncorrectLabel;
    }

    public void setIncorrectLabel(int incorrectLabel) {
        IncorrectLabel = incorrectLabel;
    }

    public int getWrongPlacement() {
        return WrongPlacement;
    }

    public void setWrongPlacement(int wrongPlacement) {
        WrongPlacement = wrongPlacement;
    }

    public int getLooseNess() {
        return LooseNess;
    }

    public void setLooseNess(int looseNess) {
        LooseNess = looseNess;
    }

    public int getCutDamage() {
        return CutDamage;
    }

    public void setCutDamage(int cutDamage) {
        CutDamage = cutDamage;
    }

    public int getOthers() {
        return Others;
    }

    public void setOthers(int others) {
        Others = others;
    }

    public int getStain() {
        return Stain;
    }

    public void setStain(int stain) {
        Stain = stain;
    }

    public int getOilMark() {
        return OilMark;
    }

    public void setOilMark(int oilMark) {
        OilMark = oilMark;
    }

    public int getStickers() {
        return Stickers;
    }

    public void setStickers(int stickers) {
        Stickers = stickers;
    }

    public int getUncutThread() {
        return UncutThread;
    }

    public void setUncutThread(int uncutThread) {
        UncutThread = uncutThread;
    }

    public int getOutOfSpec() {
        return OutOfSpec;
    }

    public void setOutOfSpec(int outOfSpec) {
        OutOfSpec = outOfSpec;
    }

    public int getTotalDefect() {
        return TotalDefect;
    }

    public void setTotalDefect(int totalDefect) {
        TotalDefect = totalDefect;
    }

    public int getQualityOut() {
        return QualityOut;
    }

    public void setQualityOut(int qualityOut) {
        QualityOut = qualityOut;
    }

    public int getProductionOut() {
        return ProductionOut;
    }

    public void setProductionOut(int productionOut) {
        ProductionOut = productionOut;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getDirty() {
        return Dirty;
    }

    public void setDirty(int dirty) {
        Dirty = dirty;
    }

    public int getIron() {
        return Iron;
    }

    public void setIron(int iron) {
        Iron = iron;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getTotalCheck() {
        return totalCheck;
    }

    public void setTotalCheck(int totalCheck) {
        this.totalCheck = totalCheck;
    }





    public DialyFinishingAnalysisModel(int totalCheck, int printingMRBO, int slubs_Holes_NAR, int colorShading,
                                       int brokenStitches, int slipStitches, int SPI,
                                       int pukering, int looseTensions, int snapDefects, int needleMark, int openSeam, int pleats, int missingStitches, int skipRunOff, int incorrectLabel, int wrongPlacement, int looseNess, int cutDamage, int others, int stain, int oilMark, int stickers, int uncutThread, int outOfSpec, int totalDefect, int qualityOut, int productionOut, int damage, int dirty, int iron, String hours,int uneven) {
        this.totalCheck = totalCheck ;
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
        this.uneven = uneven;
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
    public int getTotal(){
        return PrintingMRBO+Slubs_Holes_NAR + colorShading+BrokenStitches+SlipStitches+SPI+Pukering+LooseTensions+SnapDefects+NeedleMark+OpenSeam+Pleats
      +MissingStitches+SkipRunOff+IncorrectLabel+WrongPlacement+LooseNess+CutDamage+Others+Stain+OilMark+Stickers+UncutThread+OutOfSpec+
     TotalDefect+QualityOut+ProductionOut+Damage+Dirty+Iron+uneven;
    }
}
