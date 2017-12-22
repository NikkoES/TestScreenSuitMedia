package com.example.nikkoekasaputra.testscreensuitmedia.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikko Eka Saputra on 22/12/2017.
 */

public class Guest {

    @SerializedName("name")
    private String mNamaGuest;

    @SerializedName("birthdate")
    private String mTanggalLahir;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Guest(String namaGuest, String tanggalLahir, int imageResourceId) {
        mNamaGuest = namaGuest;
        mTanggalLahir = tanggalLahir;
        mImageResourceId = imageResourceId;
    }

    public String getNamaGuest() {
        return mNamaGuest;
    }

    public String getTanggalLahir() {
        return mTanggalLahir;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
