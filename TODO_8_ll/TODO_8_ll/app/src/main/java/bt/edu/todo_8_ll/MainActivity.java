package bt.edu.todo_8_ll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView showtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showtext = findViewById(R.id.textView);
        Intent obj = getIntent();
        Uri uri = obj.getData();
        if (uri != null) {
            String msg = uri.toString();
            showtext.setText(msg);
        }
    }
}