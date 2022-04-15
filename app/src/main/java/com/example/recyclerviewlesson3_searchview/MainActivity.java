package com.example.recyclerviewlesson3_searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    NameAdapter adapter;
    ArrayList<NameModel> item = new ArrayList<>();
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this , RecyclerView.VERTICAL , false));
        adapter = new NameAdapter(item , MainActivity.this);
        recyclerView.setAdapter(adapter);
        setnames();
        search = findViewById(R.id.txtsearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter.setFilter(charSequence.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void setnames(){
        item.add(new NameModel("sldjfoadjsf"));
        item.add(new NameModel("aksduhrouiwear"));
        item.add(new NameModel("aerwrw"));
        item.add(new NameModel("zxvczx"));
        item.add(new NameModel("bnmvbm"));
        item.add(new NameModel("iopuio"));
        item.add(new NameModel("tyurttyu"));
        item.add(new NameModel("sdfghyti"));
        item.add(new NameModel("pbvl[n"));
        item.add(new NameModel("powire"));
        item.add(new NameModel("xclnvkjvsad"));
        item.add(new NameModel("epwijoit"));
        item.add(new NameModel("kjxcnvijasd"));
        item.add(new NameModel("pweijoriw"));
        item.add(new NameModel("xcjnbin"));
        item.add(new NameModel("oiehriuqwg"));
        item.add(new NameModel("lbjadfnfdb"));
        item.add(new NameModel("osajbgisa"));
        item.add(new NameModel("asndgifja"));
        item.add(new NameModel("oasndgjika"));
        item.add(new NameModel("kjadbsfkh"));
        item.add(new NameModel("askjbdvhibbsdn"));
        item.add(new NameModel("xvlcnbsdbirw"));
        item.add(new NameModel("ethweiubt"));
        item.add(new NameModel("afeef"));
        adapter.notifyDataSetChanged();
    }
}