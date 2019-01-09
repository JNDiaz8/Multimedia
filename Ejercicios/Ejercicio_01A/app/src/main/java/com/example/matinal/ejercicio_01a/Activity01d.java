package com.example.matinal.ejercicio_01a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity01d extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity01d);
    }

    public void boton1(View view) {
        Intent intent = new Intent(this, Activity01a.class);
        startActivity(intent);
        finish();
    }

}
