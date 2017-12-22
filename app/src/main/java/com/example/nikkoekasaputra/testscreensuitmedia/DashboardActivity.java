package com.example.nikkoekasaputra.testscreensuitmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {

    TextView tvNama;
    Button btnEvent, btnGuest;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bindView();

        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");

        tvNama.setText(nama);

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, EventActivity.class);
                startActivity(i);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, GuestActivity.class);
                startActivity(i);
            }
        });
    }

    public void bindView(){
        tvNama = (TextView) findViewById(R.id.tv_nama);
        btnEvent = (Button) findViewById(R.id.btn_event);
        btnGuest = (Button) findViewById(R.id.btn_guest);
    }
}
