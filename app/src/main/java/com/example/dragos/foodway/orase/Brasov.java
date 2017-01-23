package com.example.dragos.foodway.orase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dragos.foodway.R;


public class Brasov extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listafirme_brasov);

        Intent intent = getIntent();
        String judet = intent.getStringExtra("Judet");
        ((TextView)findViewById(R.id.judet_selectat)).setText(judet);
        Bundle bundle = intent.getExtras();
        String localitate = bundle.getString("Localitate");
        ((TextView)findViewById(R.id.oras_selectat)).setText(localitate);
    }
}
