package bt.edu.todo_12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "bt.edu.todo_12.extra.MESSAGE";
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
    public void Donut(View view) {
        message = getString(R.string.donut);
        displayToast(message);
    }
    public void Icecream(View view) {
        message = getString(R.string.icecream);
        displayToast(message);
    }
    public void FroYo(View view) {
        message = getString(R.string.froyo);
        displayToast(message);
    }

    public void order(View view) {
        Intent intent = new Intent(MainActivity.this,Order_Activity.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.action_order:
                Intent intent = new Intent(this,Order_Activity.class);
                intent.putExtra(EXTRA_MESSAGE,message);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                displayToast("you selected contact.");
                return true;
            case R.id.action_favourites:
                displayToast("You selected favorites.");
                return true;
            case R.id.action_status:
                displayToast("You selected status");
                return true;

        }
        return true;
    }


}