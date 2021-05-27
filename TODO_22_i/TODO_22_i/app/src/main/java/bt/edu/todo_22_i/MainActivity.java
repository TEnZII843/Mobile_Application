package bt.edu.todo_22_i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mBookInput;
    private TextView mtitleText;
    private TextView mAuthorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = (EditText)findViewById(R.id.bookinput);
        mtitleText = (TextView)findViewById(R.id.titleText);
        mAuthorText = (TextView)findViewById(R.id.authorText);
    }
    public void searchBook(View view) {
        String queryString = mBookInput.getText().toString();
        new Fetchbook(mtitleText,mAuthorText).execute(queryString);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0) {
            new Fetchbook(mtitleText, mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mtitleText.setText("Loading");
        } else {
            if (queryString.length() == 0) {
                mAuthorText.setText("");
                mtitleText.setText("no_search_term");
            } else {
                mAuthorText.setText("");
                mtitleText.setText("No network");
            }
        }


    }
}