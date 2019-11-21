package com.example.amnhac.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.Activity.DanhsachtatcaAlbumActivity;
import com.example.amnhac.Adapter.AlbumAdapter;
import com.example.amnhac.Model.Album;
import com.example.amnhac.R;
import com.example.amnhac.Service.APIService;
import com.example.amnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Album_Hot extends Fragment {
    View view;
    RecyclerView recyclerViewalbum;
    AlbumAdapter albumAdapter;
    TextView txtxemthemalbuml;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album_hot,container,false);
        recyclerViewalbum = view.findViewById(R.id.recyclerViewAlbum);
        txtxemthemalbuml = view.findViewById(R.id.textviewxemthemalbum);
        txtxemthemalbuml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaAlbumActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }
    private void GetData(){
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbumHot();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> albumArrayList = (ArrayList<Album>) response.body();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

                albumAdapter = new AlbumAdapter(getActivity(),albumArrayList);
                recyclerViewalbum.setLayoutManager(linearLayoutManager);

                recyclerViewalbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
