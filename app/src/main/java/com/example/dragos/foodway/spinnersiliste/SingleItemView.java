package com.example.dragos.foodway.spinnersiliste;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dragos.foodway.R;
import com.facebook.CallbackManager;
import com.facebook.share.widget.LikeView;
import com.shamanland.facebook.likebutton.FacebookLikeButton;


public class SingleItemView extends Activity {

    TextView txt_denumire;
    TextView txt_tip_firma;
    TextView txt_descriere;
    TextView txt_adresa;
    TextView txt_program;
    TextView txt_btn_web;
    TextView txt_btn_pagina_fb;
    TextView txt_btn_call_direct;
    TextView txt_btn_call_taxi;
    TextView txt_linkuri_hp;
    ImageView img_logo;

    String[] denumire;
    String[] tip_firma;
    String[] descriere;
    String[] adresa;
    String[] program;
    String[] btn_web;
    String[] btn_pagina_fb;
    String[] btn_call_direct;
    String[] btn_call_taxi;
    String[] linkuri_hp;
    int[] logo;
    int position;

    LinearLayout btnLoginToLike;
    LikeView likeView;
    CallbackManager callbackManager;

    FacebookLikeButton fbLike;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);

        FacebookLikeButton fbLike = (FacebookLikeButton)findViewById(R.id.btn_like);

       // fbLike.setPageUrl("https://www.facebook.com/completepizza?fref=ts");
       // fbLike.setPageTitle("Complete Pizza");

        Button btn_call_d = (Button) findViewById(R.id.btn_call_direct);
        btn_call_d.setOnClickListener(call_direct);
        Button btn_call_t = (Button) findViewById(R.id.btn_call_taxi);
        btn_call_t.setOnClickListener(call_taxi);
        Button btn_webpage = (Button) findViewById(R.id.btn_web);
        btn_webpage.setOnClickListener(link_web);
        //Button btn_fbpage = (Button) findViewById(R.id.btn_pagina_fb);
        //btn_fbpage.setOnClickListener(link_fb);

        Intent i = getIntent();

        position = i.getExtras().getInt("position");
        denumire = i.getStringArrayExtra("denumire");
        tip_firma = i.getStringArrayExtra("tip_firma");
        descriere = i.getStringArrayExtra("descriere");
        adresa = i.getStringArrayExtra("adresa");
        program = i.getStringArrayExtra("program");
        btn_web = i.getStringArrayExtra("btn_web");
        //btn_pagina_fb=i.getStringArrayExtra("btn_pagina_fb");
        btn_call_direct=i.getStringArrayExtra("btn_call_direct");
        btn_call_taxi=i.getStringArrayExtra("btn_call_taxi");
        linkuri_hp=i.getStringArrayExtra("linkuri_hp");
        logo = i.getIntArrayExtra("logo");

        txt_denumire = (TextView) findViewById(R.id.denumire);
        txt_tip_firma = (TextView) findViewById(R.id.tip_firma);
        txt_descriere = (TextView) findViewById(R.id.descriere);
        txt_descriere.setMovementMethod(new ScrollingMovementMethod());
        txt_adresa = (TextView)findViewById(R.id.adresa);
        txt_program = (TextView)findViewById(R.id.program);
        txt_btn_web = (TextView)findViewById(R.id.btn_web);
        //txt_btn_pagina_fb=(TextView)findViewById(R.id.btn_pagina_fb);
        txt_btn_call_direct=(TextView)findViewById(R.id.btn_call_direct);
        txt_btn_call_taxi=(TextView)findViewById(R.id.btn_call_taxi);
        txt_linkuri_hp = (TextView)findViewById(R.id.btn_web);
        img_logo = (ImageView) findViewById(R.id.logo);

        txt_denumire.setText(denumire[position]);
        txt_tip_firma.setText(tip_firma[position]);
        txt_descriere.setText(descriere[position]);
        txt_adresa.setText(adresa[position]);
        txt_program.setText(program[position]);
        txt_btn_web.setText(btn_web[position]);
        //txt_btn_pagina_fb.setText(btn_pagina_fb[position]);
        txt_btn_call_direct.setText(btn_call_direct[position]);
        txt_btn_call_taxi.setText(btn_call_taxi[position]);
        img_logo.setImageResource(logo[position]);

        if(txt_denumire.getText().equals("Complete Pizza")) {
            fbLike.setPageUrl("https://www.facebook.com/completepizza?fref=ts");
            fbLike.setPageTitle("Complete Pizza");
            fbLike.setPagePictureUrl("");
            fbLike.setPageText("Like us on Facebook");
        }
        if (txt_denumire.getText().equals("Steak House")) {
            fbLike.setPageUrl("https://www.facebook.com/steak.house.9887?fref=ts");
            fbLike.setPageTitle("Steak House");
            fbLike.setPagePictureUrl("");
            fbLike.setPageText("Like us on Facebook");
        }
        if (txt_denumire.getText().equals("Pizza Express")) {
            fbLike.setPageUrl("https://www.facebook.com/pizzaexpress.albaiulia");
            fbLike.setPageTitle("Pizza Express");
            fbLike.setPagePictureUrl("");
            fbLike.setPageText("Like us on Facebook");
        }
        if (txt_denumire.getText().equals("Pizza Tortuga")) {
            fbLike.setPageUrl("https://www.facebook.com/pages/Pizzeria-Tortuga/383040598429136?fref=ts");
            fbLike.setPageTitle("Pizza Tortuga");
            fbLike.setPagePictureUrl("");
            fbLike.setPageText("Like us on Facebook");
        }
        if (txt_denumire.getText().equals("Pizza Party")) {
            fbLike.setPageUrl("https://www.facebook.com/pages/Pizza-Party-Alba-Iulia/140274812741591?sk=info&tab=overview");
            fbLike.setPageTitle("Pizza Party");
            fbLike.setPagePictureUrl("");
            fbLike.setPageText("Like us on Facebook");
        }


    }/*
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        likeView.handleOnActivityResult(this, requestCode, resultCode, data);
    }*/

    private View.OnClickListener call_direct = new View.OnClickListener() {
        public void onClick(View v){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + txt_btn_call_direct.getText().toString()));
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(callIntent);
        }
    };
    private View.OnClickListener call_taxi = new View.OnClickListener() {
        public void onClick(View v){
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + txt_btn_call_taxi.getText().toString()));
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(callIntent);
        }
    };

    private View.OnClickListener link_web = new View.OnClickListener(){

        public void onClick(View v) {

            if(txt_denumire.getText().equals("Complete Pizza"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.completepizza.ro")));


            if(txt_denumire.getText().equals("Steak House"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.marcosteakhouse.ro")));

            if(txt_denumire.getText().equals("Pizza Express"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pizza-express.ro")));

            if(txt_denumire.getText().equals("Pizza Tortuga"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pizzatortuga.ro")));

           /* if(txt_denumire.getText().equals("Pizza Party"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse()));*/
        }

    };

/*
    private View.OnClickListener link_fb = new View.OnClickListener(){
        public void onClick(View v) {



            if(txt_denumire.getText().equals("Complete Pizza"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/completepizza?fref=ts")));


            if(txt_denumire.getText().equals("Steak House"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/steak.house.9887?fref=ts")));


            if(txt_denumire.getText().equals("Pizza Express"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pizzaexpress.albaiulia")));


            if(txt_denumire.getText().equals("Pizza Tortuga"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Pizzeria-Tortuga/383040598429136?fref=ts")));


            if(txt_denumire.getText().equals("Pizza Party"))
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Pizza-Party-Alba-Iulia/140274812741591?sk=info&tab=overview")));

        }*/

    }





