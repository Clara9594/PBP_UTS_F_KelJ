package com.example.tugasbesar_pbp_f;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Car {
    public String tipe;
    public String merek;
    public int penumpang;
    public int tas;
    public String bensin;
    public int harga;
    public String imgURL;

    public Car(){}

    public Car(String tipe, String merek, int penumpang, int tas, String bensin, int harga, String imgURL) {
        this.tipe = tipe;
        this.merek = merek;
        this.penumpang = penumpang;
        this.tas = tas;
        this.bensin = bensin;
        this.harga = harga;
        this.imgURL = imgURL;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(int penumpang) {
        this.penumpang = penumpang;
    }

    public int getTas() {
        return tas;
    }

    public void setTas(int tas) {
        this.tas = tas;
    }

    public String getBensin() {
        return bensin;
    }

    public void setBensin(String bensin) {
        this.bensin = bensin;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @BindingAdapter("profileImage")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl).apply(new RequestOptions())
                .into(view);
    }
}
