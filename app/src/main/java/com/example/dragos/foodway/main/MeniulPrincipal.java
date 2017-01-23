package com.example.dragos.foodway.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import com.example.dragos.foodway.R;
import com.example.dragos.foodway.functionalitati.LoginActivity;
import com.example.dragos.foodway.spinnersiliste.LocatiiJudetOras;


public class MeniulPrincipal extends Activity {

//    Button btnComanda=(Button)findViewById(R.id.btnComanda);

  //  Button btnInregistrare=(Button)findViewById(R.id.btnInregistrare);

    Button btnComanda;
    Button btnWEB;
    Button btnInreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meniul_principal);
        Button btnRestaurant=(Button)findViewById(R.id.btnRestaurante);
       final Vibrator vibe=(Vibrator)MeniulPrincipal.this.getSystemService(Context.VIBRATOR_SERVICE);
        btnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                Intent location = new Intent(getApplicationContext(), LocatiiJudetOras.class);
                startActivity(location);
            }
        });
        btnWEB=(Button)findViewById(R.id.btnFoodWay);
        btnWEB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://foodway.ro")));
        }
    });
        btnInreg=(Button)findViewById(R.id.btnInregistrare);
        btnInreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        });
        btnComanda=(Button)findViewById(R.id.btnComanda);
        btnComanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                Intent location = new Intent(getApplicationContext(), LocatiiJudetOras.class);
                startActivity(location);

            }
        });
    }
}
