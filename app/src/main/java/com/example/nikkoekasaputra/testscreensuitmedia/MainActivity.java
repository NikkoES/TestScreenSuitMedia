package com.example.nikkoekasaputra.testscreensuitmedia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button btnNext;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = etNama.getText().toString();
                if(nama.equals("")){
                    Toast.makeText(MainActivity.this, "Nama belum diisi !", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nama", nama);
                    i.putExtras(bundle);
                    startActivity(i);
                }
            }
        });
    }

    public void bindView(){
        etNama = (EditText) findViewById(R.id.et_nama);
        btnNext = (Button) findViewById(R.id.btn_next);
    }
}
