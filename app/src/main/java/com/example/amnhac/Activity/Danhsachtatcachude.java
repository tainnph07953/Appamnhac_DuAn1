package com.example.amnhac.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.Adapter.DanhsachtatcachudeAdapter;
import com.example.amnhac.Model.ChuDe;
import com.example.amnhac.R;
import com.example.amnhac.Service.APIService;
import com.example.amnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Danhsachtatcachude extends AppCompatActivity {
    Toolbar toolbarallchudetheloai;
    RecyclerView recyclerViewallchudetheloai;
    DanhsachtatcachudeAdapter danhsachtatcachudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ChuDe>> callback = dataservice.GetAllChude();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhsachtatcachudeAdapter = new DanhsachtatcachudeAdapter(Danhsachtatcachude.this,mangchude);
                recyclerViewallchudetheloai.setLayoutManager(new GridLayoutManager(Danhsachtatcachude.this,1));
                recyclerViewallchudetheloai.setAdapter(danhsachtatcachudeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }
    private void init() {
        toolbarallchudetheloai = findViewById(R.id.toolbarallchudetheloai);
        recyclerViewallchudetheloai = findViewById(R.id.recyclerViewAllchudetheloai);
        setSupportActionBar(toolbarallchudetheloai);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarallchudetheloai.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
