package bt.edu.todo_12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Donut(View view) {
        Toast.makeText(MainActivity.this, "You ordered a donut.", Toast.LENGTH_SHORT).show();
    }
    public void Icecream(View view) {
        Toast.makeText(MainActivity.this, "You ordered a Ice Cream Sandwich.", Toast.LENGTH_SHORT).show();
    }
    public void FroYo(View view) {
        Toast.makeText(MainActivity.this, "You ordered a Froyo.", Toast.LENGTH_SHORT).show();
    }

    public void Makecall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:17755316"));
        startActivity(intent);
    }
}