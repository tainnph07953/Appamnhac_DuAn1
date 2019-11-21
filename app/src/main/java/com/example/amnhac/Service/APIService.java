package com.example.amnhac.Service;

/**
 * Created by KhoaPhamPC on 4/12/2017.
 */

public class APIService {

    private static final String Base_URL = "https://appnghenhacc.000webhostapp.com/Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(Base_URL).create(Dataservice.class);
    }
}
