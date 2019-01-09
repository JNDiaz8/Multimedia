package com.example.matinal.material02;

import android.animation.Animator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Toast;

public class Material02 extends AppCompatActivity {
    boolean tocado = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material02);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                android.R.interpolator.fast_out_slow_in);


        //ESCUCHADOR DEL FAB CON EL TOAST
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Material02.this, "FAB TOCADO", Toast.LENGTH_SHORT).show();

                tocado = !tocado;
                v.animate().rotation(tocado ? 45f: 0).setInterpolator(interpolador).start();
            }

        });


        //AUMENTO Y DESAUMENTO DEL BOTON
        fab.setScaleX(0);
        fab.setScaleY(0);


        fab.animate()
                .scaleX(1)
                .scaleY(1)
                .setInterpolator(interpolador)
                .setDuration(600)
                .setStartDelay(1000)
                .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                fab.animate()
                        .scaleY(0)
                        .scaleX(0)
                        .setInterpolator(interpolador)
                        .setDuration(600)
                        .start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });






    }
}
