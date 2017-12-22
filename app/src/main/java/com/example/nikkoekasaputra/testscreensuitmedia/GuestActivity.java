package com.example.nikkoekasaputra.testscreensuitmedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nikkoekasaputra.testscreensuitmedia.adapter.GuestAdapter;
import com.example.nikkoekasaputra.testscreensuitmedia.api.Service;
import com.example.nikkoekasaputra.testscreensuitmedia.model.Guest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private GuestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        mAdapter = new GuestAdapter(this);

        recyclerView = (RecyclerView) findViewById(R.id.list_guest);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(mAdapter);

        getClient();
    }

    public void getClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service api = retrofit.create(Service.class);

        Call<List<Guest>> call = api.getGuest();

        call.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                List<Guest> guestList = response.body();

                //Creating an String array for the ListView
                List<Guest> guests = new ArrayList<>();
                for (int i = 0; i < guestList.size(); i++) {
                    guests.add(new Guest(guestList.get(i).getNamaGuest(), guestList.get(i).getTanggalLahir(), R.drawable.ic_launcher_background));
                }

                mAdapter.setGuestList(guests);

            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}