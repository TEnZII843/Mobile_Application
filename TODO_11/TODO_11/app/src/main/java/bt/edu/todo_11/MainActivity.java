package bt.edu.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView colorText;

    private String[] colors = {"purple_200","purple_700","Dark_blue","teal_200","teal_700","black","white","red","yellow","orange","pink","brown"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorText = findViewById(R.id.text);
    }

    public void changecolor(View view) {
        Random random = new Random();
        String colorName = colors[random.nextInt(12)];

        int DifferentColours = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());

        int colorRes = ContextCompat.getColor(this,DifferentColours);
        colorText.setTextColor(colorRes);

    }
}