package matinal.example.com.sensores04;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores04 extends AppCompatActivity implements SensorEventListener {

    int contador ;
    boolean continuar = true ;
    double x, y, z, a, amax = 0;
    double campoTierraMax = SensorManager.MAGNETIC_FIELD_EARTH_MAX;
    double campoTierraMin = SensorManager.MAGNETIC_FIELD_EARTH_MIN;
    TextView tvax, tvay, tvaz, tva, tvaMax, tvG, cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores04);

        tvax = findViewById(R.id.campox);
        tvay = findViewById(R.id.campoy);
        tvaz = findViewById(R.id.campoz);
        tva = findViewById(R.id.bmodulo);
        tvaMax = findViewById(R.id.campoterres);
        tvG = findViewById(R.id.campotierra);
        cont = findViewById(R.id.contador);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor campo =sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this,campo, SensorManager.SENSOR_DELAY_NORMAL);
        new MiAsyncTask().execute();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        a = Math.sqrt(x * x + y * y + z * z);
        if (a > amax) amax = a;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class MiAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... arg0) {
            while(true){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                contador++;
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Void... progress) {
            super.onProgressUpdate(progress);
            tvax.setText(" " + x);
            tvay.setText(" " + y);
            tvaz.setText(" " + z);
            tva.setText(" " + a);
            tvaMax.setText(" " + amax);
            tvG.setText(" " + campoTierraMin + "-" + campoTierraMax);
            cont.setText("CONTADOR: " + contador);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        continuar = true;
        new MiAsyncTask().execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        continuar = false;
    }
}
