package matinal.example.com.dialogos02;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Dialogos02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogos02);
    }

    protected Dialog onCreateDialog(int id){
        Dialog dialogo = new Dialog(this);
        Window w = dialogo.getWindow();

        int flag = WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        w.setFlags(flag, flag);
        dialogo.setContentView(R.layout.dialogo);
        showDialog(0);
        return dialogo;
    }


}
