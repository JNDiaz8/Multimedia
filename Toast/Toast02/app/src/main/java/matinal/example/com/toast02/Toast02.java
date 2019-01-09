package matinal.example.com.toast02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Toast02 extends AppCompatActivity implements View.OnClickListener {

    private Button boton1;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast02);
        boton1 = findViewById(R.id.boton1);
        boton1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast toast = new Toast(getApplicationContext());
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.layout));
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        mensaje = layout.findViewById(R.id.texto);
        mensaje.setText("TOAST PERSONALIZADO");
        toast.show();
    }
}
