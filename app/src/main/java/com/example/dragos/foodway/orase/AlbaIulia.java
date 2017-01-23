package com.example.dragos.foodway.orase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dragos.foodway.spinnersiliste.ListViewAdapter;
import com.example.dragos.foodway.R;
import com.example.dragos.foodway.spinnersiliste.SingleItemView;


public class AlbaIulia extends Activity {

    ListView lista;
    ListViewAdapter adapter;
    String[] denumire;
    String[] tip_firma;
    String[] descriere;
    String[] adresa;
    String[] program;
    String[] btn_web;
    //String[] btn_pagina_fb;
    String[] btn_call_direct;
    String[] btn_call_taxi;
    String[] linkuri_hp;
    int[] logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listafirme_albaiulia);

        Intent intent = getIntent();
        String judet = intent.getStringExtra("Judet");
        ((TextView)findViewById(R.id.judet_selectat)).setText(judet);
        Bundle bundle = intent.getExtras();
        String localitate = bundle.getString("Localitate");
        ((TextView)findViewById(R.id.oras_selectat)).setText(localitate);

        denumire = new String[] {"Complete Pizza","Steak House","Pizza Express",
                "Pizza Tortuga", "Pizza Party"};

        tip_firma = new String[] { "Pizzerie", "Restaurant", "Pizzerie",
                "Pizzerie", "Pizzerie"};

        descriere = new String[] {"    Te aşteptăm la Complete Pizza – locul unde găseşti meniuri complete, " +
                "pentru toate gusturile. La fiecare pizza comandată primeşti gratis un pahar de PEPSI sau un sos! " +
                "Complete Pizza te aşteaptă cu 24 de sortimente de pizza cu carne şi brânzeturi dar şi vegetale." +
                " Avem SWEET PIZZA cu ciocolată, pizza cu surpriză pentru copii şi pizza heart pentru îndrăgostiţi. \n" +
                "    Livrarea la domiciliu este gratuită pentru doua pizza comandate,iar pentru una singură se percepe taxă " +
                "de livrare în funcţie de zonă!\n",
                "    Restaurantul STEAK HOUSE din Alba Iulia vă oferă un meniu variat de preparate din carne de vită," +
                        " porc, pui, peşte sau preparate vegetariene, fructe de mare sau paste.\n " +
                        "    De asemenea, puteţi servi unele din cele mai rafinate vinuri tradiţionale româneşti şi italiene," +
                        " whisky, vodca, cognac sau alte băuturi alcoolice şi nealcoolice. " +
                        "Specialitatea casei sunt fripturile de vită, reţete tradiţionale, " +
                        "preparate după dorinţa dumneavoastră.\n",
                "    Făina de cea mai bună calitate, sosul de roşii preparat cu măiestrie," +
                        " legumele proaspete, mozzarella şi ingredientele atent alese, dau conturul unei pizza delicioasă," +
                        " plină de savoare cu un gust aparte! \n",
                "    Din meniul nostru vei avea de unde alege o pizza coaptă pe vatră in cuptor cu lemne, " +
                        "aici in Alba Iulia, pregatită atent de bucătarul nostru.Poţi comanda pizza in Alba Iulia " +
                        "cu livrare la domiciliu , diverse sortimente de salate si paste,  făcute după reţete tradiţionale.\n" +
                        "    In prepararea tuturor produselor noastre se folosesc numai ingrediente de cea mai bună calitate .\n",
                "    Pizza Party Alba Iulia vă invită la o pizza gustoasă,coaptă pe vatră!" +
                        " La minim 5 pizza comandate asigurăm transportul gratuit sau un suc pepsi,cola sau fanta." +
                        "De asemenea vă oferă gratuit ketchup sau sos de rosii, cutie pizza şi peperoncini!Vă asteptăm cu drag !\n"};

        logo = new int[] { R.drawable.complete_pizza, R.drawable.steak_house,
                R.drawable.pizza_express, R.drawable.pizzeria_tortuga,
                R.drawable.pizzaparty };

        adresa = new String[] {"  Adresa :\n"+" Str. Vanatorilor,\n"+"  Nr.21",
                "  Adresa :\n" +"  Str. Calea Mo?ilor,  \n"+"  Nr.67",
                "  Adresa :\n" +"  Str. Energiei, Nr.15",
                "  Adresa :\n" +"  B-dul Transilvaniei, \n"+"  (partea cu parcul)",
                "  Adresa :\n" +"  B-dul Transilvaniei,\n"+"  Nr.9, bl.20"};

        program = new String[]{"  Program:\n"+"  10:00 - 22:30\n"+"  (Luni-Sambata)\n"+
                "  11:30 - 22:30\n"+"  (Duminica)",
                "  Program:\n"+"  10:30 - 24:00\n"+"  (Luni-Vineri)\n"+
                        "  14:30 - 24:00\n"+"  (Sambata-Duminica)",
                "  Program:\n"+"  10:30 - 24:00\n"+"  (Luni-Vineri)\n"+
                        "  14:30 - 24:00\n"+"  (Sambata-Duminica)",
                "  Program:\n"+"  09:00 - 24:00\n"+"  (Luni-Vineri)\n"+
                        "  10:00 - 24:00\n"+"  (Sambata-Duminica)",
                "  Program:\n"+" 11:00 - 22:00 (Zilnic)\n"};

        btn_web = new String[]{"www.completepizza.ro","www.marcosteakhouse.ro",
                "www.pizza-express.ro","www.pizzatortuga.ro","Pagina Web"};

        //btn_pagina_fb = new String[]{"facebook","facebook","facebook","facebook","facebook"};

        btn_call_direct = new String[]{"( 0744 299 399 )",
                "( 0728.162.962 )",
                "( 0754 685 681 )",
                "( 0749 339 742 )",
                "( 0753.908.595 )"};

        btn_call_taxi = new String[]{"( 912 )",
                "( 912 )",
                "( 912 )",
                "( 912 )",
                "( 912 )"};
        linkuri_hp = new String[]{"http://www.completepizza.ro","http://www.marcosteakhouse.ro",
                "http://www.pizza-express.ro","http://www.pizzatortuga.ro"," "};

        lista = (ListView) findViewById(R.id.lista_firme);
        adapter = new ListViewAdapter(this, denumire, tip_firma, logo, descriere,adresa,program,
                btn_web,/*btn_pagina_fb*/btn_call_direct,btn_call_taxi,linkuri_hp);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(AlbaIulia.this, SingleItemView.class);
                i.putExtra("denumire", denumire);
                i.putExtra("tip_firma", tip_firma);
                i.putExtra("descriere", descriere);
                i.putExtra("logo", logo);
                i.putExtra("adresa",adresa);
                i.putExtra("program",program);
                i.putExtra("btn_web",btn_web);
                //i.putExtra("btn_pagina_fb",btn_pagina_fb);
                i.putExtra("btn_call_direct",btn_call_direct);
                i.putExtra("btn_call_taxi",btn_call_taxi);
                //i.putExtra("linkuri_hp",linkuri_hp);
                i.putExtra("position", position);
                startActivity(i);
            }

        });
    }
}
