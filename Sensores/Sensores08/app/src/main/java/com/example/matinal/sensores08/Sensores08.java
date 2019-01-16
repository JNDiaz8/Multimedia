package com.example.matinal.sensores08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Sensores08 extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor acelerometro;
    public static int x, y;
    public static int centrox, centroy = 250;
    ShapeDrawable mDibujo = new ShapeDrawable();
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores08);

        mainLayout = (LinearLayout)findViewById(R.id.lay);

        MiVistaPersonal miVista = new MiVistaPersonal(this);
        mainLayout.addView(miVista);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = centrox + (int) Math.pow(event.values[1],2);
        y = centroy + (int) Math.pow(event.values[2],2);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public class MiVistaPersonal extends View {
        final static int ancho = 100, alto = 100;

        public MiVistaPersonal(Context context) {
            super(context);

            mDibujo = new ShapeDrawable(new OvalShape());
            mDibujo.getPaint().setColor(0xff74AC23);
            mDibujo.setBounds(x, y, x + ancho, y + alto);
        }

        protected void onDraw(Canvas canvas){
            RectF oval = new RectF(Sensores08.x, Sensores08.y, Sensores08.x + ancho, Sensores08.y + alto);
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            canvas.drawOval(oval, pincel);
            invalidate();
        }

    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this);
        super.onStop();

    }
}
