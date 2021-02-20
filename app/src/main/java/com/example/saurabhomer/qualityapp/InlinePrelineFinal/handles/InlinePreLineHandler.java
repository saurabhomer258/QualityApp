package com.example.saurabhomer.qualityapp.InlinePrelineFinal.handles;

import android.util.Log;

import com.example.saurabhomer.qualityapp.InlinePrelineFinal.InlinePrelineFinal;

public class InlinePreLineHandler {
    String mAQL,mINSPECTIONLevel;
    int mQUANTITY;
    public InlinePreLineHandler(String AQL, String INSPECTIONLev, Integer QUANTITY){
        mAQL =  AQL;
        mINSPECTIONLevel  = INSPECTIONLev ;
        mQUANTITY = QUANTITY;
    }
    public  ResultModel getResult(){
        ResultModel resultModel = new ResultModel();
        resultModel.setAQL(mAQL);
        resultModel.setINSPECTION(mINSPECTIONLevel);
        if(mAQL.equals("AQL 1.5")) {

            if(mINSPECTIONLevel.equals("GENERAL1")){
                    if(mQUANTITY<8 ){
                        resultModel.setSAMPLESIZE(2+"");
                        resultModel.setCRITICAL_ACE(0);
                        resultModel.setCRITICAL_REJ(1);
                        resultModel.setMAJORL_ACE(0);
                        resultModel.setMAJOR_REJ(1);
                        resultModel.setMINOR_ACE(0);
                        resultModel.setMINOR_REJ(1);

                    }
                    else  if(mQUANTITY<15){
                        resultModel.setSAMPLESIZE(8+"");
                        resultModel.setCRITICAL_ACE(0);
                        resultModel.setCRITICAL_REJ(1);
                        resultModel.setMAJORL_ACE(0);
                        resultModel.setMAJOR_REJ(1);
                        resultModel.setMINOR_ACE(0);
                        resultModel.setMINOR_REJ(1);
                    }
                    else  if(mQUANTITY<25){
                        resultModel.setSAMPLESIZE(8+"");
                        resultModel.setCRITICAL_ACE(0);
                        resultModel.setCRITICAL_REJ(1);
                        resultModel.setMAJORL_ACE(0);
                        resultModel.setMAJOR_REJ(1);
                        resultModel.setMINOR_ACE(0);
                        resultModel.setMINOR_REJ(1);
                    }
                    else  if(mQUANTITY<50){
                        resultModel.setSAMPLESIZE(8+"");
                        resultModel.setCRITICAL_ACE(0);
                        resultModel.setCRITICAL_REJ(1);
                        resultModel.setMAJORL_ACE(0);
                        resultModel.setMAJOR_REJ(1);
                        resultModel.setMINOR_ACE(0);
                        resultModel.setMINOR_REJ(1);
                    }
                    else  if(mQUANTITY<150){
                        resultModel.setSAMPLESIZE(8+"");
                        resultModel.setCRITICAL_ACE(0);
                        resultModel.setCRITICAL_REJ(1);
                        resultModel.setMAJORL_ACE(0);
                        resultModel.setMAJOR_REJ(1);
                        resultModel.setMINOR_ACE(0);
                        resultModel.setMINOR_REJ(1);
                    }
                    else  if(mQUANTITY<280){
                        resultModel.setSAMPLESIZE(20+"");
                        resultModel.setCRITICAL_ACE(0);
                        resultModel.setCRITICAL_REJ(1);
                        resultModel.setMAJORL_ACE(0);
                        resultModel.setMAJOR_REJ(1);
                        resultModel.setMINOR_ACE(0);
                        resultModel.setMINOR_REJ(1);
                    }
                    else  if(mQUANTITY<500){
                        resultModel.setSAMPLESIZE(32+"");
                        resultModel.setCRITICAL_ACE(1);
                        resultModel.setCRITICAL_REJ(2);
                        resultModel.setMAJORL_ACE(1);
                        resultModel.setMAJOR_REJ(2);
                        resultModel.setMINOR_ACE(1);
                        resultModel.setMINOR_REJ(2);
                    }
                    else  if(mQUANTITY<1200){
                        resultModel.setSAMPLESIZE(32+"");
                        resultModel.setCRITICAL_ACE(1);
                        resultModel.setCRITICAL_REJ(2);
                        resultModel.setMAJORL_ACE(1);
                        resultModel.setMAJOR_REJ(2);
                        resultModel.setMINOR_ACE(1);
                        resultModel.setMINOR_REJ(2);
                    }else  if(mQUANTITY<3200){
                        resultModel.setSAMPLESIZE(50+"");
                        resultModel.setCRITICAL_ACE(2);
                        resultModel.setCRITICAL_REJ(3);
                        resultModel.setMAJORL_ACE(2);
                        resultModel.setMAJOR_REJ(3);
                        resultModel.setMINOR_ACE(2);
                        resultModel.setMINOR_REJ(3);
                    }


                    else  if(mQUANTITY<10000){
                        resultModel.setSAMPLESIZE(80+"");
                        resultModel.setCRITICAL_ACE(3);
                        resultModel.setCRITICAL_REJ(4);
                    }
                    else  if(mQUANTITY<35000){
                        resultModel.setSAMPLESIZE(125+"");
                        resultModel.setCRITICAL_ACE(5);
                        resultModel.setCRITICAL_REJ(6);
                    }

                    else  if(mQUANTITY<150000){
                        resultModel.setSAMPLESIZE(200+"");
                        resultModel.setCRITICAL_ACE(7);
                        resultModel.setCRITICAL_REJ(8);
                    }
                    else  if(mQUANTITY<500000){
                        resultModel.setSAMPLESIZE(315+"");
                        resultModel.setCRITICAL_ACE(10);
                        resultModel.setCRITICAL_REJ(11);
                    }
                    else {
                        resultModel.setSAMPLESIZE(500+"");
                        resultModel.setCRITICAL_ACE(14);
                        resultModel.setCRITICAL_REJ(15);
                    }





            }
            else if(mINSPECTIONLevel.equals("GENERAL2")){
                if(mQUANTITY<8 ){
                    resultModel.setSAMPLESIZE(2+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);


                }
                else  if(mQUANTITY<15){
                    resultModel.setSAMPLESIZE(8+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<25){
                    resultModel.setSAMPLESIZE(8+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<50){
                    resultModel.setSAMPLESIZE(8+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<150){
                    resultModel.setSAMPLESIZE(32+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<280){
                    resultModel.setSAMPLESIZE(50+"");
                    resultModel.setCRITICAL_ACE(2);
                    resultModel.setCRITICAL_REJ(3);

                }
                else  if(mQUANTITY<500){
                    resultModel.setSAMPLESIZE(80+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);

                }
                else  if(mQUANTITY<1200){
                    resultModel.setSAMPLESIZE(80+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);

                }else  if(mQUANTITY<3200){

                    resultModel.setSAMPLESIZE(125+"");
                    resultModel.setCRITICAL_ACE(5);
                    resultModel.setCRITICAL_REJ(6);
                }


                else  if(mQUANTITY<10000){
                    resultModel.setSAMPLESIZE(200+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);
                }
                else  if(mQUANTITY<35000){
                    resultModel.setSAMPLESIZE(315+"");
                    resultModel.setCRITICAL_ACE(10);
                    resultModel.setCRITICAL_REJ(11);
                }

                else  if(mQUANTITY<150000){
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(14);
                    resultModel.setCRITICAL_REJ(15);
                }
                else  if(mQUANTITY<500000){
                    resultModel.setSAMPLESIZE(800+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
                else {
                    resultModel.setSAMPLESIZE(800+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
            }
            else if(mINSPECTIONLevel.equals("GENERAL3")){
                if(mQUANTITY<8 ){
                    resultModel.setSAMPLESIZE(2+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);


                }
                else  if(mQUANTITY<15){
                    resultModel.setSAMPLESIZE(8+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<25){
                    resultModel.setSAMPLESIZE(8+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<50){
                    resultModel.setSAMPLESIZE(8+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<150){
                    resultModel.setSAMPLESIZE(32+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<280){
                    resultModel.setSAMPLESIZE(50+"");
                    resultModel.setCRITICAL_ACE(2);
                    resultModel.setCRITICAL_REJ(3);

                }
                else  if(mQUANTITY<500){
                    resultModel.setSAMPLESIZE(80+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);

                }
                else  if(mQUANTITY<1200){
                    resultModel.setSAMPLESIZE(125+"");
                    resultModel.setCRITICAL_ACE(5);
                    resultModel.setCRITICAL_REJ(6);

                }else  if(mQUANTITY<3200){

                    resultModel.setSAMPLESIZE(200+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);
                }


                else  if(mQUANTITY<10000){
                    resultModel.setSAMPLESIZE(315+"");
                    resultModel.setCRITICAL_ACE(10);
                    resultModel.setCRITICAL_REJ(11);
                }
                else  if(mQUANTITY<35000){
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(14);
                    resultModel.setCRITICAL_REJ(15);
                }

                else  if(mQUANTITY<150000){
                    resultModel.setSAMPLESIZE(800+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
                else  if(mQUANTITY<500000){
                    resultModel.setSAMPLESIZE(800+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
                else {
                    resultModel.setSAMPLESIZE(800+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
            }
            else {
                Log.e("InlinePreLineHandler","not found");
            }
        }
        if(mAQL.equals("AQL 2.5")) {
            if(mINSPECTIONLevel.equals("GENERAL1")){
                if(mQUANTITY<8 ){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);


                }
                else  if(mQUANTITY<15){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<25){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<50){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<150){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<280){
                    resultModel.setSAMPLESIZE(20+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<500){
                    resultModel.setSAMPLESIZE(20+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<1200){
                    resultModel.setSAMPLESIZE(32+"");
                    resultModel.setCRITICAL_ACE(2);
                    resultModel.setCRITICAL_REJ(3);

                }else  if(mQUANTITY<3200){

                    resultModel.setSAMPLESIZE(50+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);
                }


                else  if(mQUANTITY<10000){
                    resultModel.setSAMPLESIZE(80+"");
                    resultModel.setCRITICAL_ACE(5);
                    resultModel.setCRITICAL_REJ(6);
                }
                else  if(mQUANTITY<35000){
                    resultModel.setSAMPLESIZE(125+"");
                    resultModel.setCRITICAL_ACE(7);
                    resultModel.setCRITICAL_REJ(8);
                }

                else  if(mQUANTITY<150000){
                    resultModel.setSAMPLESIZE(200+"");
                    resultModel.setCRITICAL_ACE(10);
                    resultModel.setCRITICAL_REJ(11);
                }
                else  if(mQUANTITY<500000){
                    resultModel.setSAMPLESIZE(315+"");
                    resultModel.setCRITICAL_ACE(14);
                    resultModel.setCRITICAL_REJ(15);
                }
                else {
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
            }
            else if(mINSPECTIONLevel.equals("GENERAL2")){
                if(mQUANTITY<8 ){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);


                }
                else  if(mQUANTITY<15){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<25){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<50){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<150){
                    resultModel.setSAMPLESIZE(20+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<280){
                    resultModel.setSAMPLESIZE(32+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<500){
                    resultModel.setSAMPLESIZE(50+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<1200){
                    resultModel.setSAMPLESIZE(80+"");
                    resultModel.setCRITICAL_ACE(2);
                    resultModel.setCRITICAL_REJ(3);

                }else  if(mQUANTITY<3200){

                    resultModel.setSAMPLESIZE(125+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);
                }


                else  if(mQUANTITY<10000){
                    resultModel.setSAMPLESIZE(200+"");
                    resultModel.setCRITICAL_ACE(5);
                    resultModel.setCRITICAL_REJ(6);
                }
                else  if(mQUANTITY<35000){
                    resultModel.setSAMPLESIZE(315+"");
                    resultModel.setCRITICAL_ACE(7);
                    resultModel.setCRITICAL_REJ(8);
                }

                else  if(mQUANTITY<150000){
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(10);
                    resultModel.setCRITICAL_REJ(11);
                }
                else  if(mQUANTITY<500000){
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(14);
                    resultModel.setCRITICAL_REJ(15);
                }
                else {
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
            }
            else if(mINSPECTIONLevel.equals("GENERAL3")){
                if(mQUANTITY<8 ){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);


                }
                else  if(mQUANTITY<15){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<25){
                    resultModel.setSAMPLESIZE(5+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<50){
                    resultModel.setSAMPLESIZE(20+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<150){
                    resultModel.setSAMPLESIZE(32+"");
                    resultModel.setCRITICAL_ACE(0);
                    resultModel.setCRITICAL_REJ(1);

                }
                else  if(mQUANTITY<280){
                    resultModel.setSAMPLESIZE(50+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<500){
                    resultModel.setSAMPLESIZE(80+"");
                    resultModel.setCRITICAL_ACE(1);
                    resultModel.setCRITICAL_REJ(2);

                }
                else  if(mQUANTITY<1200){
                    resultModel.setSAMPLESIZE(125+"");
                    resultModel.setCRITICAL_ACE(2);
                    resultModel.setCRITICAL_REJ(3);

                }else  if(mQUANTITY<3200){

                    resultModel.setSAMPLESIZE(200+"");
                    resultModel.setCRITICAL_ACE(3);
                    resultModel.setCRITICAL_REJ(4);
                }


                else  if(mQUANTITY<10000){
                    resultModel.setSAMPLESIZE(315+"");
                    resultModel.setCRITICAL_ACE(5);
                    resultModel.setCRITICAL_REJ(6);
                }
                else  if(mQUANTITY<35000){
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(7);
                    resultModel.setCRITICAL_REJ(8);
                }

                else  if(mQUANTITY<150000) {
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(10);
                    resultModel.setCRITICAL_REJ(11);
                }
                else  if(mQUANTITY<500000){
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(14);
                    resultModel.setCRITICAL_REJ(15);
                }
                else {
                    resultModel.setSAMPLESIZE(500+"");
                    resultModel.setCRITICAL_ACE(21);
                    resultModel.setCRITICAL_REJ(22);
                }
            }
            else {

                Log.e("InlinePreLineHandler","not found");

            }
        }
        return resultModel;
    }

}
