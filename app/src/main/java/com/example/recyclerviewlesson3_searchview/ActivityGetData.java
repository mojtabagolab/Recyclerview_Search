package com.example.recyclerviewlesson3_searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityGetData extends AppCompatActivity {
    TextView txtshow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        txtshow2 = findViewById(R.id.txtshowtwo);
        String nametwo = getIntent().getExtras().getString("namekey");
        txtshow2.setText(nametwo);
    }
}