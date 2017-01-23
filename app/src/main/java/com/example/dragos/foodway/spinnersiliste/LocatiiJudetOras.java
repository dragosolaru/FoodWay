package com.example.dragos.foodway.spinnersiliste;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.dragos.foodway.R;


public class LocatiiJudetOras extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner s1, s2;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectie_judet_oras);
        addListenerOnButton();

        s1 = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                R.array.lista_judete, R.layout.spinner_item_text);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.notifyDataSetChanged();
        s1.setAdapter(dataAdapter);

        s2 = (Spinner) findViewById(R.id.spinner2);
        s1.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {

        String sp1 = String.valueOf(s1.getSelectedItem());
      /*  Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();*/

        if (sp1.contentEquals("Alba")) {
/*
            List<String> list = new ArrayList<>();
            list.add("Alba-Iulia");
            list.add("Aiud");
            list.add("Blaj");
            list.add("Cugir");
            list.add("Sebes");*/

            ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lista_alba, R.layout.spinner_item_text);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if (sp1.contentEquals("Brasov")) {
/*
            List<String> list = new ArrayList<>();
            list.add("Brasov");
            list.add("Fagaras");
            list.add("Sacele");
            list.add("Rasnov");
            list.add("Zamesti");*/

            ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lista_brasov, R.layout.spinner_item_text);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if (sp1.contentEquals("Cluj")) {

      /*      List<String> list = new ArrayList<>();
            list.add("Cluj-Napoca");
            list.add("Dej");
            list.add("Gherla");
            list.add("Floresti");
            list.add("Turda");*/

            ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lista_cluj, R.layout.spinner_item_text);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if (sp1.contentEquals("Hunedoara")) {

       /*     List<String> list = new ArrayList<>();
            list.add("Deva");
            list.add("Hunedoara");
            list.add("Petrosani");
            list.add("Vulcan");
            list.add("Lupeni");*/

            ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lista_hunedoara, R.layout.spinner_item_text);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if (sp1.contentEquals("Sibiu")) {

          /*  List<String> list = new ArrayList<>();
            list.add("Sibiu");
            list.add("Medias");
            list.add("Cisnadie");
            list.add("Avrig");
            list.add("Dumbraveni");*/

            ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this,
                    R.array.lista_sibiu, R.layout.spinner_item_text);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
    }

    public void addListenerOnButton() {

        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        btn = (Button) findViewById(R.id.btn_selectie);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(LocatiiJudetOras.this,
                        "Ati selectat:  " +
                                "\nJudetul : " + String.valueOf(s1.getSelectedItem()) +
                                "\nLocalitatea : " + String.valueOf(s2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();

                if (s1.getSelectedItem().equals("Alba") && s2.getSelectedItem().equals("Alba-Iulia")) {
                    Intent intent = new Intent("com.example.dragos.foodway.orase.Alba_Iulia");
                    intent.putExtra("Judet", "Alba");
                    Bundle extras = new Bundle();
                    extras.putString("Localitate", "Alba-Iulia");
                    intent.putExtras(extras);
                    startActivity(intent);
                }


                if (s1.getSelectedItem().equals("Cluj") && s2.getSelectedItem().equals("Cluj-Napoca"))
                {
                    Intent intent = new Intent("com.example.dragos.foodway.orase.Cluj_Napoca");
                    intent.putExtra("Judet", "Cluj");
                    Bundle extras = new Bundle();
                    extras.putString("Localitate", "Cluj-Napoca");
                    intent.putExtras(extras);
                    startActivity(intent);
                }
                if (s1.getSelectedItem().equals("Brasov") && s2.getSelectedItem().equals("Brasov"))
                {
                    Intent intent = new Intent("com.example.dragos.foodway.orase.Brasov");
                    intent.putExtra("Judet", "Brasov");
                    Bundle extras = new Bundle();
                    extras.putString("Localitate", "Brasov");
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
       });
    }



    @Override
    public void onNothingSelected(AdapterView<?> arg0) {


    }
}

/*
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
        addItemsOnSpinner2(this);
    }

    public void addItemsOnSpinner2(AdapterView<?> parent, View view, int position,
                                   long id) {

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        List list_a = new ArrayList();
        list_a.add("Alba-Iulia");
        list_a.add("Sebes");
        list_a.add("Aiud");
        list_a.add("Cugir");
        list_a.add("Blaj");

        List list_b = new ArrayList();
        list_b.add("Brasov");
        list_b.add("Sacele");
        list_b.add("Fagaras");
        list_b.add("Zamesti");

        List list_c = new ArrayList();
        list_c.add("Cluj-Napoca");
        list_c.add("Dej");
        list_c.add("Floresti");
        list_c.add("Gherla");
        list_c.add("Turda");


        if (position == 0) {

            ArrayAdapter dataAdapter_a = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_a);
            dataAdapter_a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(dataAdapter_a);

        }

        if (position == 1) {

            ArrayAdapter dataAdapter_b = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_b);
            dataAdapter_b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(dataAdapter_b);

        }

        if (position == 2) {

            ArrayAdapter dataAdapter_c = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list_c);
            dataAdapter_c.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(dataAdapter_c);


        }
    }



    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new));
    }

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btn = (Button) findViewById(R.id.btn_selectie);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "Ati selectat:  " +
                                "\nJudetul : " + String.valueOf(spinner1.getSelectedItem()) +
                                "\nLocalitatea : " + String.valueOf(spinner2.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

        });

    }*/


