package com.example.amnhac.presenter;

import com.example.amnhac.interfacee.BaihatInterface;

public class BaihatPresenter {
    BaihatInterface baihatInterface;
    public BaihatPresenter(BaihatInterface baihatInterface){
        this.baihatInterface = baihatInterface;
    }
    public void ClickBaiHat(){
        baihatInterface.DataIntent();
    }
}
