package com.example.amnhac.service;

import com.example.amnhac.model.Album;
import com.example.amnhac.model.Baihat;
import com.example.amnhac.model.ChuDe;
import com.example.amnhac.model.TheLoai;
import com.example.amnhac.model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();


    @GET("albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("tatcachude.php")
    Call<List<ChuDe>> GetAllChude();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> GetTheloaitheochude(@Field("idchude") String idchude);
//
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheochude(@Field("idtheloai") String idtheloai);
//
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @GET("tatcaalbum.php")
    Call<List<Album>> GetTatCaAlbum();



}
