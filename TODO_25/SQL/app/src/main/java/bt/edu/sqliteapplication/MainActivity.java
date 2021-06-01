package bt.edu.sqliteapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fName, lName, marks, id;
    Button insert, update, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName = findViewById(R.id.fname);
        lName = findViewById(R.id.lname);
        marks = findViewById(R.id.marks);
        id = findViewById(R.id.id);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fNameTXT = fName.getText().toString();
                String lNameTXT = lName.getText().toString();
                String marksTXT = marks.getText().toString();
                String idTXT = id.getText().toString();

                Boolean checkData = DB.insertData(idTXT,fNameTXT,lNameTXT,marksTXT);
                if (checkData == true) {
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fNameTXT = fName.getText().toString();
                String lNameTXT = lName.getText().toString();
                String marksTXT = marks.getText().toString();
                String idTXT = id.getText().toString();

                Boolean checkupdatedata = DB.updateData(idTXT,fNameTXT,lNameTXT,marksTXT);
                if (checkupdatedata == true) {
                    Toast.makeText(MainActivity.this, "entry updated", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "entry not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idTXT = id.getText().toString();
                int deletedRows = DB.deleteData(idTXT);
                if (deletedRows > 0) {
                    Toast.makeText(MainActivity.this, "entry deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "entry not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if (res.getCount() == 0) {
                    showMessage("Error","nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Student ID :" + res.getString(0) + "\n");
                    buffer.append("First Name :" + res.getString(1) + "\n");
                    buffer.append("Last name :" + res.getString(2) + "\n");
                    buffer.append("ITW202 marks :" + res.getString(3) + "\n\n");
                }
                showMessage("List of Students",buffer.toString());
            }
        });
    }
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
