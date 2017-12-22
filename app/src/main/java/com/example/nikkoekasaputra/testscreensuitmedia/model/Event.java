package com.example.nikkoekasaputra.testscreensuitmedia.model;

/**
 * Created by Nikko Eka Saputra on 22/12/2017.
 */

public class Event {

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private String mNamaEvent, mTanggalEvent;

    public Event(int imageResourceId, String namaEvent, String tanggalEvent) {
        mImageResourceId = imageResourceId;
        mNamaEvent = namaEvent;
        mTanggalEvent = tanggalEvent;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getNamaEvent() {
        return mNamaEvent;
    }

    public String getTanggalEvent() {
        return mTanggalEvent;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
