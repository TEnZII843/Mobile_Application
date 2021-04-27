package bt.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText firstNO;
    private EditText SecondNO;
    private TextView Result;
    private Calculator Calcu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNO = findViewById(R.id.firstno);
        SecondNO = findViewById(R.id.secondno);
        Result = findViewById(R.id.Result);
        Calcu = new Calculator();
    }

    public void ADD(View view) {
        String value1 = firstNO.getText().toString();
        String value2 = SecondNO.getText().toString();

        Double result = Calcu.add(Double.valueOf(value1),Double.valueOf(value2));
        Result.setText(String.valueOf(result));

        Log.d("Debugging ", "Hello Debugging");
    }

    public void DIV(View view) {
        String value1 = firstNO.getText().toString();
        String value2 = SecondNO.getText().toString();

        Double result = Calcu.div(Double.valueOf(value1),Double.valueOf(value2));
        Result.setText(String.valueOf(result));
    }

    public void SUB(View view) {
        String value1 = firstNO.getText().toString();
        String value2 = SecondNO.getText().toString();

        Double result = Calcu.sub(Double.valueOf(value1),Double.valueOf(value2));
        Result.setText(String.valueOf(result));
    }

    public void MUL(View view) {
        String value1 = firstNO.getText().toString();
        String value2 = SecondNO.getText().toString();

        Double result = Calcu.mul(Double.valueOf(value1),Double.valueOf(value2));
        Result.setText(String.valueOf(result));
    }
}