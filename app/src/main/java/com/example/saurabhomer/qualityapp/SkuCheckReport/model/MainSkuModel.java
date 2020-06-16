package com.example.saurabhomer.qualityapp.SkuCheckReport.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainSkuModel {
    ArrayList<SkuDateModel> skuDateModels = new ArrayList<>();

    public ArrayList<SkuDateModel> getSkuDateModels()
    {
        return skuDateModels;
    }

    public void setSkuDateModels(ArrayList<SkuDateModel> skuDateModels) {
        this.skuDateModels = skuDateModels;
    }
}
