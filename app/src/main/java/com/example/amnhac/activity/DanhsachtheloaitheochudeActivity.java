package com.example.amnhac.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.adapter.DanhsachtheloaitheochudeAdapter;
import com.example.amnhac.model.ChuDe;
import com.example.amnhac.model.TheLoai;
import com.example.amnhac.R;
import com.example.amnhac.service.APIService;
import com.example.amnhac.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {
    RecyclerView recyclerViewtheloaitheochude;
    Toolbar toolbartheloaithechude;
    DanhsachtheloaitheochudeAdapter danhsachtheloaitheochudeAdapter;
    ChuDe chuDe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        GetIntent();
        GetData();
        init();
    }

    private void init() {
        recyclerViewtheloaitheochude = findViewById(R.id.recyclerviewtheloaitheochude);
        toolbartheloaithechude = findViewById(R.id.toolbartheloaitheochude);
        setSupportActionBar(toolbartheloaithechude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chuDe.getTenChuDe());
        toolbartheloaithechude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<TheLoai>> listCall = dataservice.GetTheloaitheochude(chuDe.getIdChuDe());
        listCall.enqueue(new Callback<List<TheLoai>>() {
            @Override
            public void onResponse(Call<List<TheLoai>> call, Response<List<TheLoai>> response) {
                ArrayList<TheLoai> mangtheloai = (ArrayList<TheLoai>) response.body();
                danhsachtheloaitheochudeAdapter = new DanhsachtheloaitheochudeAdapter(DanhsachtheloaitheochudeActivity.this,mangtheloai);
                recyclerViewtheloaitheochude.setLayoutManager(new GridLayoutManager(DanhsachtheloaitheochudeActivity.this,2));
                recyclerViewtheloaitheochude.setAdapter(danhsachtheloaitheochudeAdapter);
            }

            @Override
            public void onFailure(Call<List<TheLoai>> call, Throwable t) {

            }
        });
    }



    private void GetIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("chude")) {
            chuDe = intent.getParcelableExtra("chude");

        }
    }
}
