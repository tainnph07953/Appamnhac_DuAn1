package com.example.amnhac.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amnhac.activity.PlayNhacActivity;
import com.example.amnhac.adapter.PlayNhacadapter;
import com.example.amnhac.R;

public class Fragment_Play_Danh_Sach_Cac_Bai_Hat extends Fragment {
    RecyclerView recyclerViewplaynhac;
    PlayNhacadapter playNhacadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bat_hat, container, false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewPlayBaihat);
        if (PlayNhacActivity.mangbaihat.size()>0){
            playNhacadapter = new PlayNhacadapter(getActivity(), PlayNhacActivity.mangbaihat);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playNhacadapter);
        }

            return view;
        }
}
