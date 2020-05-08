package com.example.saurabhomer.qualityapp.CartoonAudit.model;

import java.util.ArrayList;

public class CartoonAuditModel
{
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<AreaofInsideCartoonModel> areaofInsideCartoonModelArrayList;

    public ArrayList<AreaOfPackingMaterialModel> areaOfPackingMaterialArrayList;

    public ArrayList<AreaofOutsideCartoonModel> areaofOutsideCartoonModelArrayList;

    public ArrayList<AreaofInsideCartoonModel> getAreaofInsideCartoonModelArrayList()
    {
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


}
