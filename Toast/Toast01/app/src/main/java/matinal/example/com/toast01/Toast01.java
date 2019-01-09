package matinal.example.com.toast01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Toast01 extends AppCompatActivity implements View.OnClickListener {

    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast01);

        boton1 = findViewById(R.id.boton1);
        boton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Context contexto = getApplicationContext();
        CharSequence texto = "EJEMPLO TOAST";
        int duracion = Toast.LENGTH_SHORT;
        int posX = 0;
        int posY = 500;

        Toast toast = Toast.makeText(contexto,texto,duracion);
        toast.setGravity(Gravity.CENTER | Gravity.TOP, posX, posY);
        toast.show();


    }
}
