package com.example.nikkoekasaputra.testscreensuitmedia.api;

import com.example.nikkoekasaputra.testscreensuitmedia.model.Guest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Nikko Eka Saputra on 22/12/2017.
 */

public interface Service {
    String BASE_URL = "http://dry-sierra-6832.herokuapp.com/api/";

    @GET("people")
    Call<List<Guest>> getGuest();
}