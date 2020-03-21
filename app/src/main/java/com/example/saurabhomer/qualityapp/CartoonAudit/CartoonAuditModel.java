package com.example.saurabhomer.qualityapp.CartoonAudit;

import com.example.saurabhomer.qualityapp.Model.DailyFinishingModel.DialyFinishingAnalysisModel;

import java.util.ArrayList;

public class CartoonAuditModel
{
    public String cartoonlotquantity;
    public String hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8;
    public ArrayList<AreaofInsideCartoonModel> areaofInsideCartoonModelArrayList;

    public ArrayList<AreaOfPackingMaterialModel> areaOfPackingMaterialArrayList;

    public ArrayList<AreaofOutsideCartoonModel> areaofOutsideCartoonModelArrayList;

    public ArrayList<AreaofInsideCartoonModel> getAreaofInsideCartoonModelArrayList() {
        return areaofInsideCartoonModelArrayList;
    }

    public void setAreaofInsideCartoonModelArrayList(ArrayList<AreaofInsideCartoonModel> areaofInsideCartoonModelArrayList) {
        this.areaofInsideCartoonModelArrayList = areaofInsideCartoonModelArrayList;
    }

    public ArrayList<AreaOfPackingMaterialModel> getAreaOfPackingMaterialArrayList() {
        return areaOfPackingMaterialArrayList;
    }

    public void setAreaOfPackingMaterialArrayList(ArrayList<AreaOfPackingMaterialModel> areaOfPackingMaterialArrayList) {
        this.areaOfPackingMaterialArrayList = areaOfPackingMaterialArrayList;
    }

    public ArrayList<AreaofOutsideCartoonModel> getAreaofOutsideCartoonModelArrayList() {
        return areaofOutsideCartoonModelArrayList;
    }

    public void setAreaofOutsideCartoonModelArrayList(ArrayList<AreaofOutsideCartoonModel> areaofOutsideCartoonModelArrayList) {
        this.areaofOutsideCartoonModelArrayList = areaofOutsideCartoonModelArrayList;
    }

    public String getCartoonlotquantity()
    {
        return cartoonlotquantity;
    }

    public void setCartoonlotquantity(String cartoonlotquantity) {
        this.cartoonlotquantity = cartoonlotquantity;
    }

    public String getHour1() {
        return hour1;
    }

    public void setHour1(String hour1) {
        this.hour1 = hour1;
    }

    public String getHour2() {
        return hour2;
    }

    public void setHour2(String hour2) {
        this.hour2 = hour2;
    }

    public String getHour3() {
        return hour3;
    }

    public void setHour3(String hour3) {
        this.hour3 = hour3;
    }

    public String getHour4() {
        return hour4;
    }

    public void setHour4(String hour4) {
        this.hour4 = hour4;
    }

    public String getHour5() {
        return hour5;
    }

    public void setHour5(String hour5) {
        this.hour5 = hour5;
    }

    public String getHour6() {
        return hour6;
    }

    public void setHour6(String hour6) {
        this.hour6 = hour6;
    }

    public String getHour7() {
        return hour7;
    }

    public void setHour7(String hour7) {
        this.hour7 = hour7;
    }

    public String getHour8() {
        return hour8;
    }

    public void setHour8(String hour8) {
        this.hour8 = hour8;
    }
}
