package matinal.example.com.sensores02;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sensores02 extends AppCompatActivity implements SensorEventListener {

    int contador ;
    double x, y, z, a, amax = 0;
    double gravedad = SensorManager.STANDARD_GRAVITY;
    TextView tvax, tvay, tvaz, tva, tvaMax, tvG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores02);

        tvax = findViewById(R.id.ejex);
        tvay = findViewById(R.id.ejey);
        tvaz = findViewById(R.id.ejez);
        tva = findViewById(R.id.aceleracion);
        tvaMax = findViewById(R.id.aceleracionMax);
        tvG = findViewById(R.id.gravedadEstandar);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometro, SensorManager.SENSOR_DELAY_FASTEST);

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
        protected Void doInBackground(Void... voids) {
            while (true){
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
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            tvax.setText("" + x);
            tvay.setText("" + y);
            tvaz.setText("" + z);
            tva.setText("" + a);
            tvaMax.setText(""+ amax);
            tvG.setText(""+ gravedad);
            tvG.append("\n" + "CONTADOR: " + contador);
        }
    }
}
