package com.example.dragos.foodway.spinnersiliste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dragos.foodway.R;


public class ListViewAdapter extends BaseAdapter {

    Context context;
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
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] denumire, String[] tip_firma,
                           int[] logo, String[]descriere, String[]adresa, String[]program,
                           String[]btn_web,/*String[]btn_pagina_fb*/String[]btn_call_direct,
                           String[]btn_call_taxi,String[]linkuri_hp) {
        this.context = context;
        this.denumire = denumire;
        this.tip_firma = tip_firma;
        this.descriere = descriere;
        this.adresa = adresa;
        this.program=program;
        this.btn_web=btn_web;
        //this.btn_pagina_fb=btn_pagina_fb;
        this.btn_call_direct=btn_call_direct;
        this.btn_call_taxi=btn_call_taxi;
        this.linkuri_hp=linkuri_hp;
        this.logo = logo;
    }

    @Override
    public int getCount() {
        return denumire.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtdenumire;
        TextView txttip_firma;
        ImageView imglogo;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);

        txtdenumire = (TextView) itemView.findViewById(R.id.denumire);
        txttip_firma= (TextView) itemView.findViewById(R.id.tip_firma);
        imglogo = (ImageView) itemView.findViewById(R.id.logo);

        txtdenumire.setText(denumire[position]);
        txttip_firma.setText(tip_firma[position]);
        imglogo.setImageResource(logo[position]);

        return itemView;
    }

}
