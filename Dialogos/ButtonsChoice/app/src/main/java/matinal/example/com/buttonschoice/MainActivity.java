package matinal.example.com.buttonschoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogPickerFragmentListener {

    private TextView textView;
    private MultiPickBroadcastReceiver receiver;
    private String[] partidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        textView = findViewById(R.id.textView);

        partidos = new String[]{"PP" , "PSOE", "PODEMOS", "PACMA", "VOX", "CIUDADANOS"};

        setupButtons();

        setupBroadcast();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    private void setupBroadcast() {
        receiver = new MultiPickBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(DialogMultiplePickerFragment.BROADCAST_MULTIPICK);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    private void setupButtons() {
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogSinglePickerFragment dialogFragment = DialogSinglePickerFragment.newInstance(4, partidos, getString(R.string.pick_brand));
                dialogFragment.show(getSupportFragmentManager(), DialogSinglePickerFragment.class.getSimpleName());
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogMultiplePickerFragment dialogFragment = DialogMultiplePickerFragment.newInstance(partidos, getString(R.string.pick_brands), 0, 3);
                dialogFragment.show(getSupportFragmentManager(), DialogMultiplePickerFragment.class.getSimpleName());
            }
        });
    }

    @Override
    public void getSelected(String selected) {
        textView.setText(selected);
    }

    class MultiPickBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(intent.getStringExtra(DialogMultiplePickerFragment.SELECTION));
        }
    }
}
