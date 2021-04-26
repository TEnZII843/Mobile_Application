package bt.edu.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_Tag="bt.edu.todo_8";
    private TextView website;
    private TextView location;
    private TextView Sharetext;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website = findViewById(R.id.Website);
        location = findViewById(R.id.location);
        Sharetext = findViewById(R.id.shareTxt);
    }
    public void website_method(View view) {
        String txt= website.getText().toString();
        Uri url = Uri.parse(txt);
        Intent obj = new Intent(Intent.ACTION_VIEW,url);

        if(obj.resolveActivity(getPackageManager())!= null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit intent","Error in opening intent");
        }
    }
    public void location_Method(View view) {
        String txt= location.getText().toString();
        Uri url = Uri.parse("geo:0,0?q="+txt);
        Intent obj = new Intent(Intent.ACTION_VIEW,url);

        if(obj.resolveActivity(getPackageManager())!= null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit intent","Error in opening intent");
        }
    }
    public void shareTxt_method(View view) {
        String txt = Sharetext.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share This text with:")
                .setText(txt)
                .startChooser();
    }
}