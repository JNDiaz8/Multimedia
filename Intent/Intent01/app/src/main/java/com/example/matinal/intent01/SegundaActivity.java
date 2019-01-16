package com.example.matinal.intent01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import java.util.Date;

public class SegundaActivity extends Activity {

    TextView segunda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("Nombre");
        Date fecha = intent.getLongExtra("Fecha");

        segunda = (TextView) findViewById(R.id.segunda);
        segunda.setText(nombre + fecha);
    }


}
