package com.example.amnhac.presenter;

import com.example.amnhac.interfacee.AlbumInterface;

public class AlbumPresenter {
    AlbumInterface albumview;
    public AlbumPresenter(AlbumInterface albumview){
        this.albumview = albumview;
    }
    public void ClickAlbum(){
        albumview.navigateHome();

    }


}
