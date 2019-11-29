package com.example.amnhac.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.R;
import com.example.amnhac.adapter.AllAlbumAdapter;
import com.example.amnhac.interfacee.AlbumInterface;
import com.example.amnhac.model.Album;
import com.example.amnhac.presenter.AlbumPresenter;
import com.example.amnhac.service.APIService;
import com.example.amnhac.service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity implements AlbumInterface,View.OnClickListener {
    RecyclerView recyclerViewAllAlbum;
    Toolbar toolbarAllAlbum;
    AllAlbumAdapter allalbumAdapter;
    AlbumPresenter albumPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        albumPresenter = new AlbumPresenter(this);
        GetData();
        init();
    }
    private void init() {
        recyclerViewAllAlbum = findViewById(R.id.recyclerViewAllAlbum);
        toolbarAllAlbum = findViewById(R.id.toolbarallAlbum);

        setSupportActionBar(toolbarAllAlbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Các Album");
        toolbarAllAlbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> listCall = dataservice.GetTatCaAlbum();
        listCall.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(DanhsachtatcaAlbumActivity.this,2);

                allalbumAdapter = new AllAlbumAdapter(DanhsachtatcaAlbumActivity.this,albumArrayList);
                recyclerViewAllAlbum.setLayoutManager(gridLayoutManager);

                recyclerViewAllAlbum.setAdapter(allalbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.toolbarallAlbum){
            albumPresenter.ClickAlbum();
        }
    }

    @Override
    public void navigateHome() {
        finish();
    }
}
