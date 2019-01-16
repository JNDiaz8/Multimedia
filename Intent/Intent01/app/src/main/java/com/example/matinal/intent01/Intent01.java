package com.example.matinal.intent01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Intent01 extends AppCompatActivity {

    public final static String nombre = "Nombre";
    int date = Calendar.getInstance().get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent01);
    }

    public void boton1(View view){
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra(nombre, "Joaquin Diaz Ramirez");
        intent.putExtra("date", Calendar.YEAR);
        startActivity(intent);
    }
}
