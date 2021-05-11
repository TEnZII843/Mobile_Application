package bt.edu.todo_16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView recview;
    private WordListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0;i<20;i++){
            mWordList.addLast("word"+ i);
        }
        recview = findViewById(R.id.recyclerview);
        mAdapter= new WordListAdapter(this,mWordList);
        recview.setAdapter(mAdapter);
        LinearLayoutManager obj = new LinearLayoutManager(this);
        recview.setLayoutManager(obj);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                //add a new word to th wordlist.
                mWordList.addLast("+ Word " + wordListSize);
                //notify hte adapter, that the data has changed
                recview.getAdapter().notifyItemInserted(wordListSize);
                //scroll to the bottom
                recview.smoothScrollToPosition(wordListSize);
            }
        });
    }
}