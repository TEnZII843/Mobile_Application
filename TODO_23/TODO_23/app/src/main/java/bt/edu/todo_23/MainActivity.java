package bt.edu.todo_23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";
    private CustomReceiver mReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mReciever = new CustomReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(mReciever,filter);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(mReciever,new IntentFilter(ACTION_CUSTOM_BROADCAST));


    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReciever);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReciever);
        super.onDestroy();

    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent  = new Intent (ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}