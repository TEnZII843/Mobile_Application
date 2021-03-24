package bt.edu.todo_7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mCount;
    private TextView showCount;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount =(TextView)findViewById(R.id.textView);
        button = (Button)findViewById(R.id.button);
        mCount=0;

        if(savedInstanceState != null){
            mCount = savedInstanceState.getInt("count");
            showCount.setText(String.valueOf(mCount));
        }
    }

    public void countUp(View view) {
        mCount++;
        if (showCount != null)
            showCount.setText(Integer.toString(mCount));

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",mCount);

    }
}
