package com.example.nikkoekasaputra.testscreensuitmedia;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nikkoekasaputra.testscreensuitmedia.adapter.EventAdapter;
import com.example.nikkoekasaputra.testscreensuitmedia.model.Event;
import com.example.nikkoekasaputra.testscreensuitmedia.model.Guest;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    String namaEvent, tanggalEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        final ArrayList<Event> events = new ArrayList<Event>();
        for (int i = 0; i < 5; i++) {
            events.add(new Event(R.drawable.ic_launcher_background, "Nama Event "+(i+1), (22+i)+" Desember 2017"));
        }

        EventAdapter adapter = new EventAdapter(this, events);

        ListView listView = (ListView) findViewById(R.id.list_event);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Event event = events.get(position);
                namaEvent = event.getNamaEvent();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", namaEvent);
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });
    }
}
