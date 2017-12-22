package com.example.nikkoekasaputra.testscreensuitmedia;

import android.content.Intent;
import android.net.Uri;
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

    static final int PICK_EVENT_REQUEST = 1;
    static final int PICK_GUEST_REQUEST = 2;

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
                startActivityForResult(i, PICK_EVENT_REQUEST);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, GuestActivity.class);
                startActivityForResult(i, PICK_GUEST_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==PICK_EVENT_REQUEST) {
            if (resultCode==RESULT_OK) {
                btnEvent.setText(data.getStringExtra("result"));
            }
        }
        else if(requestCode==PICK_GUEST_REQUEST){
            if(resultCode==RESULT_OK){
                btnGuest.setText(data.getStringExtra("result"));
            }
        }
    }

    public void bindView(){
        tvNama = (TextView) findViewById(R.id.tv_nama);
        btnEvent = (Button) findViewById(R.id.btn_event);
        btnGuest = (Button) findViewById(R.id.btn_guest);
    }
}
