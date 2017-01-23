package com.example.dragos.foodway.functionalitati;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.example.dragos.foodway.Inregistrare;
import com.example.dragos.foodway.R;


public class LoginActivity extends ActionBarActivity {
    Button btnContNou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logare_inregistrare);

       btnContNou = (Button) findViewById(R.id.btn_cont_nou);
        btnContNou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Inregistrare.class));
            }
        });

    }
}
