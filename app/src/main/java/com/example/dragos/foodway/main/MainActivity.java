package com.example.dragos.foodway.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.dragos.foodway.R;


public class MainActivity extends Activity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final Vibrator vibe=(Vibrator)MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                    Intent intentiePagina2=new Intent(getApplicationContext(),MeniulPrincipal.class);
                   startActivity(intentiePagina2);
                    vibe.vibrate(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();


        view = findViewById(R.id.primul_act);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                Intent meniu = new Intent(getApplicationContext(), MeniulPrincipal.class);
                startActivity(meniu);
                vibe.vibrate(100);
                return false;
            }
        });

    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
