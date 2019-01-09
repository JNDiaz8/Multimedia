package com.example.matinal.ejercicio_01a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity01a extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity01a);
    }

    public void boton1(View view) {
        Intent intent = new Intent(this, Activity01c.class);
        startActivity(intent);
    }

    public void boton2(View view) {
        Intent intent = new Intent(this, Activity01e.class);
        startActivity(intent);
    }

    public void onPause() {
        super.onPause();
        finish();
    }

}
