package com.example.saurabhomer.qualityapp.Model.StyleModel;

public class StyleSheetModel {
    private String sheetNumber;
    private String BuyersName;
    private String ProduectName;
    private String OrderQuality;
    private String ShipmentDate;
    private String color;
    private  String size;


    String fabricDescription;

    public StyleSheetModel(String sheetNumber, String BuyersName, String produectName, String orderQuality, String shipmentDate, String color, String size, String fabricDescription) {
        this.sheetNumber = sheetNumber;
        this.BuyersName = BuyersName;
        ProduectName = produectName;
        OrderQuality = orderQuality;
        ShipmentDate = shipmentDate;
        this.color = color;
        this.size = size;
        this.fabricDescription = fabricDescription;
    }

    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public String getBuyersName() {
        return BuyersName;
    }

    public void setBuyersName(String buyersName) {
        BuyersName = buyersName;
    }

    public String getProduectName() {
        return ProduectName;
    }

    public void setProduectName(String produectName) {
        ProduectName = produectName;
    }

    public String getOrderQuality() {
        return OrderQuality;
    }

    public void setOrderQuality(String orderQuality) {
        OrderQuality = orderQuality;
    }

    public String getShipmentDate() {
        return ShipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        ShipmentDate = shipmentDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFabricDescription() {
        return fabricDescription;
    }

    public void setFabricDescription(String fabricDescription)
    {
        this.fabricDescription = fabricDescription;
    }
}
