package com.example.amnhac.presenter;

import com.example.amnhac.interfacee.ChuDeInterface;

public class ChudePresenter {
    ChuDeInterface chuDeInterface;
    public ChudePresenter(ChuDeInterface chuDeInterface){
        this.chuDeInterface = chuDeInterface;
    }
    public void ClickChuDe(){
        chuDeInterface.init();
        chuDeInterface.GetData();
    }
}
